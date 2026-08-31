import java.util.*;
import java.lang.*;

public class Main {
	static long MOD = 1000000007;
	static long[] count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m + 2];
		a[0] = -1;
		for (int i = 1; i <= m; i++) {
			a[i] = sc.nextInt();
		}
		a[m + 1] = n + 1;
		long sum = 1;
		count = new long[n + 2];
		for (int i = 0; i < n; i++) {
			count[i] = -1;
		}
		count[0] = 0;
		count[1] = 1;
		for (int i = 2; i < n + 2; i++) {
			count[i] = (count[i - 1] % MOD + count[i - 2] % MOD) % MOD;
		}
		for (int i = 1; i < m + 2; i++) {
			int step = a[i] - a[i - 1] - 1;
			sum *= count[step];
			sum %= MOD;
		}
		System.out.println(sum);
	}
}
