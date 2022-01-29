package start;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class BankManager implements IBankManager {
	private static BankManager instance = new BankManager();
	public static BankManager getInstance() {
		return instance;
	}
	private BankManager() {
//		bankList= new ArrayList<Bank>();
//		specialbankList = new ArrayList<SpecialRateBank>();
		this.load();
	}

	private List<Bank> bankList; 

	@Override
	public void add(Bank b) {
		bankList.add(b);
		save();
	}
	@Override
	public List<Bank> getList() {
		List<Bank> bList = new ArrayList<Bank>(this.bankList);
		return bList;
	}
	@Override
	public List<Bank> searchByBank(String name) throws BankNotFoundException {
		List<Bank> bnList = new ArrayList<Bank>();
		for(Bank b : this.bankList) {
			if(b.getName().equals(name))
				bnList.add(b);
		}
			return bnList;
	}
	@Override
	public void removeBank(String name) throws BankNotFoundException {
		List<Bank> aList = searchByBank(name);
		for(Bank b : aList)
			this.bankList.remove(b);
	}
	@Override
	public List<SpecialRateBank> getSpecialRateBanks() {
		List<SpecialRateBank> sList = new ArrayList<SpecialRateBank>();
		for(int i=0; i<this.bankList.size(); i++) {
			if(this.bankList.get(i) instanceof SpecialRateBank)
				sList.add((SpecialRateBank) this.bankList.get(i));
		}
		return sList;
	}
	@Override
	public List<SpecialRateBank> getHighSpecialRate() {
		List<SpecialRateBank> shList = getSpecialRateBanks();
		List<SpecialRateBank> ssList = new ArrayList<SpecialRateBank>();
		double max=0;
		for(SpecialRateBank s : shList) {
			if(s.getSpecialRate()>max)
				max=s.getSpecialRate();
		}
		for(SpecialRateBank s1 : shList) {
			if(s1.getSpecialRate()==max)
				ssList.add(s1);
		}
		return ssList;
	}
    public void save() {
    	Gson gson = new Gson();
    	String result = gson.toJson(this.bankList);
        try( ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("data/bank.json"))){
            os.writeObject(result);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void load() {
    	Gson gson = new Gson();
        try(ObjectInputStream is = new ObjectInputStream(new FileInputStream("data/bank.json"))){
            this.bankList = gson.fromJson((String)is.readObject(), new TypeToken<List<Bank>>() {}.getType());
        } catch (Exception e) {
//            e.printStackTrace();
            this.bankList = new ArrayList<Bank>();
        }
    }


}
