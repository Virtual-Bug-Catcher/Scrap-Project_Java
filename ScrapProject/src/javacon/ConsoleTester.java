package javacon;
/*
 * This class is used to display properties.
 * 
 * 
 */
import java.util.*;

public class ConsoleTester {
	
	public static void main(String[] args){
		
//		randomDoubleLoop();
		
	}//End main
	
	private void randomDoubleLoop(){
		Random rand = new Random(1);
		
		for(int i = 0; i < 10; i++){
		
		double red, green, blue;
		red = rand.nextDouble();
		green = rand.nextDouble();
		blue = rand.nextDouble();
		
		System.out.println("Red: " + red + "\nGreen: " + green + "\nBlue: " + blue + "\n\n");
		}
	}

}//End class
