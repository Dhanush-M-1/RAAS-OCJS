// practice with rainboy
import java.io.*;
import java.util.*;

public class CF449D extends PrintWriter {
	CF449D() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF449D o = new CF449D(); o.main(); o.flush();
	}

	static final int MD = 1000000007;
	int count1(int a) {
		return a == 0 ? 0 : count1(a & a - 1) + 1;
	}
	long power(int a, int k) {
		if (k == 0)
			return 1;
		long p = power(a, k / 2);
		p = p * p % MD;
		if (k % 2 == 1)
			p = p * a % MD;
		return p;
	}
	void main() {
		int n = sc.nextInt();
		int[] dp = new int[1 << 20];
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			dp[a]++;
		}
		for (int h = 0; h < 20; h++)
			for (int a = 0; a < 1 << 20; a++)
				if ((a & 1 << h) != 0)
					dp[a ^ 1 << h] += dp[a];
		int ans = 0;
		for (int a = 0; a < 1 << 20; a++) {
			int cnt = (int) power(2, dp[a]) - 1;
			ans = (count1(a) % 2 == 0 ? ans + cnt : ans - cnt) % MD;
		}
		if (ans < 0)
			ans += MD;
		println(ans);
	}
}
