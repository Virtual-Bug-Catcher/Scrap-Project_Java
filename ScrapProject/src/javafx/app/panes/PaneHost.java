package javafx.app.panes;
/*
 * This class is to be the polymorphic value to extract the pane ID variable when needed.
 * 
 * 
 */
import javafx.scene.layout.Pane;

public class PaneHost extends Pane{
	
	public int PANEID;
	
	public PaneHost(){}
	
	public int getPANEID(){ return PANEID; }
	
	protected void displayHost(){
//		getChildren().clear();
		//Apparantly the gardbage collector will run when it's limit of memory allocation is getting close to being overdone.
	}
	
//	protected void destoryPane(){
//		getChildren().clear();
//	}

}
