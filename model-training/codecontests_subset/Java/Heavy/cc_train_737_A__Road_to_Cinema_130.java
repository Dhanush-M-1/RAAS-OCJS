import java.util.*;
import java.io.*;
public class Solution {
	public static final String NL = "\n";
	public static final String SP = " ";
	public void append(StringBuffer sb, int[] arr) {
		for (int val: arr) {
			sb.append(val);
			sb.append(" ");
		}
		sb.append(NL);
	}

	public void append(StringBuffer sb, String... strs) {
		for (String str: strs) {
			sb.append(str);
			sb.append(" ");
		}
		sb.append(NL);
	}

	int time(int k, int s) {
		if (k >= 2 * s) return s;
		return (k - s) + 2 * (2 * s - k);
	}

	int time(int k, int[] g, int S) {
		int t = time(k, g[0]);
		for (int i = 1; i < g.length; i++) {
			t += time(k, g[i] - g[i - 1]);
		}
		t += time(k, S - g[g.length - 1]);
		return t;
	}

	public void run() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();

		String[] split = br.readLine().split(SP);
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		int S = Integer.parseInt(split[2]);
		int T = Integer.parseInt(split[3]);
		
		int[] c = new int[N];
		int[] v = new int[N];		
		for (int i = 0; i < N; i++) {
			split = br.readLine().split(SP);
			c[i] = Integer.parseInt(split[0]);
			v[i] = Integer.parseInt(split[1]);
		}

		int[] g = new int[M];
		split = br.readLine().split(SP);
		for (int i = 0; i < M; i++) {
			g[i] = Integer.parseInt(split[i]);
		}
		Arrays.sort(g);

		int l = g[0];
		for (int i = 1; i < M; i++) {
			l = Math.max(l, g[i] - g[i - 1]);
		}
		l = Math.max(S - g[M - 1], l);
		int r = 2 * l;
		int m;
		while (l + 1 < r) {
			m = l + (r - l) / 2;
			int t = time(m, g, S);
			if (t <= T) {
				// oil too much
				r = m;
			} else if (t > T) {
				l = m;
			}
		}

		int bound = time(l, g, S) <= T ? l : time(r, g, S) <= T ? r : Integer.MAX_VALUE;
		int res = -1;
		for (int i = 0; i < N; i++) {
			if (v[i] >= bound) {
				if (res == -1) {
					res = c[i];
				} else {
					res = Math.min(res, c[i]);
				}
			}
		}

		append(sb, String.valueOf(res));
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void main(String[] args) throws IOException {
		new Solution().run();
	}
}