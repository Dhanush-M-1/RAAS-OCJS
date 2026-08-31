
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class D {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskF solver = new TaskF();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskF {

		public void solve(int testNumber, InputReader in, PrintWriter out) {
			long mod = 998244353;
			int n = in.nextInt();
			String s[] = new String[n];
			int sz[] = new int[11];
			for (int i = 0; i < n; i++) {
				String pp = in.next();
				StringBuilder sb = new StringBuilder(pp);
				s[i] = sb.reverse().toString();
				sz[s[i].length()]++;
			}

//			for (int i = 0; i < 11; i++) {
//				out.print(sz[i] + " ");
//			}
//			out.println();
//			out.println("-------");

			long ans[][] = new long[22][11];
			for (int i = 0; i < n; i++) {
				int k = s[i].length();
				for (int j = 0; j < 11; j++) {
					if (sz[j] != 0 && sz[k] != 0) {
						if (j < k) {
							int c = 2 * j;
							for (int q = 0; q < j; q++) {
								ans[q * 2][s[i].charAt(q) - '0'] += sz[j];
								ans[q * 2 + 1][s[i].charAt(q) - '0'] += sz[j];
							}
							for (int q = j; q < k; q++) {
								ans[c + q - j][s[i].charAt(q) - '0'] += (2 * sz[j]);
							}
						} else {
							for (int q = 0; q < k; q++) {
								ans[q * 2][s[i].charAt(q) - '0'] += sz[j];
								ans[q * 2 + 1][s[i].charAt(q) - '0'] += sz[j];
							}
						}
					}
				}
			}

			// for (int i = 0; i < 22; i++) {
			// for (int j = 0; j < 11; j++) {
			// out.print(ans[i][j] + " ");
			// }
			// out.println();
			// }

			long val = 0;
			long c = 0;
			long m = 1;
			for (int i = 0; i < 22; i++) {
				long sum = c;
				for (int j = 0; j < 11; j++) {
					ans[i][j] = ans[i][j] % mod;
					sum = (sum + ((ans[i][j] * j) % mod)) % mod;
				}
				val = (val + ((m * (sum % 10)) % mod)) % mod;
				c = sum / 10;
				m = (m * 10) % mod;
			}
			if (c > 0) {
				val = (val + ((m * c) % mod)) % mod;
			}
			out.println(val);
		}

	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}
}