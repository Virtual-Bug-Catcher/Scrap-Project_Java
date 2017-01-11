package javafx.app.tools;
/*
 * This file is used to store properties needed to place Nodes on a Scene
 * Along with any tips
 * 
 * 
 */

import javafx.scene.Node;

public class MasterGUI {
	public static final int STAGE_WIDTH = 800, STAGE_HEIGHT = 480;
	public static final int LEFT_SIDE_PAD = 10, TOP_SIDE_PAD = 15;
	public static final int FORM_NODE_VPAD = 50, FORM_NODE_HPAD = 30;
	public static final int DIV_NODE_VPAD = 100, DIV_NODE_HPAD = 60;
	public static final String LOC_TOP = "TOP", LOC_BOT = "BOTTOM", LOC_LEFT = "LEFT", LOC_RIGHT = "RIGHT";
	
	
	//This method will ask for a stationary Node, and will gather it's X/Y + it's width/height and calculate the starting X/Y position
	//The next Node must follow.
	//You MUST add the PAD values to whatever value is returned by the method.
	public static int getNodeCoord(Node placed, String location){
		int coord = 0;
		int width = (int)placed.getLayoutBounds().getWidth();
		int height = (int)placed.getLayoutBounds().getHeight();
		
		switch(location){
		case LOC_TOP:
			break;
			
		case LOC_BOT:
			coord = (int)placed.getLayoutY() + height;
			break;
			
		case LOC_LEFT:
			coord = (int)placed.getLayoutX();
			break;
			
		case LOC_RIGHT:
			coord = (int)placed.getLayoutX() + height;
			break;
			
			default:
				coord = 0;
		}
		
		return coord;
		
	}

}
