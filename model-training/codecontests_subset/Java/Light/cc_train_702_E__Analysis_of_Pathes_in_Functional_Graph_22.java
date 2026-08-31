import java.io.*;
import java.util.*;

public class CF702E {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		int l = 0;
		while (1L << l <= k)
			l++;
		int[][] ff = new int[l][n];
		long[][] ss = new long[l][n];
		int[][] mm = new int[l][n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			ff[0][i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			ss[0][i] = mm[0][i] = Integer.parseInt(st.nextToken());
		for (int d = 1; d < l; d++)
			for (int i = 0; i < n; i++) {
				int j = ff[d - 1][i];
				ff[d][i] = ff[d - 1][j];
				ss[d][i] = ss[d - 1][i] + ss[d - 1][j];
				mm[d][i] = Math.min(mm[d - 1][i], mm[d - 1][j]);
			}
		PrintWriter pw = new PrintWriter(System.out);
		for (int i = 0; i < n; i++) {
			long s = 0;
			int m = (int) 1e8;
			int j = i;
			for (int d = 0; 1L << d <= k; d++)
				if ((k & 1L << d) > 0) {
					s += ss[d][j];
					m = Math.min(m, mm[d][j]);
					j = ff[d][j];
				}
			pw.println(s + " " + m);
		}
		pw.close();
	}
}
