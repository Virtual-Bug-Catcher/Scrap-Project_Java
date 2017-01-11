package javafx.app.panes;
/*
 * This pane is to create a nice Form to enter data into a text file.
 * Make this one fulfilling, as it can be referenced for more than just a few things
 * 
 * 
 */
import javafx.scene.control.*;
import javafx.scene.text.*;

//Personal imports
import javafx.app.MainStage;
import javafx.app.tools.MasterGUI;

public class DataInjectorForm extends PaneHost {
	
	//Global variables
	public MainStage mainStage;
	public String error;
	
	//Global GUI variables
	public Font font;
	public Text txtHeader, txtFormHint, txtFileHeader, txtFileContent;
	public Label lblName, lblMessage;
	public TextField txtfName, txtfMessage;
	public Button btnBack, btnSubmit;
	
	
	
	public DataInjectorForm(){}
	public DataInjectorForm(MainStage ms){
		mainStage = ms;
		createNodes();
	}
	
	public void createNodes(){
		btnBack = new Button("Back");
		btnBack.setLayoutX(mainStage.mainWidth - 45);
		btnBack.setLayoutY(mainStage.mainHeight - 25);
		btnBack.setOnAction(e ->{
			mainStage.goBack();
		});
		
		font = new Font(30);
		
		txtHeader = new Text("Welcome to Data Injection!");
		txtHeader.setFont(font);
		txtHeader.setLayoutX(MasterGUI.LEFT_SIDE_PAD);
		txtHeader.setLayoutY(MasterGUI.DIV_NODE_HPAD);
		
		txtFormHint = new Text("Enter in data to append to a file.");
//		txtFormHint.setLayoutX(MasterGUI.getNodeCoord(txtHeader, MasterGUI.LOC_BOT)); //+ MaterGUI.
		txtFormHint.setLayoutX(MasterGUI.LEFT_SIDE_PAD);
		txtFormHint.setLayoutY(MasterGUI.getNodeCoord(txtHeader, MasterGUI.LOC_BOT));
		
		lblName = new Label("Name:");
		lblName.setLayoutX(MasterGUI.LEFT_SIDE_PAD + 5);
		lblName.setLayoutY(MasterGUI.getNodeCoord(txtFormHint, MasterGUI.LOC_BOT) + MasterGUI.DIV_NODE_HPAD);
		
		txtfName = new TextField();
		txtfName.setLayoutX(lblName.getLayoutX() + MasterGUI.FORM_NODE_VPAD);
		txtfName.setLayoutY(MasterGUI.getNodeCoord(lblName, MasterGUI.LOC_BOT) - 4);
		
		lblMessage = new Label("Message:");
		lblMessage.setLayoutX(MasterGUI.LEFT_SIDE_PAD);
		lblMessage.setLayoutY(MasterGUI.getNodeCoord(lblName, MasterGUI.LOC_BOT) + MasterGUI.FORM_NODE_VPAD);
		
		txtfMessage = new TextField();
//		txtfMessage.setPrefHeight(80); //This is weird.
		txtfMessage.setLayoutX(lblMessage.getLayoutX() + MasterGUI.FORM_NODE_VPAD + 5);
		txtfMessage.setLayoutY(MasterGUI.getNodeCoord(lblMessage,  MasterGUI.LOC_BOT) - 4);
		
		btnSubmit = new Button("Submit");
		btnSubmit.setLayoutX(txtfMessage.getLayoutX());
//		btnSubmit.setLayoutY(MasterGUI.getNodeCoord(txtfMessage, MasterGUI.LOC_BOT) +  MasterGUI.DIV_NODE_VPAD);
		btnSubmit.setLayoutY(MasterGUI.getNodeCoord(txtfMessage, MasterGUI.LOC_BOT) + MasterGUI.FORM_NODE_VPAD);
		btnSubmit.setOnAction(e ->{
			submitDataToFile();
		});
		
		txtFileHeader = new Text("File: ");
		txtFileHeader.setLayoutX(mainStage.mainWidth / 2);
		txtFileHeader.setLayoutY(MasterGUI.DIV_NODE_HPAD + MasterGUI.FORM_NODE_HPAD);
		
		
		txtFileContent = new Text("File contents.\nNew lines?!(Works!)");
		txtFileContent.setLayoutX(mainStage.mainWidth /2);
		txtFileContent.setLayoutY(MasterGUI.getNodeCoord(txtFileHeader, MasterGUI.LOC_BOT) + MasterGUI.FORM_NODE_VPAD);
		
		getChildren().addAll(btnBack, txtHeader, txtFormHint, lblName, txtfName, lblMessage, txtfMessage, btnSubmit, txtFileHeader, txtFileContent);
		
		
		
		
	}
	
	private boolean submitDataToFile(){
		boolean isWritten = false;
		
		
		return isWritten;
	}
	

}//End Class