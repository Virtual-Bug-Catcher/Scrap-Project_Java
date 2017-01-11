package javafx.app.panes;
/*
 * This page will host all the buttons to switch Panes for different types of Animation
 * For now (12/17/16) leave this til you have time. You must focus on the SkillsUSA. Get ajob!
 * 
 */
import javafx.scene.control.Button;

//Personal
import javafx.app.MainStage;

public class Animaniacs extends PaneHost{
	
	public final int ID = 103;
	
	//Global Variables
	public MainStage mainStage;
	Button btnBack, btnAnimTimer, btnFade, btnFill, btnParallel, btnPath, btnPause, btnRotate, btnScale, btnSequential, btnStroke, btnTranslate;
	
	public Animaniacs(){ super.PANEID = ID; }
	public Animaniacs(MainStage m){
		mainStage = m;
		super.PANEID = ID;
		
		createNodes();
	}
	
	public void createNodes(){
		
		createButtons();
	}
	
	private void createButtons(){
		btnBack = new Button("Back");
		btnBack.setLayoutX(mainStage.mainWidth - 45);
		btnBack.setLayoutY(mainStage.mainHeight - 25);
		btnBack.setOnAction(e ->{
			mainStage.goBack();
		});
		
		getChildren().addAll(btnBack);
	}

}
