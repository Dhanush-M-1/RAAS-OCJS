import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		while(true){
			int tripCost = stdIn.nextInt();
			if(tripCost == 0){break;}

			int savingMoney = 0;
			int necessaryMonth = -1;
			boolean checkFlag = false;

			for(int i=1;i<=12;i++){
				int income = stdIn.nextInt();
				int payOut = stdIn.nextInt();

				savingMoney = savingMoney + income - payOut;
				if(checkFlag == false & savingMoney >= tripCost){
					necessaryMonth = i;
					checkFlag = true;
				}
			}
			if(necessaryMonth == -1){
				System.out.println("NA");
			}else{
				System.out.println(necessaryMonth);
			}
		}
	}
}