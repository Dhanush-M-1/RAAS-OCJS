
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=0;i<t;i++) {
			boolean ok = true;
			long a = sc.nextLong();
			long b = sc.nextLong();
			long c = sc.nextLong();
			long d = sc.nextLong();
			if(a<b) {
				ok = false;
			}
			if(d<b) {
				ok = false;
			}
			long gcd = gcd(b,d);
			
			if (a>=c+1) {
				long tmp = a-gcd*((a-c-1)/gcd);
				if(tmp<b) {
					ok = false;
				}
			}
			
			System.out.println(ok?"Yes":"No");
		}
	}
	
	static long gcd (long x, long y) {
		if (x<y) {
			return gcd(y,x);
		} else {
			if (x%y==0) {
				return y;
			} else {
				return gcd(y,x%y);
			}
		}
	}
}
