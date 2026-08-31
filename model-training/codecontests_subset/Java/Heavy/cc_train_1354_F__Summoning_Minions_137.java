import java.util.*;
import java.io.*;

public class SummoningMinions {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		Comparator<int[]> comp = (a, b) -> a[2] - b[2];
		
		while (--t >= 0) {
			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]), k = Integer.parseInt(line[1]);
			int[][] ab = new int[n][3];
			for (int i = 0; i < n; ++i) {
				line = br.readLine().split(" ");
				ab[i][0] = i + 1;
				ab[i][1] = Integer.parseInt(line[0]);
				ab[i][2] = Integer.parseInt(line[1]);
			}
			Arrays.sort(ab, comp);
			int[][] dp = new int[n+1][n+1];

			for (int i = 1; i <= n; ++i) {
				dp[i][0] = dp[i-1][0] + ab[i-1][2] * (k - 1);
				for (int j = 1; j < i; ++j) {
					dp[i][j] = Math.max(dp[i-1][j-1] + ab[i-1][2] * (j - 1) + ab[i-1][1], dp[i-1][j] + ab[i-1][2] * (k - 1));
				}
				dp[i][i] = dp[i-1][i-1] + ab[i-1][2] * (i - 1) + ab[i-1][1];
			}

			int[] res = new int[n*2-k];

			int j1 = k, j2 = k - 1;

			for (int i = n; i > 0; --i) {
				if (i > j1 && dp[i][j1] == dp[i-1][j1] + ab[i-1][2] * (k - 1)) {
					res[++j2] = ab[i-1][0];
				} else {
					res[--j1] = ab[i-1][0];
				}
			}

			bw.write(Integer.toString(res.length));
			bw.newLine();
			for (int i = 0; i < k - 1; ++i) {
				bw.write(Integer.toString(res[i]));
				bw.write(' ');
			}
			for (int i = k; i < n; ++i) {
				bw.write(Integer.toString(res[i]));
				bw.write(' ');
				bw.write('-');
				bw.write(Integer.toString(res[i]));
				bw.write(' ');
			}
			bw.write(Integer.toString(res[k-1]));
			bw.newLine();
		}


		br.close();
		bw.close();
	}
}