// practice with rainboy
import java.io.*;
import java.util.*;

public class CF875D {
	static final int K = 30;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] aa = new int[n];
		for (int i = 0; i < n; i++)
			aa[i] = Integer.parseInt(st.nextToken());
		Integer[] ii = new Integer[n];
		for (int i = 0; i < n; i++)
			ii[i] = i;
		Arrays.sort(ii, (i, j) -> aa[i] != aa[j] ? aa[i] - aa[j] : i - j);
		int[] pp = new int[n];
		for (int i = 0, j; i < n; i = j) {
			j = i + 1;
			while (j < n && aa[ii[j]] == aa[ii[i]])
				j++;
			int p = -1;
			for (int h = i; h < j; h++) {
				pp[ii[h]] = p;
				p = ii[h];
			}
		}
		int[][] bb = new int[n][K];
		for (int h = 0; h < K; h++) {
			int p = -1;
			for (int i = 0; i < n; i++) {
				bb[i][h] = p;
				if ((aa[i] & 1 << h) != 0)
					p = i;
			}
		}
		int[][] dd = new int[n][K];
		for (int h = 0; h < K; h++) {
			int q = n;
			for (int i = n - 1; i >= 0; i--) {
				dd[i][h] = q;
				if ((aa[i] & 1 << h) != 0)
					q = i;
			}
		}
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			int p = -1;
			for (int h = 0; h < K; h++)
				if ((aa[i] & 1 << h) == 0)
					p = Math.max(p, bb[i][h]);
			dp[i] = p;
		}
		int[] dq = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			int q = n;
			for (int h = 0; h < K; h++)
				if ((aa[i] & 1 << h) == 0)
					q = Math.min(q, dd[i][h]);
			dq[i] = q;
		}
		long ans = (long) n * (n + 1) / 2;
		for (int i = 0; i < n; i++)
			ans -= (long) (i - Math.max(dp[i], pp[i])) * (dq[i] - i);
		System.out.println(ans);
	}
}
