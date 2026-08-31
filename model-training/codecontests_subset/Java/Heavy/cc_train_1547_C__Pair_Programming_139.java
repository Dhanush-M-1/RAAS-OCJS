import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class C1547 {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}

	static class TaskA {
		public void solve(int testNumber, InputReader sc, PrintWriter w) {
			int k, n, m, p1, p2;
			boolean isValid = true;

			k = sc.nextInt();
			n = sc.nextInt();
			m = sc.nextInt();

			int a[] = new int[n];
			int b[] = new int[m];
			List<Integer> ans = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}

			for (int i = 0; i < m; i++) {
				b[i] = sc.nextInt();
			}

			p1 = p2 = 0;

			while (p1 < n && p2 < m) {
				if (a[p1] <= k) {
					if (a[p1] == 0) {
						k++;
					}
					ans.add(a[p1]);
					p1++;
				}

				else if (b[p2] <= k) {
					if (b[p2] == 0) {
						k++;
					}
					ans.add(b[p2]);
					p2++;
				}

				else {
					isValid = false;
					break;
				}
			}

			if (!isValid) {
				w.println("-1");
				return;
			}

			while (p1 < n) {
				if (a[p1] <= k) {
					if (a[p1] == 0) {
						k++;
					}
					ans.add(a[p1]);
					p1++;
				}
				
				else {
					isValid = false;
					break;
				}
			}

			while (p2 < m) {
				if (b[p2] <= k) {
					if (b[p2] == 0) {
						k++;
					}
					ans.add(b[p2]);
					p2++;
				}
				
				else {
					isValid = false;
					break;
				}
			}
			
			if (!isValid) {
				w.println("-1");
				return;
			}
			for (Integer num : ans) {
				w.print(num + " ");
			}
			w.println();

		}

	}

	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private InputReader.SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();

			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}

				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = read();

			while (isSpaceChar(c))
				c = read();

			int sgn = 1;

			if (c == '-') {
				sgn = -1;
				c = read();
			}

			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));

			return res * sgn;
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;

			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));

			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public String next() {
			return readString();
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);

		}

	}
}