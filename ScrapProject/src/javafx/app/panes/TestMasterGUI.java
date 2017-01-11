package javafx.app.panes;
/*
 * 
 * 
 * 
 */
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
//Personal
import javafx.app.MainStage;
import javafx.app.tools.MasterGUI;

public class TestMasterGUI extends PaneHost{
	
	//Global variables
	public MainStage mainStage;
	public Font font;
	public Text txtGreet, txtHeader1, txtHeader2, txtHeader3;
	public Button btnBack;
	public TextField txtfName;
	public Rectangle rect1, rect2, rect3, rect4;
	
	public TestMasterGUI(){}
	
	public TestMasterGUI(MainStage ms){
		mainStage = ms;
		createNodes();
	}
	
	public void createNodes(){
		font = new Font(30);
		
		btnBack = new Button("Back");
		btnBack.setLayoutX(mainStage.mainWidth - 45);
		btnBack.setLayoutY(mainStage.mainHeight - 25);
		btnBack.setOnAction(e ->{
			mainStage.goBack();
		});
		
		txtGreet = new Text("Hello World! Below is " + MasterGUI.FORM_NODE_VPAD + "px");
		txtGreet.setLayoutX(MasterGUI.LEFT_SIDE_PAD);
		txtGreet.setLayoutY(MasterGUI.TOP_SIDE_PAD + txtGreet.getFont().getSize());
		txtGreet.setFont(font);
		
		txtHeader1 = new Text("Text Header 1, below is " + MasterGUI.DIV_NODE_VPAD +"px");
		txtHeader1.setLayoutX(MasterGUI.LEFT_SIDE_PAD);
//		txtHeader1.setLayoutY(txtGreet.getLayoutY() + MasterGUI.FORM_NODE_VPAD);
		txtHeader1.setLayoutY(MasterGUI.getNodeCoord(txtGreet, MasterGUI.LOC_BOT));
		
		txtHeader2 = new Text("Text Header 2");
		txtHeader2.setLayoutX(MasterGUI.LEFT_SIDE_PAD);
//		txtHeader2.setLayoutY(txtHeader1.getLayoutY() + MasterGUI.DIV_NODE_VPAD);
		txtHeader2.setLayoutY(MasterGUI.getNodeCoord(txtHeader1, MasterGUI.LOC_BOT) + MasterGUI.DIV_NODE_VPAD);
		
		txtHeader3 = new Text("Text Header 3");
		txtHeader3.setLayoutX(txtGreet.getLayoutX() + txtGreet.getLayoutBounds().getWidth() + MasterGUI.FORM_NODE_HPAD);   //This helps grab the width of the node, to add on to the x,y placement values
		txtHeader3.setLayoutY(MasterGUI.TOP_SIDE_PAD);
		
		rect1 = new Rectangle(400, 50, 10, 10);
		rect1.setFill(Color.AQUA);
		
		rect2 = new Rectangle(MasterGUI.getNodeCoord(rect1, MasterGUI.LOC_BOT), 100, 10, 10);
		
		rect3 = new Rectangle(MasterGUI.getNodeCoord(rect2, MasterGUI.LOC_BOT), MasterGUI.getNodeCoord(rect2, MasterGUI.LOC_BOT), 10, 10);
		rect3.setFill(Color.RED);
		
		rect4 = new Rectangle(0,0, 10, 10);
		rect4.setFill(Color.GREEN);
	
		
		getChildren().addAll(btnBack, txtGreet, txtHeader1, txtHeader2, txtHeader3, rect1, rect2, rect3, rect4);
		
	}

}
