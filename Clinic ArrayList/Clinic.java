import java.util.ArrayList;
import java.util.Scanner;

public class Clinic {
		
	/**
	* This class describes Clinic, some operations
	* with clients and theirs pets and performs some of these operations.
	*/

	private final ArrayList <Client> clients;
	
	// Constructor
		
		public Clinic(){
			ArrayList <Client> clients = new ArrayList <Client>();
			this.clients = clients;
		}
		
		public Client getClient(int i){
			return this.clients.get(i);
		}
		
						
		public boolean isClientExist(String clientName){
			for(int i=0; i < clients.size(); i++){
				if  (clients.get(i) == null) continue;
				else if (clientName.equalsIgnoreCase(clients.get(i).getName())) return true;
				}
			return false;
		}
		
		public boolean isPetExist(String petName){
			for(int i=0; i < clients.size(); i++){
				if  (clients.get(i) == null) continue;
				else if (petName.equalsIgnoreCase(clients.get(i).getPet().getName())) return true;
				}
			return false;
		}
		
		public Client findClientByPetsName (final String petsName){
			for(int i=0; i < clients.size(); i++){
			if (petsName.equalsIgnoreCase(clients.get(i).getPet().getName())) return clients.get(i);}
			return null;
		}
		
		public Pet findPetByClientsName (final String clientsName){
			for(int i=0; i < clients.size(); i++){
			if (clientsName.equalsIgnoreCase(clients.get(i).getName())) return clients.get(i).getPet();}
			return null;
		}
		
		public void editClientsName (final String clientsOldName, final String clientsNewName){
			for(int i=0; i < clients.size(); i++){
			if (clientsOldName.equalsIgnoreCase(clients.get(i).getName())) {
				
				clients.add(new Client(clientsNewName, clients.get(i).getPet()));
				clients.remove(i);
				break;}
			} 		
		}
		
		public void editPetsName (final String petsOldName, final String petsNewName){
			for(int i=0; i < clients.size(); i++){
			if (petsOldName.equalsIgnoreCase(clients.get(i).getPet().getName())) {
				clients.get(i).getPet().setName(petsNewName); 
				break;}
			} 		
		}
		
		public void deleteClientByHisName (final String clientsName){
			for(int i=0; i < clients.size(); i++){
			if (clientsName.equalsIgnoreCase(clients.get(i).getName())) {
				clients.remove(i); 
				break;}
			}
		}
		
		public void deleteClientByPetsName (final String petsName){
			for(int i=0; i < clients.size(); i++){
			if (petsName.equalsIgnoreCase(clients.get(i).getPet().getName())) {
				clients.remove(i); 
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
							System.out.print("Enter new client's name: ");
							String clientsName = reader.next();
							if (!isClientExist(clientsName)){
								System.out.println();
								System.out.println("Enter pet's name: ");
								String petsName = reader.next();
								if (!isPetExist(petsName)){
									System.out.println("Enter pet's type (dog/cat): ");
									String petsType = reader.next();
										if ("cat".equalsIgnoreCase(petsType)) clients.add((new Client(clientsName, new Cat(petsName))));
										else if ("dog".equalsIgnoreCase(petsType)) clients.add((new Client(clientsName, new Dog(petsName))));
										else System.out.println("Wrong pet's type!");
								}
								else System.out.println("This pet is alredy exist.");
							}
							else System.out.println("This client is alredy exist.");
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
						if (clients.isEmpty()) System.out.println("Clinic list is empty.");
						else {for (Client cl: clients)
							//if (clients[i] == null);
						System.out.println(cl);
						}
						}
			// Invalid enter
			else  {System.out.println("Invalid enter. Try again.");
			
			}
						
		}
}
	
	

