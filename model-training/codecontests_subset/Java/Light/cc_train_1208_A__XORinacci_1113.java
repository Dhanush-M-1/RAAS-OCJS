import java.util.ArrayList;
import java.util.Scanner;

public class CF_1208A {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T-->0) {
			int a=sc.nextInt(),b=sc.nextInt(),n=sc.nextInt();
			int c=a^b;
			if(n%3==0) {
				System.out.println(a);
			}
			else {
				if(n%3==1) System.out.println(b);
				else System.out.println(c);
			}
		}
	}
}
