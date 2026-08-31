
import java.util.Scanner;

public class Xorinacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int T=s.nextInt();
		for(int i=0;i<T;i++) {
		int a=s.nextInt();
		int b=s.nextInt();
		int n=s.nextInt();
		n=n%3;
		if(n==0) {
			System.out.println(a);
		}
		else if(n==1) {
			System.out.println(b);
		}
		else {
       System.out.println(a^b);
		}

	}

}
}