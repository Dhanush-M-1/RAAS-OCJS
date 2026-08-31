// practice with rainboy
import java.io.*;
import java.util.*;

public class CF571B extends PrintWriter {
	CF571B() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF571B o = new CF571B(); o.main(); o.flush();
	}

	static final int INF = 0x3f3f3f3f;
	void main() {
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] aa = new int[n];
		for (int i = 0; i < n; i++)
			aa[i] = sc.nextInt();
		aa = Arrays.stream(aa).boxed().sorted().mapToInt($->$).toArray();
		int r = n % k, l = k - r, m0 = n / k, m1 = m0 + 1;
		int[][] dp = new int[l + 1][r + 1];
		for (int i = 0; i <= l; i++)
			for (int j = 0; j <= r; j++)
				dp[i][j] = -1;
		dp[0][0] = 0;
		for (int i = 0; i <= l; i++)
			for (int j = 0; j <= r && i + j < k; j++) {
				int x = dp[i][j];
				if (x == -1)
					continue;
				int h = i * m0 + j * m1;
				int y = x + (h == 0 ? 0 : aa[h] - aa[h - 1]);
				if (i < l)
					dp[i + 1][j] = Math.max(dp[i + 1][j], y);
				if (j < r)
					dp[i][j + 1] = Math.max(dp[i][j + 1], y);
			}
		println(aa[n - 1] - aa[0] - dp[l][r]);
	}
}
