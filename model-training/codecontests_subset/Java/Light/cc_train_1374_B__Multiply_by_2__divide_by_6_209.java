

import java.util.Scanner;

public class Multiplyby2Divideby6 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		while(t-->0) {
			int n=scan.nextInt();
			int temp=0;
			while(n>1) {
				if(n%6==0) {
					n=n/6;
					temp++;
				}
				else {
					n=n*2;
					temp++;
				}
			}
			if(temp>=0 && n==1)System.out.println(temp);
			else System.out.println("-1");
		}
	}

}
