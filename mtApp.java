package mtmechanics;
import java.util.ArrayList;
import java.util.Optional;

/*
 * Main starting point for the application
 */
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mtApp extends Application{
	
	//Global variables
	public Stage stage;
	public Pane pane;
	public Scene scene;
	public Font font;
	
	
	//Helpers
	public final int WIDTH = 1000, HEIGHT = 900;
	
	
	
	public static void main(String[] args){ launch(args); }
	
	@Override
	public void start(Stage st){
		stage = st;
		
		pane = new Pane();
		
		//Set background color
		pane.setBackground(new Background(new BackgroundFill(Paint.valueOf("#FF2316"), CornerRadii.EMPTY, Insets.EMPTY)));
		
		font = new Font("Times New Roman", 15);
		
//		createAccordion();
//		createAlert();
//		createButton();
//		createCheckBox();
		createColorPicker();
//		createComboBox();
//		createHyperlink();
//		createMenu();
//		createPasswordField();
//		createProgressBar();
//		createRadioButton();
//		createScrollBar();
//		createScrollPane();
//		createSlider();
//		createSplitPane();
//		createTabPane();
//		createTextArea();
//		createTitledPane();
//		createToggleButton();
//		createToolBar();
//		createTooltip();
//		createClipboard();
		
		scene = new Scene(pane, WIDTH, HEIGHT);
		
		stage.setTitle("Main Template Application");
		stage.setScene(scene);
		stage.show();		
		
//		createAlert(); //This will allow the stage to show, and the dialog box to appear afterwards.
	}
	
	//************************************************************************************
	// javafx.scene.control.*
	//************************************************************************************
	
	public void createAccordion(){
		TitledPane t1 = new TitledPane("TitledPane1", new Button("B1"));
		TitledPane t2 = new TitledPane("Butthead2", new Button("B2"));
		TitledPane t3 = new TitledPane("Transfer3", new Button("B3"));
		
		Accordion acc = new Accordion();
		acc.getPanes().addAll(t1,t2,t3);
		
		pane.getChildren().add(acc);
		
	}
	
	public void createAlert(){
		Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to do this?");
		
		Optional<ButtonType> result = alert.showAndWait();
		
		if(result.isPresent() && result.get() == ButtonType.OK)
			createAccordion();
	}
	
	public void createButton(){
		int x = 0, y = 0;
		
		for(int i = 0; i < 10; i++){
			Button btn = new Button(String.valueOf(i));
			btn.setPrefWidth(50);
			btn.setLayoutX(x);
			btn.setLayoutY(y);
			y += 20;
			pane.getChildren().add(btn);
			
		}
	}
	
	public void createCheckBox(){
		CheckBox cb = new CheckBox("Check Boxing");
		cb.setIndeterminate(false);
		
		cb.setOnAction(e ->{
			
			Label lbl = new Label("Check box clicked?");
			lbl.setLayoutX(100);
			lbl.setLayoutY(100);
			pane.getChildren().add(lbl);
			
			if(cb.isSelected())
				lbl.setText("Is selected");
			else
				lbl.setText("Is not selected");
		});
		
		pane.getChildren().add(cb);
	}
	
	public void createColorPicker(){
		ColorPicker colorpick = new ColorPicker();
		colorpick.getStyleClass().add("split-button");
		colorpick.setLayoutX(50);
		colorpick.setLayoutY(50);	
		
		colorpick.setOnAction(e ->{
			Color c = colorpick.getValue();
			Label lblc = new Label("Color is: " + c.getRed() + " | " + c.getGreen() + " | " + c.getBlue());
			lblc.setLayoutX(200);
			lblc.setLayoutY(200);
			
			//Way to get hexidecimal value
			//Doesn't work very well for certain colors
//			Text txtc = new Text();
//			txtc.setLayoutX(200);
//			txtc.setLayoutY(300);
//			txtc.setText(String.format("#%02X%02X%02X", (int)c.getRed() * 255, (int)c.getGreen() * 255, (int)c.getBlue() * 255));
//			
//			clearPane();
//			createColorPicker();
						
			pane.getChildren().add(lblc);
		});
		
		pane.getChildren().add(colorpick);
	}
	
	public void createComboBox(){
		ArrayList list = new ArrayList();
		
		for(char a = 'a'; a < 'z'; a++){
			list.add(a);
		}
		ComboBox<String> cmb = new ComboBox<String>();
		cmb.getItems().addAll(list);
		
		cmb.setOnAction(e ->{
			Label lbls = new Label(String.valueOf(cmb.getValue()));
			lbls.setFont(font);
			lbls.setLayoutX(250);
			lbls.setLayoutY(250);
			pane.getChildren().add(lbls);
		});
		
		pane.getChildren().add(cmb);
		
	}
	
	public void createHyperlink(){
		Hyperlink link = new Hyperlink("www.google.com");
		
		link.setOnAction(e ->{
		//Can learn how to open a browser	
		});
		
		
		pane.getChildren().add(link);
	}
	
	public void createLabel(){
		//You know how to create a label!
		Label label = new Label("Hello World!");
		label.setFont(new Font(20));
		label.setLayoutX(20);
		label.setLayoutY(20);
		
		pane.getChildren().add(label);
	}
	
	//Needs to be further investigated
	public void createMenu(){
		Menu menu1 = new Menu("File");
		
		MenuItem menuItem1 = new MenuItem("Open");
		menu1.getItems().add(menuItem1);
		
		//Happens when you click on MenuBar to view sub-options
		menu1.setOnShowing(e ->{
			Label lbl = new Label("File OnShowing");
			lbl.setLayoutX(200);
			lbl.setLayoutY(200);
			
			pane.getChildren().add(lbl);
		});
		
		//When you click on an option
		//Maybe grab the selected item, and based on that do an action?
		menu1.setOnAction(e ->{
			Label lbl = new Label("File Action");
			lbl.setLayoutX(200);
			lbl.setLayoutY(250);
			
			pane.getChildren().add(lbl);
		});
		
		
		Menu menu2 = new Menu("Edit");
		Menu menu3 = new Menu("Source");
		
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu1, menu2, menu3);
		
		pane.getChildren().add(menuBar);
	}
	
	public void createPasswordField(){
		PasswordField pwField = new PasswordField();
		pwField.setLayoutX(50);
		pwField.setLayoutY(50);
		
		pwField.setOnKeyPressed(e ->{
			switch(e.getCode()){
			case ENTER:
				Label lbl = new Label(pwField.getText());
				lbl.setLayoutX(250);
				lbl.setLayoutY(250);
				
				pane.getChildren().add(lbl);
				break;
			
			default:
				break;
			}
		});
		
		pane.getChildren().add(pwField);
	}
	
	public void createProgressBar(){
		ProgressBar progBar = new ProgressBar();
		progBar.setProgress(0.25F);
		
		pane.getChildren().add(progBar);
	}
	
	public void createRadioButton(){
		ToggleGroup group = new ToggleGroup();
		
		RadioButton rbtn1 = new RadioButton("First Radio");
		rbtn1.setToggleGroup(group);
		rbtn1.setSelected(true);
		rbtn1.setLayoutX(10);
		rbtn1.setLayoutY(10);
		
		RadioButton rbtn2 = new RadioButton("Second Radio");
		rbtn2.setToggleGroup(group);
		rbtn2.setSelected(false);
		rbtn2.setLayoutX(10);
		rbtn2.setLayoutY(30);
		
		if(rbtn1.isSelected()){
			Label lbl = new Label("rbtn1 is selected");
			lbl.setLayoutX(200);
			lbl.setLayoutY(200);
			pane.getChildren().add(lbl);
		}
		
		pane.getChildren().addAll(rbtn1, rbtn2);
	}
	
	//Binds the value to a label!
	public void createScrollBar(){
		ScrollBar s1 = new ScrollBar();
		s1.setMin(0);
		s1.setMax(10);
		s1.setValue(5);
		s1.setOrientation(Orientation.VERTICAL);
		
		Label lb = new Label(String.valueOf(s1.getValue()));
		lb.textProperty().bind(s1.valueProperty().asString());
		lb.setLayoutX(100);
		lb.setLayoutY(100);
		
		pane.getChildren().addAll(s1, lb);
	}
	
	public void createScrollPane(){
		Rectangle rect = new Rectangle(200, 200, Color.RED);
		
		ScrollPane s1 = new ScrollPane();
		s1.setPrefSize(400,  120);
		s1.setContent(rect);
		
		
		pane.getChildren().add(s1);
	}
	
	public void createSlider(){
		Slider slider = new Slider(0, 5, 2.5);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setMajorTickUnit(0.25f);
		slider.setBlockIncrement(0.1f);
		
		pane.getChildren().add(slider);
	}
	
	public void createSplitPane(){
		SplitPane sp = new SplitPane();
		
		StackPane stp1 = new StackPane();
		stp1.getChildren().add(new Button("Button One"));
		StackPane stp2 = new StackPane();
		stp2.getChildren().add(new Button("Button Two"));
		StackPane stp3 = new StackPane();
		stp3.getChildren().add(new Button("Button Three"));
		
		sp.getItems().addAll(stp1, stp2, stp3);
		sp.setDividerPositions(0.3f, 0.6f, 0.7f);
		
		pane.getChildren().add(sp);
	}
	
	public void createTabPane(){
		TabPane tabPane = new TabPane();
		
		Tab tab1 = new Tab();
		tab1.setText("Rectangle");
		tab1.setContent(new Rectangle(200, 200, Color.RED));
		
		Tab tab2 = new Tab();
		tab2.setText("Text");
		tab2.setContent(new Label("Hello world!"));
		
		tabPane.getTabs().addAll(tab1, tab2);
		
		pane.getChildren().add(tabPane);
	}
	
	public void createTextArea(){
		TextArea ta = new TextArea();
		ta.setWrapText(true);
		
		pane.getChildren().add(ta);
	}
	
	//Is used in the Accordion method
	public void createTitledPane(){
		TitledPane t1 = new TitledPane("Titled1", new Button("Button1"));
		t1.setPrefSize(200, 200);
		
		pane.getChildren().add(t1);
	}
	
	//Similar to RadioButton, but the GUI looks like a Button
	public void createToggleButton(){
		ToggleButton tb1 = new ToggleButton("Toggled1");
		
		ToggleButton tb2 = new ToggleButton("Toggled2");
		tb2.setLayoutY(30);
		
		ToggleButton tb3 = new ToggleButton("Toggled3");
		tb3.setLayoutY(60);
		
		
		ToggleGroup group = new ToggleGroup();
		tb1.setToggleGroup(group);
		tb2.setToggleGroup(group);
		tb3.setToggleGroup(group);
		
		pane.getChildren().addAll(tb1, tb2, tb3);
	}
	
	public void createToolBar(){
		ToolBar toolBar = new ToolBar(new Button("New"),new Button("Open"),new Button("Save"), new Separator(),new Button("Close"));
		toolBar.setOrientation(Orientation.VERTICAL); //Or Horizontal
		
		pane.getChildren().add(toolBar);
	}
	
	public void createTooltip(){
		Rectangle rect = new Rectangle(200, 200);
		
		Tooltip tip1 = new Tooltip("It's a square");
		Tooltip.install(rect, tip1);
		
		//OR
		
		Button btn = new Button("Hover over this");
		btn.setLayoutX(350);
		btn.setLayoutY(350);
		btn.setTooltip(new Tooltip("Button's tooltip"));
		
		pane.getChildren().addAll(rect, btn);
	}
	
	public void createClipboard(){
		Clipboard clipboard = Clipboard.getSystemClipboard();
		ClipboardContent content = new ClipboardContent();
		
		content.putString("Putting text to paste somewhere");
		clipboard.setContent(content);
		
	}
	
	//************************************************************************************
	// javafx.scene.chart.*
	//************************************************************************************
	
	
	private void clearPane(){
		pane.getChildren().clear();
		System.gc();
	}

}
