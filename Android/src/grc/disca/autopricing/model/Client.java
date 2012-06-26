package grc.disca.autopricing.model;

public class Client {

	private String name;
	private String company;
	
	public Client(String name, String company) {
		super();
		this.name = name;
		this.company = company;
	}
	
	public Client() {
		super();
		this.name = "";
		this.company = "";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public String toString() {
		return "Client [name=" + name + ", company=" + company + "]";
	}
	
}
