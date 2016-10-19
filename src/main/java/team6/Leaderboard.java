package team6;
import java.io.IOException;

public class Leaderboard {
	
	public static void main(String[] args) {
		runValidityChecks(args);
	}
	public static boolean runValidityChecks(String[] args){
		if(args.length == 2){
			try {
				Linker link = new Linker();
				link.checkAgainstArgs(args[0], args[1]);
				return false;
			} catch (IOException e) {
				e.printStackTrace();
				return true;
			}
		}
		else{
			return true;
		}
	}
}
