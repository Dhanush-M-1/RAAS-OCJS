import java.io.*;
import java.math.*;
import java.util.*;

public class A {
	static PrintWriter pw;

	static class FastReader {
		private InputStream mIs;
		private byte[] buf = new byte[1024];
		private int curChar, numChars;

		public FastReader() {
			this(System.in);
		}

		public FastReader(InputStream is) {
			mIs = is;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = mIs.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}

		public String next() {
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

		public long l() {
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

		public int i() {
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

		public double d() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		public void scanIntArr(int[] arr) {
			for (int li = 0; li < arr.length; ++li)
				arr[li] = i();
		}

		public void scanIntIndexArr(int[] arr) {
			for (int li = 0; li < arr.length; ++li) {
				arr[li] = i() - 1;
			}
		}

		public void printIntArr(int[] arr) {
			for (int li = 0; li < arr.length; ++li)
				pw.print(arr[li] + " ");
			pw.println();
		}

		public void printLongArr(long[] arr) {
			for (int li = 0; li < arr.length; ++li)
				pw.print(arr[li] + " ");
			pw.println();
		}

		public void scanLongArr(long[] arr) {
			for (int i = 0; i < arr.length; ++i) {
				arr[i] = l();
			}
		}

		public void shuffle(int[] arr) {
			for (int i = arr.length; i > 0; --i) {
				int r = (int) (Math.random() * i);
				int temp = arr[i - 1];
				arr[i - 1] = arr[r];
				arr[r] = temp;
			}
		}

		public int findMax(int[] arr) {
			return Arrays.stream(arr).max().getAsInt();
		}
	}

	public static void main(String[] args) throws IOException {
		FastReader fr = new FastReader();
		pw = new PrintWriter(System.out);
		int i, j, n, m, temp, t;
		t = fr.i();
		while (t-- > 0) {
			n = fr.i();
			int[] arr = new int[n];
			fr.scanIntArr(arr);
			if (arr[0] + arr[1] <= arr[n - 1])
				pw.println(1 + " " + 2 + " " + n);
			else
				pw.println(-1);
		}
		pw.flush();
		pw.close();
	}
}