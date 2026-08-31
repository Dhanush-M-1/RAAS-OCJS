import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static PrintWriter pw = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			char[][] arr = new char[n][n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.next().toCharArray();
			}

			if (arr[0][1] != arr[1][0]) {
				if (arr[n - 1][n - 2] != arr[n - 2][n - 1]) {
					pw.println(2);
					if (arr[0][1] == arr[n - 1][n - 2]) {
						pw.println(1 + " " + 2);
						pw.println(n - 1 + " " + n);
					} else {
						pw.println(1 + " " + 2);
						pw.println(n + " " + (n - 1));
					}
				} else {
					pw.println(1);
					if (arr[0][1] == arr[n - 1][n - 2]) {
						pw.println(1 + " " + 2);
					} else {
						pw.println(2 + " " + 1);
					}
				}
			} else {
				if (arr[n - 1][n - 2] != arr[n - 2][n - 1]) {
					pw.println(1);
					if (arr[n - 1][n - 2] == arr[0][1]) {
						pw.println(n + " " + (n - 1));
					} else {
						pw.println(n - 1 + " " + (n));
					}
				} else {
					if (arr[n - 1][n - 2] == arr[0][1]) {
						pw.println(2);
						pw.println(n + " " + (n - 1));
						pw.println(n - 1 + " " + (n));
					} else {
						pw.println(0);
					}
				}
			}
		}
		pw.close();
	}

	public static class pair implements Comparable<pair> {
		long x;
		long y;

		public pair(long x, long y) {
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

	public static class tuble implements Comparable<tuble> {
		int x;
		int y;
		int z;

		public tuble(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public String toString() {
			return x + " " + y + " " + z;
		}

		public int compareTo(tuble other) {
			if (this.x == other.x) {
				if (this.y == other.y)
					return this.z - other.z;
				return this.y - other.y;
			} else {
				return this.x - other.x;
			}
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

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
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
}