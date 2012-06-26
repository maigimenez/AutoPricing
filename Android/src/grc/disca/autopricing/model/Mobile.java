package grc.disca.autopricing.model;

public class Mobile {
	private String name;
	private String mac;
	
	public Mobile(String name, String mac) {
		super();
		this.name = name;
		this.mac = mac;
	}
	
	public Mobile() {
		super();
		this.name = "";
		this.mac = "";
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
		return "Mobile [name=" + name + ", mac=" + mac + "]";
	}
	
	
	
}
