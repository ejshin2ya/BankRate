package start;

public class SpecialRateBank extends Bank{
	private double specialRate;
	private int limitNum;
	
	public double getSpecialRate() {
		return specialRate;
	}
	public void setSpecialRate(double specialRate) {
		this.specialRate = specialRate;
	}
	public int getLimitNum() {
		return limitNum;
	}
	public void setLimitNum(int limitNum) {
		this.limitNum = limitNum;
	}
	
	public SpecialRateBank() {
		super();
	}
	
	public SpecialRateBank(double rate, String name, String type, int term, String location, double specialRate, int limitNum) {
		super(rate, name, type, term, location);
		this.specialRate=specialRate;
		this.limitNum=limitNum;
	}
	@Override
	public String toString() {
		return super.toString()+"\nSpecialRateBank [specialRate=" + specialRate + ", limitNum=" + limitNum + "]";
	}
	
	
}
