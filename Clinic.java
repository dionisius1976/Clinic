import java.util.Scanner;

public class Clinic {
		
	/**
	* This class describes Clinic, some operations
	* with clients and theirs pets and performs some of these operations.
	*/

	private final Client[] clients;
	
	// Constructor
		
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
			for(int i=0; i < clients.length; i++){
				if (clients[i] == null) return false;
				}
			return true;
		}
		
		public boolean isClientExist(String clientName){
			for(int i=0; i < clients.length; i++){
				if  (clients[i] == null) continue;
				else if (clientName.equalsIgnoreCase(clients[i].getName())) return true;
				}
			return false;
		}
		
		public boolean isPetExist(String petName){
			for(int i=0; i < clients.length; i++){
				if  (clients[i] == null) continue;
				else if (petName.equalsIgnoreCase(clients[i].getPet().getName())) return true;
				}
			return false;
		}
		
		public void addNewClient (final Client client){
			for(int i=0; i < clients.length; i++){
			if (clients[i] == null) {clients[i] = client; break;}
			}
		}
		
		public Client findClientByPetsName (final String petsName){
			for(int i=0; i < clients.length; i++){
			if (petsName.equalsIgnoreCase(clients[i].getPet().getName())) return clients[i];}
			return null;
		}
		
		public Pet findPetByClientsName (final String clientsName){
			for(int i=0; i < clients.length; i++){
			if (clientsName.equalsIgnoreCase(clients[i].getName())) return clients[i].getPet();}
			return null;
		}
		
		public void editClientsName (final String clientsOldName, final String clientsNewName){
			for(int i=0; i < clients.length; i++){
			if (clientsOldName.equalsIgnoreCase(clients[i].getName())) {
				clients[i] = new Client(clientsNewName, clients[i].getPet()); 
				break;}
			} 		
		}
		
		public void editPetsName (final String petsOldName, final String petsNewName){
			for(int i=0; i < clients.length; i++){
			if (petsOldName.equalsIgnoreCase(clients[i].getPet().getName())) {
				clients[i].getPet().setName(petsNewName); 
				break;}
			} 		
		}
		
		public void deleteClientByHisName (final String clientsName){
			for(int i=0; i < clients.length; i++){
			if (clientsName.equalsIgnoreCase(clients[i].getName())) {
				clients[i] = null; 
				break;}
			}
		}
		
		public void deleteClientByPetsName (final String petsName){
			for(int i=0; i < clients.length; i++){
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
			
			//Add new client:
			if ("1".equals(choice)) { 
						if (isFull()) System.out.print("Clinic is full! Sorry.");
						else {
							System.out.print("Enter new client's name: ");
							String clientsName = reader.next();
							if (!isClientExist(clientsName)){
								System.out.println();
								System.out.println("Enter pet's name: ");
								String petsName = reader.next();
								if (!isPetExist(petsName)){
									System.out.println("Enter pet's type (dog/cat): ");
									String petsType = reader.next();
										if ("cat".equalsIgnoreCase(petsType)) addNewClient(new Client(clientsName, new Cat(petsName)));
										else if ("dog".equalsIgnoreCase(petsType)) addNewClient(new Client(clientsName, new Dog(petsName)));
										else System.out.println("Wrong pet's type!");
								}
								else System.out.println("This pet is alredy exist.");
							}
							else System.out.println("This client is alredy exist.");
						}
						}						
			// Find client by pet's name:
			else if ("2".equals(choice)) {
						System.out.print("Enter pet's name: ");
						String petsName = reader.next();
						System.out.println();
						if (isPetExist(petsName))System.out.println("Client's name is " + findClientByPetsName(petsName).getName());
						else System.out.println("This pet doesn't exist.");
						}
			//Find pet by client's name:
			else if ("3".equals(choice)) {
						System.out.println("Enter client's name: ");
						String clientsName = reader.next();
						if (isClientExist(clientsName)) System.out.println("Pet's name is " + findPetByClientsName (clientsName).getName());
						else System.out.println("This client doesn't exist.");
						}
			//Edit client's name:
			else if ("4".equals(choice)) {
						System.out.println("Enter old client's name: ");
						String clientsOldName = reader.next();
						if (isClientExist(clientsOldName)) {
							System.out.println("Enter new client's name: ");
							String clientsNewName = reader.next();
							editClientsName(clientsOldName, clientsNewName);
							System.out.println("Client's name is changed.");
							}
						else System.out.println("This client doesn't exist.");
						}
			//Edit pet's name: 
			else if ("5".equals(choice)) {
						System.out.println("Enter old pet's name: ");
						String oldPetsName = reader.next();
						if (isPetExist(oldPetsName)){
							System.out.println("Enter new pet's name: ");
							String newPetsName = reader.next();
							editPetsName (oldPetsName, newPetsName);
							System.out.println("Pet's name is changed.");
						}
						else System.out.println("This pet doesn't exist.");
						}
			//Delete client by his name:
			else if ("6".equals(choice)) {
						System.out.println("Enter client's name: ");
						String clientsName = reader.next();
						if (isClientExist(clientsName)) {
						deleteClientByHisName(clientsName);
						System.out.println("Client is deleted.");
						}
						else System.out.println("This client doesn't exist.");
						}
			else if ("7".equals(choice)) {
						System.out.println("Enter pet's name: ");
						String petsName = reader.next();
						if (isPetExist(petsName)){
							deleteClientByPetsName(petsName);
							System.out.println("Client is deleted.");
						}
						else System.out.println("This pet doesn't exist.");
						}
			//Print all clients
			else if ("8".equals(choice)) {
						for (int i = 0; i < clients.length; i++)
						System.out.println(getClient(i));
						}
			// Invalid enter
			else  {System.out.println("Invalid enter. Try again.");
						}
						
			}
}
	

