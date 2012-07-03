package grc.disca.autopricing.model;

public class Track {
	private int id;
	private String name;
	private float price;
	//private WKT area  
	
	public Track(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public Track() {
		super();
		this.id = -1;
		this.name = "";
		this.price = 0;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Track [ id=" +id + ", name=" + name + ", price=" + price + "]";
	}
	
}
