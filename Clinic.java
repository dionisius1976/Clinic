
public class Clinic {
		
	/**
	* This class describes Clinic
	*/

	private final Client[] clients;
		
		public Clinic(final int size){
			this.clients = new Client[size];
		}
		
		public Client getClient(int i){
			return this.clients[i];
		}
		
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
	
}
