package team6;
import java.io.IOException;

public class Gamegogy {
	private static String output;
	private static GamegogyDatabase database;
	
	public Gamegogy() {
		output = "";
		database = new GamegogyDatabase();
	}
	
	public static void main(String[] args) {
		if(args.length == 2) {
			runCommand(args[0], args[1]);
		}
		else if(args.length == 1) {
			runCommand(args[0], "");
		}
		System.out.println(output);
	}
	
	private static void runCommand(String command, String id){
		
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
	}
}