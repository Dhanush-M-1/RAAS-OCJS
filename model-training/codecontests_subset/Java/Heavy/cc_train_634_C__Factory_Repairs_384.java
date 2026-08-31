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
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskC {
		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int n = in.nextInt();
			int k = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			int q = in.nextInt();
			int[] ta = new int[n];
			int[] tb = new int[n];
			for (int i = 0; i < q; i++) {
				int t = in.nextInt();
				if (t == 1) {
					int di = in.nextInt() - 1;
					int ai = in.nextInt();
					int va = Math.min(a - sum(ta, di, di), ai);
					add(ta, di, va);
					int vb = Math.min(b - sum(tb, di, di), ai);
					add(tb, di, vb);
				} else {
					int pi = in.nextInt() - 1;
					int res = sum(tb, 0, pi - 1) + sum(ta, pi + k, n - 1);
					out.println(res);
				}
			}
		}

		static void add(int[] t, int i, int value) {
			for (; i < t.length; i |= i + 1)
				t[i] += value;
		}

		static int sum(int[] t, int i) {
			int res = 0;
			for (; i >= 0; i = (i & (i + 1)) - 1)
				res += t[i];
			return res;
		}

		static int sum(int[] t, int a, int b) {
			return sum(t, b) - sum(t, a - 1);
		}

	}

	static class InputReader {
		final InputStream is;
		final byte[] buf = new byte[1024];
		int pos;
		int size;

		public InputReader(InputStream is) {
			this.is = is;
		}

		public int nextInt() {
			int c = read();
			while (isWhitespace(c))
				c = read();
			int sign = 1;
			if (c == '-') {
				sign = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = res * 10 + c - '0';
				c = read();
			} while (!isWhitespace(c));
			return res * sign;
		}

		int read() {
			if (size == -1)
				throw new InputMismatchException();
			if (pos >= size) {
				pos = 0;
				try {
					size = is.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (size <= 0)
					return -1;
			}
			return buf[pos++] & 255;
		}

		static boolean isWhitespace(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

	}
}

