package keywords;
import team6.*;
import java.io.IOException;


public class Feature2Keyword{
	private String output;
	
	public Feature2Keyword(){
		output = "";
	}
	public void startGamegogyCLIWithArguments(String type){
		GamegogyDatabase database = new GamegogyDatabase();
		if(type.equals("studentids")){
			output = database.getStudentIDsConsole();
		}
		if(type.equals("courseids")){
			output = database.getCourseIDsConsole();
		}
	}
		
	public String getCommandLineOutput(){
		return output;
	}
	

}