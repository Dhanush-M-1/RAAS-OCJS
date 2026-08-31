import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class T290D {

	public void solve(String s, int n) {
		s = s.toLowerCase();
		
		StringBuffer ans = new StringBuffer("");
		int m = s.length();
		for (int i = 0; i < m; i ++) {
			char c = s.charAt(i);
			
			if (s.codePointAt(i) < n + 97) {
				ans.append(String.valueOf(c).toUpperCase());
			} else {
				ans.append(c);
			}
		}
		
		System.out.println(ans);
	}
	public static void main(String[] args) {
		FastScanner in = new FastScanner();
		new T290D().solve(in.nextToken(), in.nextInt());
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
