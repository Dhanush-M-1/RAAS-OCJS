import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author pandusonu
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskB {
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			// out.print("Case #" + testNumber + ": ");
			int n = in.readInt();
			String s = in.readString();
			int[][] x = new int[26][26];
			for (int i = 1; i < n; i++) {
				x[s.charAt(i - 1) - 'A'][s.charAt(i) - 'A']++;
			}
			String ans = "";
			int max = 0;
			for (int i = 0; i < 26; i++) {
				for (int j = 0; j < 26; j++) {
					if (x[i][j] > max) {
						max = x[i][j];
						ans = (char) (i + 'A') + "" + (char) (j + 'A');
					}
				}
			}
			out.println(ans);
		}

	}

	static class InputReader {
		private final InputStream stream;
		private final byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		private int read() {
			try {
				if (curChar >= numChars) {
					curChar = 0;
					numChars = stream.read(buf);
					if (numChars <= 0)
						return -1;
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return buf[curChar++];
		}

		public int readInt() {
			return (int) readLong();
		}

		public long readLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
				if (c == -1) throw new RuntimeException();
			}
			boolean negative = false;
			if (c == '-') {
				negative = true;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9') throw new InputMismatchException();
				res *= 10;
				res += (c - '0');
				c = read();
			} while (!isSpaceChar(c));
			return negative ? (-res) : (res);
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c)) c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.append((char) c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

	}
}

