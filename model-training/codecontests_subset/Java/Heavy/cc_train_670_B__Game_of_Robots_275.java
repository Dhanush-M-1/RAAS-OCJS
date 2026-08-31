import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF363B {

	public static void main(String[] args) {

		MyScanner in = new MyScanner();

		long n = in.nextLong();
		long k = in.nextLong();
		long[] id = new long[(int) n];
		for (long i = 0; i < id.length; i++) {
			id[(int) i] = in.nextInt();
		}
		long N = 0;
		for (long i = 0; i < n; i++) {
			if (i * (i + 1) / 2 >= k) {
				break;
			} else {
				N = i;
			}
		}
		System.out.println(id[(int) (k - N * (N + 1) / 2 - 1)]);
	}

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
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
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
