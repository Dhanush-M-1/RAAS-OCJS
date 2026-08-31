import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class T385A {

	public void solve(int n, int c, int[] x) {
		int ans = 0;
		for (int i = 0; i < n - 1; i ++)
			if (x[i] - x[i + 1] - c >= 0)
				ans = Math.max(ans, x[i] - x[i + 1] - c);
		
		System.out.println(ans);
	}
	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		int n = in.nextInt();
		int c = in.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < n; i ++) x[i] = in.nextInt();
		new T385A().solve(n, c, x);
	}
	static class FastScanner {

		BufferedReader br;
		StringTokenizer st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(nextToken());
		}

		long nextLong() {
			return Long.parseLong(nextToken());
		}

		double nextDouble() {
			return Double.parseDouble(nextToken());
		}

	}
}
