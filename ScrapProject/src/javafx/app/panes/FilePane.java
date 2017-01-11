package javafx.app.panes;
/*
 * 
 * 
 * 
 */
import javafx.scene.control.*;
import javafx.scene.text.Text;
import java.io.FileNotFoundException;

//Personal
import javafx.app.MainStage;
import javafx.app.tools.FileReader;
import javafx.app.tools.FileWriter;

public class FilePane extends PaneHost{
	
	public final int ID = 103;
	
	//Global variable
	public MainStage mainStage;
	public FileReader fileReader;
	public FileWriter fileWriter;
	public Button btnBack, btnSwitch, btnSubmit, btnAppend;
	public TextField txtfInput;
	public Text txtFileInfo, txtFile, txtWriteError;
	public Label lblInput;
	
	//Global helpers
	private boolean isReading = true;
	
	public FilePane(){}
	public FilePane(MainStage m){
		super.PANEID = ID;
		mainStage = m;
		createNodes();
		createReadNodes();
		createWriteNodes();
		}
	
	public void createNodes(){
		btnBack = new Button("Back");
		btnBack.setLayoutX(mainStage.mainWidth - 45);
		btnBack.setLayoutY(mainStage.mainHeight - 25);
		btnBack.setOnAction(e ->{
			mainStage.goBack();
			destroyPane();
		});
		
		btnSwitch = new Button("Switch to FileWriter");
		btnSwitch.setLayoutX(0);
		btnSwitch.setLayoutY(mainStage.mainHeight - 25);
		btnSwitch.setOnAction(e ->{
			switchFileAction();
		});
		
		getChildren().addAll(btnBack, btnSwitch);
	}
	
	private void createReadNodes(){
		if(isReading){
		displayTest();
		}
		
	}
	
	private void createWriteNodes(){
		if(!isReading){
			lblInput = new Label("Data to inject:");
			lblInput.setLayoutX(10);
			lblInput.setLayoutY(20);
			
			
			txtfInput = new TextField();
			txtfInput.setLayoutX(90);
			txtfInput.setLayoutY(15);
			
			txtWriteError = new Text();
			txtWriteError.setLayoutX(300);
			txtWriteError.setLayoutY(15);
			
			btnSubmit = new Button("Submit Text(OverWrites)");
			btnSubmit.setLayoutX(90);
			btnSubmit.setLayoutY(50);
			btnSubmit.setOnAction(e ->{
				String text = txtfInput.getText();
				if(!text.isEmpty()){
					fileWriter = new FileWriter();
					fileWriter.setFileName("src/media/iofiles/testfile2");
	
					if(!(fileWriter.overwriteToFile(text)))
						txtWriteError.setText(fileWriter.getError());
					else
						txtWriteError.setText("Written to the file successfully!");
				}
			});
			
			btnAppend = new Button("Append Text");
			btnAppend.setLayoutX(255 + btnSubmit.getWidth());
			btnAppend.setLayoutY(50);
			btnAppend.setOnAction(e ->{
				String text = txtfInput.getText();
				if(!text.isEmpty()){
					fileWriter = new FileWriter();
					fileWriter.setFileName("src/media/iofiles/testfile2");
					
					if(!(fileWriter.appendToFile(text)))
						txtWriteError.setText(fileWriter.getError());
					else
						txtWriteError.setText("Appended to the file successfully!");
				}
			});
			
			
			
			getChildren().addAll(lblInput, txtfInput, txtWriteError, btnSubmit, btnAppend);
			
		}
		
	}
	
	public void displayTest(){
		try{
		fileReader = new FileReader("src/media/iofiles/testfile1");
		}
		catch(Exception e){}
		
		String info = fileReader.checkFileInfo();
		
		if(info.isEmpty())
			info = fileReader.getError();
		
		txtFileInfo = new Text(info);
		txtFileInfo.setLayoutX(10);
		txtFileInfo.setLayoutY(15);
		
		txtFile = new Text();
		txtFile.setText(fileReader.readFile());
		txtFile.setLayoutX(450);
		txtFile.setLayoutY(15);
		
		getChildren().addAll(txtFileInfo, txtFile);
	}
	
	private void switchFileAction(){
		
		if(isReading){
			isReading = false;
			btnSwitch.setText("Switch to FileReader");
			clearReadNodes();
			createWriteNodes();
			
		}
		else{
			isReading = true;
			btnSwitch.setText("Switch to FileWriter");
			clearWriteNodes();
			createReadNodes();
				
		}

	}
	
	private void clearReadNodes(){
		getChildren().removeAll(txtFileInfo, txtFile);
		
	}
	private void clearWriteNodes(){
		getChildren().removeAll(lblInput, txtfInput, btnSubmit, btnAppend);
	}
	
	private void destroyPane(){
		getChildren().clear();
	}

}//End class FilePane