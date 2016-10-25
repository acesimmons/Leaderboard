package keywords;
import team6.*;
import java.io.IOException;


public class GameologyKeyword{
	private GameologyDatabase database;
	private String output;
	public GameologyKeyword(){
		database = new GameologyDatabase();
		output = "";
	}
		
	public String startGamegogyCLIWithArguments(String id){
		
	}
	
	public String getCommandLineOutput{
		String courseInfo = database.getCourse(id).toString();
		return courseInfo;
	}
		
	public String startGamegogyCLIWithArguments(){
		output = "";
	}

}