import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
public class A {

	private static void solve() throws IOException {
		int a = nextInt();
		int b = nextInt();
		int c = nextInt();
		int tot = a * c;
		for(int i = 0;; i++) {
			boolean works = true;
			for(int j = 0; j <= c; j++) {
				int data = (i +j) * b;
				int watched = j * a;
				if(watched > data) {
					works = false;
					break;
				}
			}
			if(works) {
				out.println(i);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			solve();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(239);
		}
	}

	static BufferedReader br;
	static StringTokenizer st;
	static PrintWriter out;

	static String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null) {
				return null;
			}
			st = new StringTokenizer(line);
		}
		return st.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
}
