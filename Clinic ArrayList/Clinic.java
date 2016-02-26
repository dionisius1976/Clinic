package ru.lesson.lessons;
import java.util.ArrayList;
import java.util.Scanner;

public class Clinic {
		
	/**
	* This class describes Clinic and make operations
	* with clients and their pets.
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
			for(Client cl: clients){
				if (clientName.equalsIgnoreCase(cl.getName())) return true;
				}
			return false;
		}
		
		public boolean isPetExist(String petName){
			for(Client cl: clients){
				if (petName.equalsIgnoreCase(cl.getPet().getName())) return true;
				}
			return false;
		}

		public Client findClientByPetsName (final String petsName){
			for(Client cl: clients){
			if (petsName.equalsIgnoreCase(cl.getPet().getName())) return cl;}
			return null;
		}
		
		public Pet findPetByClientsName (final String clientsName){
			for(Client cl: clients){
			if (clientsName.equalsIgnoreCase(cl.getName())) return cl.getPet();}
			return null;
		}
		
		public void editClientsName (final String clientsOldName, final String clientsNewName){
			for(Client cl: clients){
			if (clientsOldName.equalsIgnoreCase(cl.getName())) {
				
				clients.add(new Client(clientsNewName, cl.getPet()));
				clients.remove(cl);
				break;}
			} 		
		}
		
		public void editPetsName (final String petsOldName, final String petsNewName){
			for(Client cl: clients){
			if (petsOldName.equalsIgnoreCase(cl.getPet().getName())) {
				cl.getPet().setName(petsNewName);
				break;}
			} 		
		}
		
		public void deleteClientByHisName (final String clientsName){
			for(Client cl: clients){
			if (clientsName.equalsIgnoreCase(cl.getName())) {
				clients.remove(cl);
				break;}
			}
		}
		
		public void deleteClientByPetsName (final String petsName){
			for(Client cl: clients){
			if (petsName.equalsIgnoreCase(cl.getPet().getName())) {
				clients.remove(cl);
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
									if ("cat".equalsIgnoreCase(petsType)) 
									 clients.add((new Client(clientsName, new Cat(petsName))));
									else if ("dog".equalsIgnoreCase(petsType)) 
									 clients.add((new Client(clientsName, new Dog(petsName))));
									else System.out.println("Wrong pet's type! Client " 
									 + clientsName + " is not added. Try again.");
							}
							else System.out.println("Pet " + petsName + 
							 " is already exist. Client " + clientsName + " is not added. Try again.");
						}
						else System.out.println("Client " + clientsName + " is already exist. Try again.");
					}						
			// Find client by pet's name:
			else if ("2".equals(choice)) {
						System.out.print("Enter pet's name: ");
						String petsName = reader.next();
						System.out.println();
						if (isPetExist(petsName))System.out.println("Client's name is " 
						 + findClientByPetsName(petsName).getName());
						else System.out.println("Pet " + petsName + " doesn't exist. Try again.");
						}
			//Find pet by client's name:
			else if ("3".equals(choice)) {
						System.out.println("Enter client's name: ");
						String clientsName = reader.next();
						if (isClientExist(clientsName)) System.out.println("Pet's name is " 
						 + findPetByClientsName(clientsName).getName());
						else System.out.println("Client " +  clientsName + " doesn't exist. Try again.");
						}
			//Edit client's name:
			else if ("4".equals(choice)) {
						System.out.println("Enter old client's name: ");
						String clientsOldName = reader.next();
						if (isClientExist(clientsOldName)) {
							System.out.println("Enter new client's name: ");
							String clientsNewName = reader.next();
							if (!isClientExist(clientsNewName)) {
								editClientsName(clientsOldName, clientsNewName);
								System.out.println("Client's name is changed.");
							}
							else System.out.println("Client " +  clientsNewName 
							 + " is already exist. Try again.");
							}
						else System.out.println("Client " +  clientsOldName 
						 + " doesn't exist. Try again.");
						}
			//Edit pet's name: 
			else if ("5".equals(choice)) {
						System.out.println("Enter old pet's name: ");
						String oldPetsName = reader.next();
						if (isPetExist(oldPetsName)){
							System.out.println("Enter new pet's name: ");
							String newPetsName = reader.next();
							if (!isPetExist(newPetsName)){
								editPetsName (oldPetsName, newPetsName);
								System.out.println("Pet's name is changed.");
							}
							else System.out.println("Pet " + newPetsName 
							 + " is already exist. Try again.");
						}
						else System.out.println("Pet " + oldPetsName 
						 + " doesn't exist. Try again.");
						}
			//Delete client by his name:
			else if ("6".equals(choice)) {
						System.out.println("Enter client's name: ");
						String clientsName = reader.next();
						if (isClientExist(clientsName)) {
							deleteClientByHisName(clientsName);
							System.out.println("Client " + clientsName + " is deleted.");
						}
						else System.out.println("Client " + clientsName 
						 + " doesn't exist. Try again.");
						}
			//Delete client by his pet's name:
			else if ("7".equals(choice)) {
						System.out.println("Enter pet's name: ");
						String petsName = reader.next();
						if (isPetExist(petsName)){
							deleteClientByPetsName(petsName);
							System.out.println("Client is deleted.");
						}
						else System.out.println("Pet " + petsName + " doesn't exist. Try again.");
						}
			//Print all clients
			else if ("8".equals(choice)) {
						if (clients.isEmpty()) System.out.println("Clinic list is empty.");
						else for (Client cl: clients) System.out.println(cl);
						}
			// Invalid enter
			else  {System.out.println("Invalid enter. Try again.");
			
			}
						
		}
}
	
	

