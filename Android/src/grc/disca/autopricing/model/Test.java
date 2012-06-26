package grc.disca.autopricing.model;

public class Test {
	private Mobile mobile;
	private Vehicle vehicle;
	private Track track;
	private int minutes;
	private float price;
	
	public Test(Mobile mobile, Vehicle vehicle, Track track, int minutes,
			float price) {
		super();
		this.mobile = mobile;
		this.vehicle = vehicle;
		this.track = track;
		this.minutes = minutes;
		this.price = price;
	}
	
	public Test() {
		super();
		this.mobile = new Mobile();
		this.vehicle = new Vehicle();
		this.track = new Track();
		this.minutes = 0;
		this.price = 0;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Test [mobile=" + mobile + ", vehicle=" + vehicle + ", track="
				+ track + ", minutes=" + minutes + ", price=" + price + "]";
	}
	
}
