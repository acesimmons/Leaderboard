package team6;
import java.io.IOException;

public class Gameology {
	
	public static void main(String[] args) {
		GameologyDatabase database = new GameologyDatabase();
		String output = "";
		
		if(args.length == 2) {
			if(args[0].equals("student")) {
				output = database.searchDatabaseBasedOnStudentID(args[1]);
			}
			else if(args[0].equals("course")) {
				output = database.searchDatabaseBasedOnStudentID(args[1]);
			}
		}
		System.out.println(output);
	}
}
		
