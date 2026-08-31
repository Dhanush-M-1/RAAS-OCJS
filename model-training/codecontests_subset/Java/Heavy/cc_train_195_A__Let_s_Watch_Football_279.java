
import java.util.*;
import java.lang.*;
import java.io.*;

public class Temp {
	static int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
	static long lmax = Long.MAX_VALUE, lmin = Long.MIN_VALUE;
	static long mod = (long) 1e9 + 7;

	public static void main(String[] args) throws java.lang.Exception {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		// int test=in.ni();
		int test = 1;
		int i = 0, j = 0;
		while (test-- > 0) {
			int b = in.ni();
			int a = in.ni();
			int c = in.ni();
			int l = 0, r = (int) 1e6;
			while (l < r) {
				int mid = (l + r) / 2;
				// System.out.println(mid);
				if (check(mid, c, a, b)) {
					r = mid;
				} else {
					l = mid + 1;
				}
			}
			System.out.println(l);
		}
		out.close();
	}

	static boolean check(int t, int c, int a, int b) {
		int t0 = t + c;
		if (a * t0 < b * (t0 - t)) {
			return false;
		}
		return true;
	}

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return x + " " + y;
		}

	}

	static void print(int arr[], int len) {
		for (int i = 0; i < len; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	static class InputReader {

		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

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

		public int ni() {
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
				res += c & 15;
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nl() {
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
				res += c & 15;
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String ns() {
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

		public char[] ncs() {
			return ns().toCharArray();
		}

		public String nLine() {
			int c = read();
			// while (c != '\n' && c != '\r' && c != '\t' && c != -1)
			// c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (c != '\n' && c != '\r' && c != '\t' && c != -1);
			return res.toString();
		}

		public static boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

	}

}
