package start;

import java.util.Scanner;

public class BankTest {

	public static void main(String[] args) {
		IBankManager bm = BankManager.getInstance();
		Scanner sc = new Scanner(System.in);
		int sel=0;
		do {
			System.out.println("1.은행 금리 정보 추가");
			System.out.println("2.모든 은행 정보 조회");
			System.out.println("3.은행명 입력 후 해당 정보 조회");
			System.out.println("4.은행명 입력 후 해당 정보 삭제");
			System.out.println("5.특판 금리 진행하는 은행조회");
			System.out.println("6.특판 금리가 가장 높은 은행 조회");
			System.out.println("0.종료");
			sel = sc.nextInt();
			if(sel==1) {
				System.out.print("이율 : ");
				double rate = sc.nextDouble();
				System.out.print("은행명 : ");
				String name = sc.next();
				System.out.print("상품명: ");
				String type = sc.next();
				System.out.print("가입기간 : ");
				int term = sc.nextInt();
				System.out.print("위치 : ");
				String location = sc.next();
				System.out.print("특판금리가 있으면 1, 없으면 0, 띄고 특판금리 입력 띄고 가입계좌수");
				int isSpecial = sc.nextInt();
				if(isSpecial==1) {
					double specialRate = sc.nextDouble();
					int limitNum = sc.nextInt();
					bm.add(new SpecialRateBank(rate, name, type, term, location, specialRate, limitNum));
				}else {
					bm.add(new Bank(rate, name, type, term, location));
				}
			}
			else if(sel==2) {
				for(Bank b : bm.getList())
					System.out.println(b);
			}
			else if(sel==3) {
				System.out.print("은행명 : ");
				String name = sc.next();
				try {
					for(Bank b : bm.searchByBank(name))
						System.out.println(b);
				}catch (BankNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
			}
			else if(sel==4) {
				System.out.println("삭제할 은행명 :");
				String name = sc.next();
				try {
					bm.removeBank(name);
					System.out.println("삭제가 완료되었습니다.");
				} catch(BankNotFoundException e){
					System.out.println(e.getMessage());
				}
				
			}
			else if(sel==5) {
				for(Bank sb : bm.getSpecialRateBanks())
					System.out.println(sb);
			}
			else if(sel==6) {
				for(Bank b : bm.getHighSpecialRate())
					System.out.println(b);
			}
		}while(sel!=0);
		if(bm instanceof BankManager)
			((BankManager) bm).save();

	}

}
