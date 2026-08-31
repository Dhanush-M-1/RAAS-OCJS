import java.util.Scanner;

class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Friend f;
		int n,nt;
		
		while(true){
			n = sc.nextInt();
			if(n == 0){
				break;
			}
			f = new Friend(n);
			
			for(int i=0;i<12;i++){
				f.setSavings(sc.nextInt(),sc.nextInt());
			}
			nt = f.getNextTrip();
			if(nt > 0){
				System.out.println(nt);
			}else{
				System.out.println("NA");
			}
		}
	}
}

class Friend{
	int monthCount;
	int[] savings;
	int money;
	
	Friend(int money){
		monthCount = 0;
		savings = new int[12];
		this.money = money;
	}
	
	public void setSavings(int m,int n){
		savings[monthCount] = m-n;
		monthCount++;
	}
	
	private int checkMoney(){
		for(int i=0;i<12;i++){
			money -= savings[i];
			if(money <= 0){
				return i+1;
			}
		}
		
		return 0;
	}
	
	public int getNextTrip(){
		return checkMoney();
	}
}