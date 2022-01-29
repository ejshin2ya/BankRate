package start;

public class Bank {
	private double rate;
	private String name;
	private String type;
	private int term;
	private String location;
	
	public Bank() {
		
	}
	public Bank(double rate, String name, String type, int term, String location) {
		this.rate = rate;
		this.name = name;
		this.type = type;
		this.term = term;
		this.location = location;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Bank \n rate=" + rate + "\n name=" + name + "\n type=" + type + "\n term=" + term + "\n location=" + location;
	}
	
	
	
	

}
