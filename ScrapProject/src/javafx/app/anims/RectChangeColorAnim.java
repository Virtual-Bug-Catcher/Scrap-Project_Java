package javafx.app.anims;
/*
 * This class will fill a pane with small rectangles. Each has it's own color (maybe). Have a animation with a 'sleep' timer that will change the first rectangle to a color
 * and each iteration will change the next rectangle to the same color. Until all rectangles are the same color. Then it goes and randomizes the colors again one-by-one.
 * Make each iteration wait a moment before doing the next, so you can see the animation happen.
 * Neat animation trick I thought of, try to make it happen captain!
 */
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
//Personal
import javafx.app.MainStage;
import javafx.app.panes.PaneHost;

public class RectChangeColorAnim extends PaneHost {
	
	//Global variables
	public MainStage mainStage;
	private ArrayList<Rectangle> rectList = new ArrayList<>();
	public 	Random rand = new Random(1);
	
	//Global helper variables
	public 	double red, green, blue, alpha;
	
	public RectChangeColorAnim(){}
	public RectChangeColorAnim(MainStage ms){
		mainStage = ms;
		createNodes();
		animColorStart();
	}
	
	public void createNodes(){
		Rectangle rect;
		
		//For random generator
		rand.setSeed(System.currentTimeMillis());
		
		for(int i = 0; i < mainStage.mainHeight; i += 5){
			for(int j = 0; j < mainStage.mainWidth; j += 5){
				rect = new Rectangle(j, i, 10, 10);
				rect.setLayoutX(j);
				rect.setLayoutY(i);
				rect.setFill(randomColor());
				rectList.add(rect);
				getChildren().add(rect);
			}
			
		}
		
		
	}
	
	private void animColorStart(){
		long mil = 30;
		
		Timeline timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);
		
		ArrayList<KeyValue> keyValueList = new ArrayList<>();
		KeyValue keyValue;
		KeyFrame keyFrame;
		
		for(int i = 0; i < rectList.size(); i++){
			keyValue = new KeyValue(rectList.get(i).fillProperty(), Color.AQUA);
			keyFrame = new KeyFrame(Duration.millis(mil), keyValue);
			mil += 2;
			timeline.getKeyFrames().add(keyFrame);
		}
//		KeyValue keyValue = new KeyValue(rectList.get(index).fillProperty(), Color.AQUA);
//		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
//		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
		
	}
	
	private Color randomColor(){
		red = rand.nextDouble();
		green = rand.nextDouble();
		blue = rand.nextDouble();
		alpha = 1;
		Color color = new Color(red, green, blue, alpha);
		
		return color;
	}
	
	private void animRectSameColor(int index){
		//this method will change the Rectangle in the ArrayList to a static color,
		//For the animation affect that each rectangle will become the same color
		
		Rectangle rec = rectList.get(index);
		rec.setFill(Color.AQUA);
	}
	
	public void destroyPane(){
		//This does not seem to delete the objects in memory. Maybe the best approach is to nullify everything, but the variable's placeholders will still exist
		//Until the jvm collects the garbage?
		getChildren().clear();
		rectList.clear();
	}

}//End class
