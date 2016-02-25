import java.util.Scanner;

/**
* Clinic's working part
*/

public class ClinicRunner{

	public static void main (String[] args){
		
		final Clinic clinic = new Clinic();
		Scanner reader = new Scanner(System.in);
		Boolean quit = false;
		String choice;
		
		while(!quit){
		
			System.out.println("Choose your action:");
			System.out.println();
			System.out.println("1 - Add a new client;");
			System.out.println("2 - Find client by pet's name;");
			System.out.println("3 - Find pet by client's name;");
			System.out.println("4 - Edit client's name;");
			System.out.println("5 - Edit pet's name;");
			System.out.println("6 - Delete client by his name;");
			System.out.println("7 - Delete client by pet's name;");
			System.out.println("8 - Print all clients;");
			System.out.println("9 - Quit.");
						
			choice = reader.next();
			
			if ("9".equals(choice)) {quit = true; continue;}
			
			clinic.operationChoice(choice);
			System.out.println();
			
		}
	
	reader.close();
	System.out.print("Bye!");
		
	}
}
