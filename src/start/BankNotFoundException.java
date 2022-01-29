package start;

public class BankNotFoundException extends Exception {
	public BankNotFoundException(String name) {
		super(name+"은행명을 찾을 수 없습니다.");
	}

}
