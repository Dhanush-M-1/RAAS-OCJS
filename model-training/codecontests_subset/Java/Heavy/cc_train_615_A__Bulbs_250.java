import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Bulbs {
	static void solve() {
		int n = nextInt();
		int m = nextInt();
		boolean[] a = new boolean[m];
		for(int i = 0; i < n; i++){
			int c = nextInt();
			for(int j = 0; j < c; j++)
				a[nextInt() - 1] = true;	
		}
		
		boolean can = true;
		for(boolean b : a)
			can &= b;
		if(can)
			writer.println("YES");
		else writer.println("NO");
		
	}

	public static void main(String[] args) {
		solve();
		writer.close();
	}

	static BufferedReader bf = new BufferedReader(new InputStreamReader(
			System.in));
	static StringTokenizer tokenizer = new StringTokenizer("");

	static PrintWriter writer = new PrintWriter(System.out);

	static String next() {
		while (!tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(bf.readLine());
			} catch (Exception e) {
				return null;
			}
		}

		return tokenizer.nextToken();
	}

	static int nextInt() {
		return Integer.parseInt(next());
	}
	
	static long nextLong() {
		return Long.parseLong(next());
	}
	
	static double nextDouble() {
		return Double.parseDouble(next());
	}

	static int[] nextIntArr(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		return a;
	}
}
