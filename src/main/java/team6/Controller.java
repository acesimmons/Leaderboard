package team6;
import java.io.IOException;

public class Controller {
	
	public String runConsoleCommands(String command, String id){
		String output = "";
		GamegogyDatabase database = new GamegogyDatabase();
		if(command.equals("student")) {
			output = database.getStudentData(id).toString();
		}
		
		else if(command.equals("course")) {
			output = database.getCourseData(id).toString();
		}
		
		else if(command.equals("studentids")) {
			output = database.getStudentIDsConsole();
		}
		
		else if(command.equals("courseids")) {
			output = database.getCourseIDsConsole();
		}
		
		return output;
	}
	
	
}