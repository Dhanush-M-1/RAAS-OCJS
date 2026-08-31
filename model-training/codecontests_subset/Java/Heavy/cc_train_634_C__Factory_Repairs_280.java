import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) {
		InputStream intputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(intputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(in, out);
		out.close();
	}

	static class TaskC {	
		public void solve(InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int k = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			int q = in.nextInt();
			int[] l = new int[n + 1];
			int[] r = new int[n + 1];
			int[] lbit = new int[n + 1];
			int[] rbit = new int[n + 1];
			for (int ca = 1; ca <= q; ++ca) {
				int type = in.nextInt();
				if (type == 1) {
					int x = in.nextInt();
					int y = in.nextInt();
					int tmp = l[x];
					l[x] = Math.min(l[x] + y, b);
					tmp = l[x] - tmp;
					for (int i = x; i <= n; i += i & -i) {
						lbit[i] += tmp;
					}
					tmp = r[x];
					r[x] = Math.min(r[x] + y, a);
					tmp = r[x] - tmp;
					for (int i = x; i >= 1; i -= i & -i) {
						rbit[i] += tmp;
					}
				} else {
					int p = in.nextInt();
					int ans = 0;
					for (int i = p - 1; i >= 1; i -= i & -i) {
						ans += lbit[i];
					}
					for (int i = p + k; i <= n; i += i & -i) {
						ans += rbit[i];
					}
					out.println(ans);
				}
			}
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
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				return null;
			}
		}
	}
}