import java.util.*;

public class Main {
	final int MOD = 100000000;
	final int MAX = Integer.MAX_VALUE;
	final long LMAX = Long.MAX_VALUE;
	final int LEN = 100000;
	Scanner sc = new Scanner(System.in);

	void doIt() {
		long n = sc.nextLong();
		long p = sc.nextLong();
		int w = sc.nextInt();
		int d = sc.nextInt();
		long x = -1, y = -1;
		for(long i = n; i >= n - d; i--) {
			 if((p - w * i) % d == 0) {
				 x = i;
				 y = (p - w * i) / d;

				 break;
			 }
		}
		if(y < 0) {
			long gcd = gcd(w, d);
			w /= gcd;
			d /= gcd;
			long b = (y - w + 1) / w;
			y -= b * w;
			x += b * d;
		}
		if(x >= 0 && y >= 0 && x + y <= n) {
			System.out.println(x + " " + y + " " + (n - x - y));
		}
		else System.out.println(-1);
		 
	}
	
	long gcd(long a, long b) {
		return (a == 0) ? b : gcd(b % a , a);
	}

	
		
	public static void main(String[] args) {
		new Main().doIt();
	}
}