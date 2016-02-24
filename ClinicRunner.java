import java.util.Scanner;

/**
* Clinic's working part
*/

public class ClinicRunner{

	public static void main (String[] args){
		
		final Clinic clinic = new Clinic(10);
		Scanner reader = new Scanner(System.in);
		String quit = "no";
		
		while(!quit.equals("yes")){
		
			System.out.println("Choice your action:");
			System.out.println("Add new client: 				(1) ");
			System.out.println("Find client by pet's name: 		(2) ");
			System.out.println("Find pet by client's name: 		(3) ");
			System.out.println("Edit client's name:		 		(4) ");
			System.out.println("Edit pet's name: 				(5) ");
			System.out.println("Delete client by his name: 		(6) ");
			System.out.println("Delete client by pet's name: 	(7) ");
			System.out.println("Print all clients:				(8) ");
			
			clinic.operationChoice(reader.next());
			
				
			System.out.print("Quit? (yes/no): ");
			quit = reader.next();
			System.out.println();
		
		}
	
	reader.close();
	System.out.print("Bye!");
		
	}

}
