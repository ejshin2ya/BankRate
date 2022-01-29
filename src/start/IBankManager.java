package start;

import java.util.List;

public interface IBankManager {
	void add(Bank b);
	List<Bank> getList();
	List<Bank> searchByBank(String name) throws BankNotFoundException;
	void removeBank(String name) throws BankNotFoundException;
	List<SpecialRateBank> getSpecialRateBanks();
	List<SpecialRateBank> getHighSpecialRate();
}
