package grc.disca.autopricing.model;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {
	private int id;
	private Date date;
	private Client client;
	ArrayList<Test> tests;
	float total;
	
	public Invoice(int id, Date date, Client client, ArrayList<Test> tests, float total) {
		super();
		this.id = id;
		this.date = date;
		this.client = client;
		this.tests = tests;
		this.total = total;
	}
	
	public Invoice() {
		super();
		this.id = -1;
		this.date = new Date();
		this.client = new Client();
		this.tests = new ArrayList<Test>();
		this.total = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ArrayList<Test> getTests() {
		return tests;
	}

	public void setTests(ArrayList<Test> tests) {
		this.tests = tests;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", date=" + date + ", client=" + client + ", tests="
				+ tests + ", total=" + total + "]";
	}
	
}
