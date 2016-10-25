package team6;
import java.io.IOException;

public class Gameology {
	
	public static void main(String[] args) {
		GameologyDatabase database = new GameologyDatabase();
		String output = "";
		
		if(args.length == 2) {
			if(args[0].equals("student")) {
				output = database.getStudent(args[1]).toString();
			}
			else if(args[0].equals("course")) {
				output = database.getCourse(args[1]).toString();
			}
		}
		System.out.println(output);
	}
}
		
