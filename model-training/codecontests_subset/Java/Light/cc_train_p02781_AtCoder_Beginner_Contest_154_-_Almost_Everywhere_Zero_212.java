
import java.util.Scanner;

public class Main {

	public static int MAX = 510000;
	public static int MOD = 1000000007;

	public static long[] f = new long[MAX];
	public static long[] finv = new long[MAX];
	public static long[] inv = new long[MAX];

	public static void ComInit() {
		f[0] = f[1] = 1;
		finv[0] = finv[1] = 1;
		inv[1] = 1;
		for(int i = 2; i < MAX; i++) {
			f[i] = f[i - 1] * i % MOD;
			inv[i] = MOD - inv[MOD % i] * (MOD / i) % MOD;
			finv[i] = finv[i - 1] * inv[i] % MOD;
		}
	}

	public static long Com(int n, int k) {
		if(n < k)
			return 0;
		if(n < 0 || k < 0)
			return 0;
		return f[n] * (finv[k] * finv[n - k] % MOD) % MOD;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ComInit();
		String n = sc.next();
		int k = sc.nextInt();
		long ans = 0;
		for(int i = 1; i < n.length(); i++) {
			if(i >= k) {
				ans += (Com(i - 1, k - 1) * Math.pow(9, k));
			}
		}
		for(int i = 0; i < n.length(); i++) {
			int top = Integer.valueOf(String.valueOf((n.charAt(i))));
			if(top != 0) {
				top--;
				ans += (Com(n.length() - (i + 1), k - 1) * Math.pow(9, k - 1) * top);
				if(i != 0) {
					ans += (Com(n.length() - (i + 1), k) * Math.pow(9, k));
				}
				k--;
			}
			if(k == 0) {
				ans++;
				break;
			}
		}
		System.out.println(ans);
	}

}
