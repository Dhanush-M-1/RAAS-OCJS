import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Main {

	Scanner sc = new Scanner(in);
	
	final int mod = (int)1E8+7;
	
	int mod_pow(long x, int n) {
		long res = 1;
		while (n > 0) {
			if ((n & 1) == 1) res = (res * x) % mod;
			x = (x * x) % mod;
			n >>= 1;
		}
		return (int)res;
	}
	
	//階乗
	int mod_fact(int n) {
		long res = 1;
		for (int i = 2; i <= n; i++)
			res = (res*i) % mod;
		return (int)res;
	}
	
	//nCk mod p
	int mod_comb(int n, int k) {
		if (n < 0 || k < 0 || n < k) return 0;
		long res = mod_fact(n);
		res = (res*mod_pow(mod_fact(k), mod-2)) % mod;
		res = (res*mod_pow(mod_fact(n-k), mod-2)) % mod;
		return (int)res;
	}
	
	void run() {
		int r = sc.nextInt(), c = sc.nextInt(), a1 = sc.nextInt(), a2 = sc.nextInt(), b1 = sc.nextInt(), b2 = sc.nextInt();
		int n, k, count = 1;
		n = min(abs(a1-b1), r-abs(a1-b1));
		k = min(abs(a2-b2), c-abs(a2-b2));
		
		if (abs(a1-b1) == r-abs(a1-b1)) count *= 2;
		if (abs(a2-b2) == c-abs(a2-b2)) count *= 2;
		
		out.println((mod_comb(n+k, k)*count)%mod);
	}
	
	public static void main(String[] args) {
		new Main().run();
	}

}