// practice with kaiboy
import java.io.*;
import java.util.*;

public class Main extends PrintWriter {
	Main() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		Main o = new Main(); o.main(); o.flush();
	}

	void main() {
		byte[] cc = sc.next().getBytes();
		int n = cc.length;
		int k = sc.nextInt();
		int[][] dp = new int[n + 1][k + 1];
		int[][] dq = new int[n + 1][k + 1];
		dp[0][0] = 0;
		dq[0][0] = 1;
		for (int i = 0; i < n; i++) {
			int d = cc[i] - '0';
			for (int j = 0; j <= k; j++) {
				dp[i + 1][j] += dp[i][j];
				if (j < k)
					dp[i + 1][j + 1] += dp[i][j] * 9;
				if (d == 0)
					dq[i + 1][j] += dq[i][j];
				else {
					dp[i + 1][j] += dq[i][j];
					if (j < k) {
						dp[i + 1][j + 1] += dq[i][j] * (d - 1);
						dq[i + 1][j + 1] += dq[i][j];
					}
				}
			}
		}
		println(dp[n][k] + dq[n][k]);
	}
}
