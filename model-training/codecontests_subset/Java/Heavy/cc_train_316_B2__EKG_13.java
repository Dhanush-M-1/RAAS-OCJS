import java.io.*;
import java.util.*;
import java.math.*;


public class Main {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;
	
	final static double EPS = 1e-7;
	final static int MOD = 1000000007;
	
	static void solve() throws Exception {
		int n = nextInt();
		int x = nextInt();
		int[] p = new int[n+1];
		int[] a = new int[n+1];
		for (int i = 1; i <= n; i++) {
			p[i] = nextInt();
			a[p[i]] = i;
		}
		int min = 1;
		for (int j = x; true; j = p[j]) {
			if (p[j] == 0) {
				p[j] = -1;
				break;
			}
			min++;
		}
		boolean[] dp = new boolean[n+1];
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			if (p[i] == 0) {
				int cnt = 1;
				for (int j = i; a[j] != 0; j = a[j]) {
					cnt++;
				}
				for (int j = n; j >= 0; j--) {
					if (dp[j]) {
						dp[j + cnt] = true;
					}
				}
			}
		}
		for (int j = 0; j <= n; j++) {
			if (dp[j]) {
				out.println(j + min);
			}
		}
	}
	
	static int sqr(int x) {
		return x*x;
	}
	
	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static BigInteger nextBigInteger() throws IOException {
		return new BigInteger(next());
	}
	
	static String next() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}
	
	static String nextLine() throws IOException {
		tok = new StringTokenizer("");
		return in.readLine();
	}

	static boolean hasNext() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			String s = in.readLine();
			if (s == null) {
				return false;
			}
			tok = new StringTokenizer(s);
		}
		return true;
	}

	public static void main(String args[]) {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(new OutputStreamWriter(System.out));
			//in = new BufferedReader(new FileReader("input.in"));
			//out = new PrintWriter(new FileWriter("output.out"));
			solve();
			in.close();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			java.lang.System.exit(1);
		}
	}
}