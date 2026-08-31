

import java.util.LinkedList;
import java.util.Scanner;

public class Sample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
			int n = sc.nextInt();
			int two = 0;
			int three = 0;
			int f=0;
			
			if (n==1) System.out.println(0);
			else {
			while (n>0) {
				 if (n%2==0) {
					n=n/2;
					two++;
					continue;
				} 
				if (n%3==0) {
					three++;
					n=n/3;
					continue;
				}
				if (n==1) break;
				f=1;
				System.out.println(-1);
				break;
			}
			
			if (f==0) {
				if (two>three) System.out.println(-1);
				else {
					System.out.println(three + (three-two));
				}
			}
			}
		}
		
	}
}
