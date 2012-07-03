package grc.disca.autopricing.model;

public class Mobile {
	private int id;
	private String name;
	private String mac;
	
	public Mobile(int id, String name, String mac) {
		super();
		this.id = id;
		this.name = name;
		this.mac = mac;
	}
	
	public Mobile() {
		super();
		this.id = -1;
		this.name = "";
		this.mac = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", name=" + name + ", mac=" + mac + "]";
	}
	
	
	
}
