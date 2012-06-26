package grc.disca.autopricing.model;

public class Vehicle {
	private String name;
	private String color;
	private String frame;
	private Client client;
	
	public Vehicle(String name, String color, String frame, Client client) {
		super();
		this.name = name;
		this.color = color;
		this.frame = frame;
		this.client = client;
	}
	
	public Vehicle() {
		super();
		this.name = "";
		this.color = "";
		this.frame = "";
		this.client = new Client();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFrame() {
		return frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public String getClient() {
		return client.toString();
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", color=" + color + ", frame="
				+ frame + ", client=" + client.toString() + "]";
	}
	
	
	
}
