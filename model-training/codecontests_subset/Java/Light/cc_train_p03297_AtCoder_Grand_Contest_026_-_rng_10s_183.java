import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++) {
			long a = in.nextLong();
			long b = in.nextLong();
			long c = in.nextLong();
			long d = in.nextLong();
			judge(a, b, c, d);
		}
	}
	
	public static void judge(long a,long b,long c,long d) {
		if(a<b || d<b) System.out.println("No");
		else {
			long g = gcd(b,d);
			long max = b - g + a%g;
			if(max>c) System.out.println("No");
			else System.out.println("Yes");
		}
	}
	
	public static long gcd(long p,long q) {
		while(q>0) {
			long t = p%q;
			p = q;
			q = t;
		}
		return p;
	}

}