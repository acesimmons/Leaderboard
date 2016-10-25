package keywords;
import team6.*;
import java.io.IOException;


public class GameologyKeyword{
	private String output;
	
	public void startGamegogyCLIWithArguments(){
		output = "";
	}
	
	public String getCommandLineOutput(String type, String id){
	GameologyDatabase database = new GameologyDatabase(type, id);
	if(type.equals("student")){
		output = database.getStudent(id).toString();
	}
	if(type.equals("course")){
		output = database.getCourse(id).toString();
	}
	
	}
	
		public String getCommandLineOutput(){
			return output;
		}
	

}