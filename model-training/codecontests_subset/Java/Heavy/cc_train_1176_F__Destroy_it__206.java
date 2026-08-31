import java.io.*;
import java.util.*;

public class CF1176F {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[][] aa = new long[n][4];
		long[][] bb = new long[n][4];
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			long d11 = -1, d12 = -1, d13 = -1, d2 = -1, d3 = -1;
			while (k-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				if (c == 2)
					d2 = Math.max(d2, d);
				else if (c == 3)
					d3 = Math.max(d3, d);
				else {
					if (d11 < d) {
						d13 = d12; d12 = d11; d11 = d;
					} else if (d12 < d) {
						d13 = d12; d12 = d;
					} else if (d13 < d)
						d13 = d;
				}
			}
			aa[i][0] = bb[i][0] = 0;
			aa[i][1] = bb[i][1] = Math.max(d11, Math.max(d2, d3));
			if (d11 > 0 && d12 > 0 && d2 < 0) {
				aa[i][2] = d11 + d12;
				bb[i][2] = d11;
			} else if (d11 > 0 && d12 < 0 && d2 > 0) {
				aa[i][2] = d11 + d2;
				bb[i][2] = Math.max(d11, d2);
			} else if (d11 > 0 && d12 > 0 && d2 > 0) {
				aa[i][2] = d11 + Math.max(d12, d2);
				bb[i][2] = Math.max(d11, d2);
			} else {
				aa[i][2] = -1;
				bb[i][2] = -1;
			}
			if (d13 > 0) {
				aa[i][3] = d11 + d12 + d13;
				bb[i][3] = d11;
			} else {
				aa[i][3] = -1;
				bb[i][3] = -1;
			}
		}
		long[] dp = new long[10];
		dp[0] = 0;
		for (int r = 1; r < 10; r++)
			dp[r] = -1;
		long[] dq = new long[10];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dq, -1);
			for (int r = 0; r < 10; r++) {
				if (dp[r] < 0)
					continue;
				for (int h = 0; h < 4; h++) {
					long a = aa[i][h];
					if (a < 0)
						continue;
					long b = bb[i][h];
					int r_ = (r + h) % 10;
					dq[r_] = Math.max(dq[r_], dp[r] + a + (r_ < r ? b : 0));
				}
			}
			long[] tmp = dp; dp = dq; dq = tmp;
		}
		long ans = 0;
		for (int r = 0; r < 10; r++)
			ans = Math.max(ans, dp[r]);
		System.out.println(ans);
	}
}
