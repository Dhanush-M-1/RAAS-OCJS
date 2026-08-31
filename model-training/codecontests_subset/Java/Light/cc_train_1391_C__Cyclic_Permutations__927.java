import java.util.*;

public class _1391C {
	static int MOD = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long pow = exp(2, n-1);
		long fac = 1;
		for (int i = 2; i <= n; i++) {
			fac = (fac * i) % MOD;
		}
		System.out.println((fac-pow+MOD)%MOD);
	}
	
	public static long exp(long base, int power) {
		if (power == 0) {
			return 1;
		}
		long ans = exp(base, power/2);
		ans = (ans * ans) % MOD;
		if (power % 2 == 1) {
			ans = (ans * base) % MOD;
		}
		return ans;
	}

}
