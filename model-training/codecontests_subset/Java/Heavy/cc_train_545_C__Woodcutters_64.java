import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class E {

	static boolean[] vis;
	static int[] cat;
	static int n;
	static ArrayList<Integer>[] a;
	static pair[] p;

	static int memo[][];

	public static int dp(int idx, int s) {
		if (idx == n)
			return 0;
		if (memo[s][idx] != -1)
			return memo[s][idx];
		int r = -1;
		int l = -1;
		int c = dp(idx + 1, 0);
		if (s == 0) {
			if (idx == 0 || p[idx].x - p[idx].y > p[idx - 1].x)
				l = 1 + dp(idx + 1, 1);
			else if (idx == n - 1 || p[idx].x + p[idx].y < p[idx + 1].x)
				r = 1 + dp(idx + 1, 2);

		} else if (s == 1) {
			if (p[idx].x - p[idx].y > p[idx - 1].x)
				l = 1 + dp(idx + 1, 1);
			else if (idx == n - 1 || p[idx].x + p[idx].y < p[idx + 1].x)
				r = 1 + dp(idx + 1, 2);
		} else {
			if (p[idx].x - p[idx].y > p[idx - 1].x + p[idx - 1].y)
				l = 1 + dp(idx + 1, 1);
			else if (idx == n - 1 || p[idx].x + p[idx].y < p[idx + 1].x)
				r = 1 + dp(idx + 1, 2);
		}
		return memo[s][idx] = Math.max(Math.max(r, l), c);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(br.readLine());
		p = new pair[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		memo = new int[3][n];
		Arrays.fill(memo[0], -1);
		Arrays.fill(memo[1], -1);
		Arrays.fill(memo[2], -1);

		pw.println(dp(0, 0));
		pw.flush();
		pw.close();
	}

	static class pair implements Comparable<pair> {
		int x;
		int y;

		public pair(int d, int u) {
			x = d;
			y = u;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			if (x == o.x)
				return y - o.y;
			return x - o.x;
		}

	}
}
