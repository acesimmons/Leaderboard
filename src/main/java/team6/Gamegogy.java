package team6;
import java.io.IOException;

public class Gamegogy {
	
	public Gamegogy() {
	}
	
	public static void main(String[] args) {
		String output = "";
		
		if(args.length == 2) {
			output = runCommand(args[0], args[1]);
		}
		else if(args.length == 1) {
			output = runCommand(args[0], "");
		}
		System.out.println(output);
	}
	
	private static String runCommand(String command, String id){
		String output = "";
		GamegogyDatabase database = new GamegogyDatabase();
		if(command.equals("student")) {
			output = database.getStudent(id).toString();
		}
		
		else if(command.equals("course")) {
			output = database.getCourse(id).toString();
		}
		
		else if(command.equals("studentids")) {
			output = database.getStudentIDs();
		}
		
		else if(command.equals("courseids")) {
			output = database.getCourseIDs();
		}
		
		return output;
	}
}