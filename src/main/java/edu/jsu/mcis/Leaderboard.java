
import java.util.Scanner;

public class Leaderboard {
	
	public static void main(String[] args) {
		
		dataSystem dataBank = new dataSystem();
		if (args.length == 2){
			String firstValue = args[0];
			String secondValue = args[1];
		}
		else if(args.length == 0){
			getInformationDirectlyFromUser();
		}
		
	}
	
	static void getInformationDirectlyFromUser(){
		Scanner inputField1 = new Scanner(System.in);
		Scanner inputField2 = new Scanner(System.in);
		String command1;
		String command2;
		boolean terminate = false;
		while(terminate == false){
			System.out.print("\n\n\n\nHINT: VALID INPUTS ARE student or course\nWould you like to look up student or course info: ");
			command1 = inputField1.nextLine();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
			System.out.println("VALID INPUT ARE ONLY INTERGERS\nPlease enter in the id: ");
			command2 = inputField2.nextLine();
			try{
				int.parseInt(command2);
			}
			catch(NumberFormatException nfe){
				
			}
		}
	}
}
