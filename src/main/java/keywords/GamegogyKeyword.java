package keywords;
import team6.*;
import java.io.IOException;


public class GamegogyKeyword{
	private String output;
	
	
	public void startGamegogyCLIWithArguments(){
		output = "";
	}
	
	public void startGamegogyCLIWithArguments(String type, String id){
		GamegogyDatabase database = new GamegogyDatabase();
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