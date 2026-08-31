import java.util.*;

public class Main {
	Scanner sc = new Scanner(System.in);
	void doIt() {
		long n = sc.nextLong();
		long p = sc.nextLong();
		if(n == 1) {
			System.out.println(p);
			return;
		}
		int len = (int)Math.ceil(Math.pow(p, 1.0/n));
		//System.out.println(Math.pow(p, 1.0/n)+ " "+pp);
		boolean[] prime = makePrime(len);
		long ans = 1;
		long[] f = new long[len + 1];
		Arrays.fill(f, 0);
		for(int i = 2; i <= len; i++) {
			if(prime[i]) {
				while(p % i == 0) {
					f[i]++;
					p /= i;
					//System.out.println(p);
				}
				//System.out.println(ans + " " + Arrays.toString(f));
				ans *= Math.pow(i, f[i] / n);
			}
			//if(p == 1)break;
		}
		System.out.println(ans);
	}
	boolean[] makePrime(int n) {
		boolean[] p = new boolean[n + 1];
		Arrays.fill(p, true);
		p[0] = false; p[1] = false;
		for(int i = 2; i <= n; i++) {
			if(p[i]) {
				for(int j = i + i; j <= n; j += i) {
					p[j] = false;
				}
			}
		}
		//System.out.println(n + " " +Arrays.toString(p));
		return p;
	}
	
	public static void main(String[] args) {
		new Main().doIt();
	}
}
