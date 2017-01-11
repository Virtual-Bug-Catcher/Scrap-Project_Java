package javafx.app.tools;
/*
 * This class is used to read a File. 
 * 
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Personal

public class FileReader{
	
	//Global variables
	public Scanner scan;
	public File file;
	public String fileName, filePath, fileAbsPath;
	public String error;
	
	
	
	public FileReader(){}
	public FileReader(File f){ file = f; }
	public FileReader(String filename){
		try{
			fileName = filename;
			file = new File(fileName);
		}
		catch(Exception e){ error = "Error trying to create new File object."; }
	}
	
	public String checkFileInfo(){
		String message = "";
		
		if(file == null || fileName.isEmpty())
			return "";
		else
		{
			message += "Does it exist? " + file.exists();
			message += "\nThe file has " + file.length() + " bytes.";
			message += "\nCan it be read? " + file.canRead();
			message += "\nCan it be written? " + file.canWrite();
			message += "\nIs it a directory? " + file.isDirectory();
			message += "\nIs it a file? " + file.isFile();
			message += "\nIs it absolute? " + file.isAbsolute();
			message += "\nIs it hidden? " + file.isHidden();
			message += "\nAbsoulte path is " + file.getAbsolutePath();
			message += "\nLast modified on " + new java.util.Date(file.lastModified());
		}
		
		return message;
	}
	
	public String readFile(File f){
		setFile(f);
		return readFile();
	}
	
	public String readFile(){
		String content ="";
		
//		scan = new Scanner(fileName); //Don't use the file's path, to create a Scanner!!! (Only displays the file path name)
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(scan.hasNext()){
			content += scan.nextLine() + "\n";
		}
		
		scan.close(); //Make sure to close all streaming objects!
			
		
		return content;
		
	}
	
	
	
	
	public void setFile(File f){ file = f; }
	public void setFileName(String n){ fileName = n; }
	public void setFileAbsPath(String a){ fileAbsPath = a; }
	public void setError(String e){ error = e; }
	
	public File getFile(){ return file; }
	public String getFileName(){ return fileName; }
	public String getFilePath(){ return filePath; }
	public String getFileAbsPath(){ return fileAbsPath; }
	public String getError(){ return error; }
	

}
