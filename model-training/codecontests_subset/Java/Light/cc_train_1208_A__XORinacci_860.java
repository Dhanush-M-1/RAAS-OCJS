import java.util.*;

public class manthan19a {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for(int tt=0;tt<t;tt++) {
			int a=scan.nextInt(), b=scan.nextInt(), n=scan.nextInt();
			if(n%3==0) System.out.println(a);
			if(n%3==1) System.out.println(b);
			if(n%3==2) System.out.println(a^b);
		}
	}
}