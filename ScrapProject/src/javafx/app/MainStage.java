package javafx.app;
/*
 * Main Application class to host all panes/stage changes.
 * 
 * 
 */
//JavaFX
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.*;

//Java core


//Personal libraries
import javafx.app.tools.PaneHistory;
import javafx.app.panes.HomePage;
import javafx.app.panes.PaneHost;



public class MainStage extends Application{
	
	//Stage's data
	final static public int mainWidth = 800, mainHeight = 480;
	public PaneHistory paneHistory = new PaneHistory(this);
	
	//Global variables
	static public Stage mainStage;
	static public Scene mainScene;
	static public PaneHost mainPane;
	
	//Needed for some IDE's to run the launch command to start JavaFX's activity.
	public static void main(String[] args){launch(args); }
	
	@Override
	public void start(Stage stage){
		mainStage = stage;
		
		
//		mainPane = new HomePage(this);
		setMainPane(new HomePage(this));
		
//		mainScene = new Scene(mainPane, mainWidth, mainHeight);
		
		mainStage.setTitle("Scrap project to test ideas");
		mainStage.setScene(mainScene);
		mainStage.show();
		
		mainStage.requestFocus();
		
		
	}
	
	
	//Pane methods
	
	public void setMainPane(PaneHost p){
		paneHistory.addPane(p.PANEID);
		mainPane = p;
//		mainScene.setRoot(mainPane);
		mainScene =  new Scene(mainPane, mainWidth, mainHeight);
		mainStage.setScene(mainScene);
		mainStage.show();
		
		
	}
	
	public void goBack(){
		mainPane = paneHistory.removeLastPane();
		setMainPane(mainPane);
	}
	

}
