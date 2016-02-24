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
			System.out.println("Print all clients				(8) ");
			
			String choice = reader.next();
			
				switch(choice){
					case "1": { 
								if (!clinic.isFull()) {
								System.out.print("Enter new client's name: ");
								String clientsName = reader.next();
								System.out.println();
								System.out.println("Enter pet's name: ");
								String petsName = reader.next();
								System.out.println("Enter pet's type (dog/cat): ");
								String petsType = reader.next();
									if ("cat".equalsIgnoreCase(petsType)) clinic.addNewClient(new Client(clientsName, new Cat(petsName)));
									else if ("dog".equalsIgnoreCase(petsType)) clinic.addNewClient(new Client(clientsName, new Dog(petsName)));
									else {System.out.println("Wrong pet's type!"); break;}
								System.out.println("New client is added.");
								}
								else System.out.print("Clinic is full! Sorry.");
								break;
								}
					case "2": {
								System.out.print("Enter pet's name: ");
								String petsName = reader.next();
								System.out.println();
								System.out.println("Client's name is "+clinic.findClientByPetsName(petsName).getName());
								break;
								}
					case "3": {
								System.out.println("Enter client's name: ");
								String clientsName = reader.next();
								System.out.println("Pet's name is "+clinic.findPetByClientsName (clientsName).getName());
								break;
								}
					case "4": {
								System.out.println("Enter old client's name: ");
								String clientsOldName = reader.next();
								System.out.println("Enter new client's name: ");
								String clientsNewName = reader.next();
								clinic.editClientsName(clientsOldName, clientsNewName);
								System.out.println("Client's name is changed.");
								break;
								}
					case "5": {
								System.out.println("Enter old pet's name: ");
								String oldPetsName = reader.next();
								System.out.println("Enter new pet's name: ");
								String newPetsName = reader.next();
								clinic.editPetsName (oldPetsName, newPetsName);
								System.out.println("Pet's name is changed.");
								break;
								}
					case "6": {
								System.out.println("Enter client's name: ");
								String clientsName = reader.next();
								clinic.deleteClientByHisName(clientsName);
								System.out.println("Client is deleted.");
								break;
								}
					case "7": {
								System.out.println("Enter pet's name: ");
								String petsName = reader.next();
								clinic.deleteClientByPetsName(petsName);
								System.out.println("Client is deleted.");
								break;
								}
					case "8": {
								for (int i = 0; i < 10; i++)
								System.out.println(clinic.getClient(i));
								break;
								}
					default:  {System.out.println("Invalid enter. Try again.");
								break;
								}
								
				}
			System.out.print("Quit? (yes/no): ");
			quit = reader.next();
			System.out.println();
		
		}
	
	reader.close();
	System.out.print("Bye!");
		
	}

}
