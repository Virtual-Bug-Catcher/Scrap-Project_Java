package javafx.app.panes;
/*
 * 
 * 
 * 
 */
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.*;

//Java core
import java.util.List;

//Personal
import javafx.app.MainStage;
import javafx.app.anims.RectChangeColorAnim;
import javafx.geometry.Insets;

public class HomePage extends PaneHost{
	
	//Pane variables
	final static int ID = 100;
	
	//Global variables
	public MainStage mainStage;
	
	//GUI variables
	public Font font;
	public Text txtGreeting;
	public Label lblGreeting;
	public Button btnScrollFonts, btnAnimaniacs, btnFilePane, btnMasterGUI, btnColorRect, btnDataInjectorForm;
	
	//TEST NODES
	public Text txtTest, txtFontFamilies;
	
	public HomePage(){ super.PANEID = ID; }
	public HomePage(MainStage mStage){ 
		super.PANEID = ID;
		mainStage = mStage; 
		createNodes();
	}
	
	public void createNodes(){
		font = new Font(10);
		
		lblGreeting = new Label("Hello, welcome to the JavaFX world.");
		lblGreeting.setLayoutX(15);
		lblGreeting.setLayoutY(15);
		lblGreeting.setFont(font);
		
		txtGreeting = new Text("Hello, welcome to the JavaFX world.");
		txtGreeting.setLayoutX(15);
		txtGreeting.setLayoutY(15 + lblGreeting.getHeight());
		
		txtTest = new Text("Testing out this Text node.");
		txtTest.setLayoutX(20);
		txtTest.setLayoutY(50);
		
		btnScrollFonts = new Button("ScrollFonts");
		btnScrollFonts.setLayoutX(80);
		btnScrollFonts.setLayoutY(200);
		
		btnScrollFonts.setOnAction(e -> {
			mainStage.setMainPane(new ScrollFonts(mainStage));
		});
		
		btnAnimaniacs = new Button("Animaniacs");
		btnAnimaniacs.setLayoutX(80);
		btnAnimaniacs.setLayoutY(250);
		btnAnimaniacs.setOnAction(e ->{
			mainStage.setMainPane(new Animaniacs(mainStage));
		});
		
		btnFilePane = new Button("FilePane");
		btnFilePane.setLayoutX(80);
		btnFilePane.setLayoutY(300);
		btnFilePane.setOnAction(e ->{
			mainStage.setMainPane(new FilePane(mainStage));
		});
		
		btnMasterGUI = new Button("TestMasterGUI");
		btnMasterGUI.setLayoutX(80);
		btnMasterGUI.setLayoutY(350);
		btnMasterGUI.setOnAction(e ->{
			mainStage.setMainPane(new TestMasterGUI(mainStage));
		});
		
		btnColorRect = new Button("RectChangeColorAnim");
		btnColorRect.setLayoutX(80);
		btnColorRect.setLayoutY(400);
		btnColorRect.setOnAction(e ->{
			mainStage.setMainPane(new RectChangeColorAnim(mainStage));
		});
		
		btnDataInjectorForm = new Button("DataInjectorForm");
		btnDataInjectorForm.setLayoutX(80);
		btnDataInjectorForm.setLayoutY(450);
		btnDataInjectorForm.setOnAction(e ->{
			mainStage.setMainPane(new DataInjectorForm(mainStage));
		});
		
		getChildren().addAll(lblGreeting, txtGreeting, txtTest, btnScrollFonts, btnAnimaniacs, btnFilePane, btnMasterGUI, btnColorRect, btnDataInjectorForm);
		
	}
	


}//End Class HomePage
