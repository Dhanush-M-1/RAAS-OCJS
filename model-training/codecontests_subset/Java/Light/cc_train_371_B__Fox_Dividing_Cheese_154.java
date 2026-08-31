import java.util.Scanner;


public class FoxDividingCheese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		long a=scn.nextLong();
		long b=scn.nextLong();
		long op=0;

		long counta=0;
		long countb=0;

		//5555555555555555555555555555555


		while(true){
			if(a%5==0){
				a=a/5;
				counta++;
			}
			else
				break;
		}

		while(true){
			if(b%5==0){
				b=b/5;
				countb++;
			}
			else
				break;
		}

		op+=Math.abs(counta-countb);


		//33333333333333333333333333333333333

		counta=0;
		countb=0;

		while(true){
			if(a%3==0){
				a=a/3;
				counta++;
			}
			else
				break;
		}

		while(true){
			if(b%3==0){
				b=b/3;
				countb++;
			}
			else
				break;
		}
		
		op+=Math.abs(counta-countb);


		//22222222222222222222222222222222222
		counta=0;
		countb=0;

		while(true){
			if(a%2==0){
				a=a/2;
				counta++;
			}
			else
				break;
		}

		while(true){
			if(b%2==0){
				b=b/2;
				countb++;
			}
			else
				break;
		}

		op+=Math.abs(counta-countb);
		
		if(a!=b){
			System.out.println(-1);
			return;
		}

		System.out.println(op);

		return;
	}

}
