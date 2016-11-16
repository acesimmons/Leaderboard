package team6;
import java.io.IOException;

public class Gamegogy {
	private Controller controller;
	
	public Gamegogy() {
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		String output = "";
		
		if(args.length == 2) {
			output = controller.runConsoleCommands(args[0], args[1]);
		}
		else if(args.length == 1) {
			output = controller.runConsoleCommands(args[0], "");
		}
		System.out.println(output);
	}
}