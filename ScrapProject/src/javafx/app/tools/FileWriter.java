package javafx.app.tools;
/*
 * This class will write to a file.
 * Please note the differences between PrintWriter and OutputStream!
 * Leaving it in, for a lesson to be learned.
 * PrintWriter = over-writes data, java 8 code will not allow easy appending
 * OutputStream 
 * 
 */
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;


public class FileWriter {
	
	//Global variables
	public File file;
	public String fileName ="";
	public PrintWriter writer;
	public BufferedWriter buffWriter;
	public String message ="", error = "";
	
	public FileOutputStream fileOutputStream;
	
	public FileWriter(){}
	public FileWriter(String filename){ 
	setFileName(filename); 
//	setFile(new File(fileName)); 
	}
	public FileWriter(File f){ setFile(f); }
	
	//This method will write-over any existing data that's in the file.
	//Mrs. Stones theory is to grab all the data, concantenate your data, and reinject it.
	//Not really, there is a way to append text to a file..
	public boolean writeToFile(String text){
		boolean isWritten = false;
		message = text;
		
		if(file == null || !file.exists())
			error = "File is null or does not exist.";
		else
		{
			try {
				writer = new PrintWriter(file);
//				buffWriter = new BufferedWriter(writer);
//				buffWriter.write(message);
//				buffWriter.close();
				writer.println(message);
				isWritten = true;
			} catch (FileNotFoundException e) {
				error = "File not found when creating PrintWriter.";
				e.printStackTrace();
			}
			catch(IOException ex){
				error = "File not found when creating BufferedWriter";
				ex.printStackTrace();
			}
			finally{
				writer.close();
			}
		}
		
		return isWritten;
	}
	
	
	//Doesn't work
	public boolean overwriteToFile(String text){
		boolean isWritten = false;
		message = text;
		
		if(file == null || !file.exists())
			error = "File is null or does not exist.";
		else{
			try{
//				Path path = FileSystems.getDefault().getPath("testfile2", fileName);
//				outputStream = Files.newOutputStream(path, StandardOpenOption.APPEND);
				fileOutputStream = new FileOutputStream(fileName, true);
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
				outputStreamWriter.write(message);
				outputStreamWriter.close();
			} catch(IOException e){
				error = "Error in writing to file with OutputStreamWriter.";
				e.printStackTrace();
			}
		}
		
		
		return isWritten;
	}
	
	//It works! :D
	public boolean appendToFile(String text){
		boolean isWritten = false;
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add(text);
		
		if(file == null || !file.exists())
			error = "File is null or does not exist.";
		else{
			try{
				//Create variables to use in the File.write(Path, Iterable<?>, OpenOptions);
				Path path = FileSystems.getDefault().getPath("", fileName);
				Files.write(path, list, (OpenOption)StandardOpenOption.APPEND);
				isWritten = true;
				
			}
			catch(IOException e){
				error = "Something went wrong in the appendToFile()";
				e.printStackTrace();
			}
		}

		
		return isWritten;
	}
	
	public void setFile(File f){ file = f; }
	public void setFileName(String n){ fileName = n; setFile(new File(fileName)); }
	public void setMessage(String m){ message = m; }
	public void setError(String e){ error = e; }
	
	public File getFile(){ return file; }
	public String getFileName(){ return fileName; }
	public String getMessage(){ return message; }
	public String getError(){ return error; }

}
