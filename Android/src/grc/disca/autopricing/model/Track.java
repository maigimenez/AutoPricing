package grc.disca.autopricing.model;

public class Track {
	private String name;
	private float price;
	//private  
	
	public Track(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public Track() {
		super();
		this.name = "";
		this.price = 0;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Track [name=" + name + ", price=" + price + "]";
	}
	
}
