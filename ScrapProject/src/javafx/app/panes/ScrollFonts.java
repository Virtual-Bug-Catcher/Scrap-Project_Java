package javafx.app.panes;
/*
 * This class will host a control panel to check Fonts and their styles/sizes
 * 
 * 
 */
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.*;

import java.util.List;
import java.util.ArrayList;

//Personal
import javafx.app.MainStage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;

public class ScrollFonts extends PaneHost{
	
	public final int ID = 102;
	
	//Global Variables
	public MainStage mainStage;
	
	//Global GUI variables
	public int vpad = 15;
	public int fontSize = 20;
	public ArrayList<String> fontFamily = new ArrayList<>();
	public List listFonts;
	public TextField txtfSize, txtfPreview;
	public Button btnBack, btnRefresh, btnPreview;
	public Text txtPreview;
	public ChoiceBox chbFonts;
	public ObservableList obsListFonts;
	
	public ScrollFonts(){
		super.PANEID = ID;
	}
	public ScrollFonts(MainStage mStage){ 
		mainStage = mStage;
		super.PANEID = ID;
		
		createScrollPane();
		createCommands();
		createTextSample();
		}
	
	public void createScrollPane(){
		
		//Variables for loop
		Text txtFontFamilies;
		Font font = new Font(fontSize);
		String note = "";
		
		listFonts = font.getFamilies();
		
		ScrollPane scrPane = new ScrollPane();
		scrPane.setMinWidth(800);
		scrPane.setMaxWidth(350);
		scrPane.setMaxWidth(800);
		scrPane.setMaxHeight(350);
		
		GridPane gPane = new GridPane();
//		gPane.setVgap(1);
//		gPane.setHgap(1);
		gPane.setPadding(new Insets(2,2,2,2));
		
		
		
		for(int i = 0; i < listFonts.size(); i++){
			txtFontFamilies = new Text();
			note = listFonts.get(i).toString();
			if(!(fontFamily.size() > 0))
				fontFamily.add(note);
			font = new Font(note, fontSize);
			txtFontFamilies.setFont(font);
			txtFontFamilies.setText(note + "\n");
			
			gPane.add(txtFontFamilies, 0, i);
		}
		
		gPane.setLayoutX(0);
		gPane.setLayoutY(0);
		
		scrPane.setContent(gPane);
		
		scrPane.setLayoutX(0);
		scrPane.setLayoutY(0);
		
		getChildren().add(scrPane);
		
	}
	
	public void createCommands(){
		Text txtSize = new Text("Text Size:");
		txtSize.setLayoutX(15);
		txtSize.setLayoutY(350 + vpad + 15);
		
		txtfSize = new TextField();
		txtfSize.setPrefColumnCount(5);
		txtfSize.setLayoutX(80);
		txtfSize.setLayoutY(350 + vpad);
		
		btnRefresh = new Button("Set Text Size");
		btnRefresh.setLayoutX(100);
		btnRefresh.setLayoutY(450 - btnRefresh.getHeight());
		btnRefresh.setOnAction(e ->{
			refreshPane();
		});
		
		getChildren().addAll(txtSize, txtfSize, btnRefresh);
		
	}
	
	public void createTextSample(){
		Text txtSample = new Text("Text Example:");
		txtSample.setLayoutX(270);
		txtSample.setLayoutY(350 + vpad + 15);
		
		txtfPreview = new TextField();
		txtfPreview.setLayoutX(350);
		txtfPreview.setLayoutY(350 + vpad);
		
		txtPreview = new Text("");
		txtPreview.setLayoutX(350);
		txtPreview.setLayoutY(350 + vpad + 50);
		
		btnPreview = new Button("Preview Text");
		btnPreview.setLayoutX(550);
		btnPreview.setLayoutY(450 - btnPreview.getHeight());
		btnPreview.setOnAction(e ->{
			//Grab text from TiextField
			String hold = txtfPreview.getText();
			//Will have drop down that will hold String values for fonts, make new Font based on that.
			String fontHold;
			try{
				//Try to grab selected font, if nothing then catch it and set font to arial.
				fontHold = chbFonts.getValue().toString();
			}catch(NullPointerException ex){ fontHold = "Arial"; }

			Font tempFont = new Font(fontHold,fontSize);
			
			txtPreview.setFont(tempFont);
			txtPreview.setText(hold);
			
			
			
		});
		
		Text txtChoice = new Text("Font:");
		txtChoice.setLayoutX(520);
		txtChoice.setLayoutY(350 + vpad + 15);
		
//		chbFonts = new ChoiceBox((ObservableList)listFonts);
		chbFonts = new ChoiceBox();
		obsListFonts = FXCollections.observableList(listFonts); //Convert the List object of Strings for Fonts names to an ObservableList object.
		chbFonts.setItems(obsListFonts);
		chbFonts.setLayoutX(550);
		chbFonts.setLayoutY(350 + vpad);
		chbFonts.setTooltip(new Tooltip("Select a font to use."));
		
		btnBack = new Button("Back");
		btnBack.setLayoutX(mainStage.mainWidth - 45);
		btnBack.setLayoutY(mainStage.mainHeight -25);
		btnBack.setOnAction(e ->{
			mainStage.goBack();
		});
		
		
		getChildren().addAll(txtSample, txtfPreview, txtPreview, btnPreview, txtChoice, chbFonts, btnBack);
		
		
	}
	
	public void refreshPane(){
		
		String hold = txtfSize.getText();
		if(!hold.isEmpty())
			try{
			fontSize = Integer.parseInt(hold);
			}catch(NumberFormatException e){ e.printStackTrace(); }
		
		getChildren().clear();
		
		//Calls all methods that add Nodes to the pane
		createScrollPane();
		createCommands();
		createTextSample();
		
	}
}
