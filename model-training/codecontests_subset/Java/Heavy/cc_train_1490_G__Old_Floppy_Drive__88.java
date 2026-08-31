import java.util.*;
import java.io.*;

public class Momo {

	public static void main(String[] args) throws Exception {
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt(), m = sc.nextInt();
			int[] arr = new int[n];
			long[] prf = new long[n + 1];
			long[] maxprf = new long[n + 1];
			long max = 0;
			for (int i = 1; i < prf.length; i++) {
				arr[i - 1] = sc.nextInt();
				prf[i] = prf[i - 1] + arr[i - 1];
				max = Math.max(max, prf[i]);
				maxprf[i] = max;
			}
			long all = prf[n];
//			pw.println(Arrays.toString(maxprf));
			while (m-- > 0) {
				int x = sc.nextInt();
				if (max == 0) {
					pw.print("-1 ");
				} else if (all <= 0 || max >= x) {
					pw.print(bs(x, maxprf) - 1 + " ");
				} else {
					long ans = (long) Math.ceil(1.0 * (x - max) / all) * n;
					long rem = x - ans / n * all;
//					pw.print("*"+rem+"*");
					pw.print(ans - 1 + bs(rem, maxprf) + " ");
				}
			}
			pw.println();
		}
		pw.close();
	}

	static int bs(long x, long[] arr) {
		int start = 0, end = arr.length - 1, ans = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] >= x) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

	public static class pair implements Comparable<pair> {
		int x;
		int y;

		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return x + " " + y;
		}

		public boolean equals(Object o) {
			if (o instanceof pair) {
				pair p = (pair) o;
				return p.x == x && p.y == y;
			}
			return false;
		}

		public int hashCode() {
			return new Double(x).hashCode() * 31 + new Double(y).hashCode();
		}

		public int compareTo(pair other) {
			if (this.x == other.x) {
				return Long.compare(this.y, other.y);
			}
			return Long.compare(this.x, other.x);
		}
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader r) {
			br = new BufferedReader(r);
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

	}

	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
}
