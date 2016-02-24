import java.util.Scanner;

public class Clinic {
		
	/**
	* This class describes Clinic, some operations
	* with clients and theirs pets and performs some of theese operations.
	*/

	private final Client[] clients;
		
		public Clinic(final int size){
			this.clients = new Client[size];
		}
		
		public Client getClient(int i){
			return this.clients[i];
		}
		
		/**
		* This method checks - is the list of clients full?
		*/
		
		public boolean isFull(){
			for(int i=0; i<clients.length; i++){
				if (clients[i] == null) {return false;}
				}
			return true;
		}
		
		public void addNewClient (final Client client){
			for(int i=0; i<clients.length; i++){
			if (clients[i] == null) {clients[i] = client; break;}
			}
		}
		
		public Client findClientByPetsName (final String petsName){
			for(int i=0; i<clients.length; i++){
			if (petsName.equalsIgnoreCase(clients[i].getPet().getName())) return clients[i];}
			return null;
		}
		
		public Pet findPetByClientsName (final String clientsName){
			for(int i=0; i<clients.length; i++){
			if (clientsName.equalsIgnoreCase(clients[i].getName())) return clients[i].getPet();}
			return null;
		}
		
		public void editClientsName (final String clientsOldName, final String clientsNewName){
			for(int i=0; i<clients.length; i++){
			if (clientsOldName.equalsIgnoreCase(clients[i].getName())) {
				clients[i] = new Client(clientsNewName, clients[i].getPet()); 
				break;}
			} 		
		}
		
		public void editPetsName (final String petsOldName, final String petsNewName){
			for(int i=0; i<clients.length; i++){
			if (petsOldName.equalsIgnoreCase(clients[i].getPet().getName())) {
				clients[i].getPet().setName(petsNewName); 
				break;}
			} 		
		}
		
		public void deleteClientByHisName (final String clientsName){
			for(int i=0; i<clients.length; i++){
			if (clientsName.equalsIgnoreCase(clients[i].getName())) {
				clients[i] = null; 
				break;}
			}
		}
		
		public void deleteClientByPetsName (final String petsName){
			for(int i=0; i<clients.length; i++){
			if (petsName.equalsIgnoreCase(clients[i].getPet().getName())) {
				clients[i] = null; 
				break;}
			}
		}
		
		/**
		* This method performs the operation that was chosen by user
		*/
		
		public void operationChoice (String choice){
			
			Scanner reader = new Scanner(System.in);
			
			switch(choice){
			//Add new client:
			case "1": { 
						if (!isFull()) {
						System.out.print("Enter new client's name: ");
						String clientsName = reader.next();
						System.out.println();
						System.out.println("Enter pet's name: ");
						String petsName = reader.next();
						System.out.println("Enter pet's type (dog/cat): ");
						String petsType = reader.next();
							if ("cat".equalsIgnoreCase(petsType)) addNewClient(new Client(clientsName, new Cat(petsName)));
							else if ("dog".equalsIgnoreCase(petsType)) addNewClient(new Client(clientsName, new Dog(petsName)));
							else {System.out.println("Wrong pet's type!"); break;}
						System.out.println("New client is added.");
						}
						else System.out.print("Clinic is full! Sorry.");
						break;
						}
			// Find client by pet's name:
			case "2": {
						System.out.print("Enter pet's name: ");
						String petsName = reader.next();
						System.out.println();
						System.out.println("Client's name is " + findClientByPetsName(petsName).getName());
						break;
						}
			//Find pet by client's name:
			case "3": {
						System.out.println("Enter client's name: ");
						String clientsName = reader.next();
						System.out.println("Pet's name is " + findPetByClientsName (clientsName).getName());
						break;
						}
			//Edit client's name:
			case "4": {
						System.out.println("Enter old client's name: ");
						String clientsOldName = reader.next();
						System.out.println("Enter new client's name: ");
						String clientsNewName = reader.next();
						editClientsName(clientsOldName, clientsNewName);
						System.out.println("Client's name is changed.");
						break;
						}
			//Edit pet's name: 
			case "5": {
						System.out.println("Enter old pet's name: ");
						String oldPetsName = reader.next();
						System.out.println("Enter new pet's name: ");
						String newPetsName = reader.next();
						editPetsName (oldPetsName, newPetsName);
						System.out.println("Pet's name is changed.");
						break;
						}
			//Delete client by his name:
			case "6": {
						System.out.println("Enter client's name: ");
						String clientsName = reader.next();
						deleteClientByHisName(clientsName);
						System.out.println("Client is deleted.");
						break;
						}
			//Delete client by pet's name:
			case "7": {
						System.out.println("Enter pet's name: ");
						String petsName = reader.next();
						deleteClientByPetsName(petsName);
						System.out.println("Client is deleted.");
						break;
						}
			//Print all clients
			case "8": {
						for (int i = 0; i < 10; i++)
						System.out.println(getClient(i));
						break;
						}
			// Invalid enter
			default:  {System.out.println("Invalid enter. Try again.");
						break;
						}
						
		}
	}
	
}
