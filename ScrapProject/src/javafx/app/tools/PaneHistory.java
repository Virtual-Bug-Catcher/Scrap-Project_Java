package javafx.app.tools;
/*
 * This class is to hold the pane's ID, which is a final variable. Can search for said ID without creating notes.
 * 
 * 
 */
import java.util.ArrayList;

//Personal
import javafx.app.MainStage;

//Personal
import javafx.app.panes.*;

public class PaneHistory {
	
	//Global variables
	private MainStage mainStage;
	public static ArrayList<Integer> idList = new ArrayList<>();
	
	public PaneHistory(){}
	public PaneHistory(MainStage m){ mainStage = m; }
	
	public void addPane(int paneID){
		idList.add(paneID);
	}
	
	public void removePane(int paneId){
		
		for(int i = 0; i < idList.size(); i++)
			if(idList.get(i) == paneId)
				idList.remove(i);

	}
	

	
	public void removeAllPanes(){
		for(int i = idList.size()-1; i > 0; i--)
			idList.remove(i);
	}
	
	
	/*
	 * removeLastPane();
	 * Used to go back a page
	 */
	public PaneHost removeLastPane(){
		if(!(idList.size()-1 == 0)){
			idList.remove(idList.size()-1);
			return returnPaneHostName(idList.size()-1);
		}
		
		return new HomePage();
	}
	
	private PaneHost returnPaneHostName(int id){
		PaneHost paneHost = new HomePage(mainStage);
		
		switch(id){
		
		//Hard coded for quick retrieval, a prototype.
		case 100:
			paneHost = new HomePage(mainStage);
			return paneHost;
			
		case 101:
			paneHost = new ScrollFonts(mainStage);
			return paneHost;
			
		case 102:
			paneHost = new Animaniacs(mainStage);
			return paneHost;
			
		}
		
		return paneHost;
	}
	

}
