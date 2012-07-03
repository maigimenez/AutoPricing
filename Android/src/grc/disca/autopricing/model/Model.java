package grc.disca.autopricing.model;

import java.util.ArrayList;


public class Model {

	private ArrayList<Client> clients;
	private ArrayList<Invoice> invoices;
	private ArrayList<Mobile> mobiles;
	private ArrayList<Test> tests;
	private ArrayList<Track> tracks;
	private ArrayList<Vehicle> vehicles;

	public Model() {
		super();
		clients = new ArrayList<Client>();
		invoices = new ArrayList<Invoice>();
		mobiles = new ArrayList<Mobile>();
		tests = new ArrayList<Test>();
		tracks = new ArrayList<Track>();
		vehicles = new ArrayList<Vehicle>();
		
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public ArrayList<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(ArrayList<Invoice> invoices) {
		this.invoices = invoices;
	}

	public ArrayList<Mobile> getMobiles() {
		return mobiles;
	}

	public void setMobiles(ArrayList<Mobile> mobiles) {
		this.mobiles = mobiles;
	}

	public ArrayList<Test> getTests() {
		return tests;
	}

	public void setTests(ArrayList<Test> tests) {
		this.tests = tests;
	}

	public ArrayList<Track> getTracks() {
		return tracks;
	}

	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}

	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public Client getClient(String client) throws noClientFound {
		for(int i=0;i<clients.size();i++){
			if(clients.get(i).getName().equals(client)){
				return clients.get(i);
			}
		}
		throw new noClientFound(client);
	}

	
	public Track getTrack(int trackID) throws noTrackFound{

		for(int i=0;i<tracks.size();i++){
			if(tracks.get(i).getId() == trackID){
				return tracks.get(i);
			}
		}
		throw new noTrackFound(trackID);
	} 
	
	public class noClientFound extends Exception{

		private static final long serialVersionUID = 1L;

		public noClientFound(String client) {
	        super("We haven't found a client with the name:  " + client);
		}
		public noClientFound(int clientID) {
	        super("We haven't found a client with the id:  " + clientID);
		}
	}
	
	public class noTrackFound extends Exception{

		private static final long serialVersionUID = 1L;

		public noTrackFound(int trackID) {
	        super("We haven't found a track with the id:  " + trackID);
		}
	}
	
}
