import java.util.*;
import java.io.*;
import java.math.*;

public class R468_A {
	FastScanner in;
	PrintWriter out;

	public void solve() {
		int a = in.nextInt();
		int b = in.nextInt();
		
		int m = (a+b)/2;
		int d1 = Math.abs(a-m);
		int d2 = Math.abs(b-m);
		
		out.println((d1+1)*d1/2 + (d2+1)*d2/2);
	}

	public void run() {
		in = new FastScanner();
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		solve();
		out.close();
	}

	class FastScanner {
		StringTokenizer st;
		BufferedReader br;

		FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}

	public static void main(String[] args) {
		new R468_A().run();
	}
}
