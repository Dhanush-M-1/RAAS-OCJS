
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bottles {

	static int n;

	static pair[] bott;
	static int[][][] memo;

	public static int dp(int idx, int c, int w) {
		if (c == 0) {
			if (w <= 0)
				return 0;
			else
				return -(int) 1e9;
		}
		if (idx == n)
			return -(int) 1e9;
		if (memo[idx][c][w] != -1)
			return memo[idx][c][w];
		int take = bott[idx].a + dp(idx + 1, c - 1, w - bott[idx].b);
		int leave = dp(idx + 1, c, w);
		return memo[idx][c][w] = Math.max(take, leave);
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int totA = 0;
		bott = new pair[n];
		for (int i = 0; i < n; i++) {
			bott[i] = new pair(sc.nextInt());
			totA += bott[i].a;
		}
		for (int i = 0; i < n; i++)
			bott[i].b = sc.nextInt();
		Arrays.sort(bott);
		int count = 0;
		int Max = 0;
		while (Max < totA)
			Max += bott[count++].b;
		memo = new int[n][count + 1][10001];
		for (int[][] a : memo)
			for (int[] b : a)
				Arrays.fill(b, -1);
		System.out.println(count+" "+(totA-dp(0, count, totA)));
	}

	static class pair implements Comparable<pair> {
		int a;
		int b;

		public pair(int a) {
			this.a = a;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return b != o.b ? o.b - b : o.a - a;
		}

		public String toString() {
			return a + "&" + b;
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public boolean nextEmpty() throws IOException {
			String s = nextLine();
			st = new StringTokenizer(s);
			return s.isEmpty();
		}
	}
}
