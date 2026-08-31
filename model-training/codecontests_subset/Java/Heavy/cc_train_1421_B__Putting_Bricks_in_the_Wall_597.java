import java.util.*;
import java.io.*;

public class Problem {
//	static int memo[][];
	static int a, b, c, d, n, m, v, r, e, t, tt;
	static ArrayList[] edgeList;
	final static int Infinity = Integer.MAX_VALUE;
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);
	static int arr[][];

	public static void main(String[] args) throws Exception {
		t = sc.nextInt();
		String s;
		while (t-- > 0) {
			n = sc.nextInt();
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				s = sc.next();
				if (i == 0)
					a = Integer.parseInt("" + s.charAt(1));
				else if (i == 1)
					b = Integer.parseInt("" + s.charAt(0));
				else if (i == n - 2)
					c = Integer.parseInt("" + s.charAt(n - 1));
				else if (i == n - 1)
					d = Integer.parseInt("" + s.charAt(n - 2));
				if (n == 3 && i == n - 2)
					c = Integer.parseInt("" + s.charAt(n - 1));
			}
//			pw.println(String.format("%s %s %s %s", a,b,c,d));
			if (a == b && b == c && c == d) {
				pw.println(2);
				pw.println(1 + " " + 2);
				pw.println(2 + " " + 1);
			} else if (a == b && c == d && a != c) {
				pw.println(0);
			} else if (a == b && c != d) {
				pw.println(1);
				if (a == d)
					pw.println(n + " " + (n - 1));
				else
					pw.println(n - 1 + " " + n);
			} else if (c == d && a != b) {
				pw.println(1);
				if (a == d) {
					pw.println(1+" "+2);
				} else {
					pw.println(2+" "+1);
				}
			} else {
				pw.println(2);
				if (a == c) {
					pw.println(1 + " " + 2);
					pw.println(n + " " + (n - 1));
				} else {
					pw.println(1 + " " + 2);
					pw.println(n - 1 + " " + (n));
				}
			}
		}
		pw.flush();
		pw.close();
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {
			br = new BufferedReader(new InputStreamReader(system));
		}

		public Scanner(String file) throws Exception {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public char nextChar() throws IOException {
			return next().charAt(0);
		}

		public Long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public void waitForInput() throws InterruptedException {
			Thread.sleep(3000);
		}
	}
}