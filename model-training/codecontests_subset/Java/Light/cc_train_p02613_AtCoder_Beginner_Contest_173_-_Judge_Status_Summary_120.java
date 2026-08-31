

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int sumAC =0;
			int sumWA =0;
			int sumTLE =0;
			int sumRE =0;

			for(int i=0;i<N;i++) {
				String judge = sc.next();
				switch(judge) {
				case "AC":
					sumAC++;
					break;
				case "WA":
					sumWA++;
					break;
				case "TLE":
					sumTLE++;
					break;
				case "RE":
					sumRE++;
					break;
				}
			}
			
			System.out.println("AC x "+sumAC);
			System.out.println("WA x "+sumWA);
			System.out.println("TLE x "+sumTLE);
			System.out.println("RE x "+sumRE);		
	}	
}