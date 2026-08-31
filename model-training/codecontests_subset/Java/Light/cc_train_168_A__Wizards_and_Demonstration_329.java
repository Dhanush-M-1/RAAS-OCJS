

import java.util.Scanner;

public class WizardsandDemonstration {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int x=scan.nextInt();
		int y=scan.nextInt();
		double ans=((double)y/100)*n;
		ans=Math.ceil(ans);
		if((int)ans>x)System.out.println((int)ans-x);
		else System.out.println("0");

	}

}
