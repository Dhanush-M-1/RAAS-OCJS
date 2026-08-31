
import java.io.*;
import java.util.*;

public class Main {
	FastScanner in = new FastScanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	
	String a(String s) {
		return new StringBuilder(s).reverse().toString();
	}
	
	String c(String s) {
		int n = s.length();
		if (n == 1) return s;
		return s.charAt(n - 1) + s.substring(0, n - 1);
	}

	String e(String s) {
		int n = s.length();
		if (n % 2 == 0) {
			return s.substring(n / 2) + s.substring(0, n / 2); 
		} else {
			return s.substring(n / 2 + 1) + s.charAt(n / 2) + s.substring(0, n / 2);
		}
	}
	
	String j(String s) {
		if (s.length() == 1) return s;
		return s.substring(1) + s.charAt(0);
	}
	
	String m(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
				c -= '0';
				res += ((c + 1) % 10);
			} else {
				res += (char)c;
			}
		}
		return res;
	}
	
	String p(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
				c -= '0';
				res += ((c + 9) % 10);
			} else {
				res += (char)c;
			}
		}
		return res;
	}
	public void run() {
		int n = in.nextInt();
		for (int x = 0; x < n; x++) {
			String order = in.next();
			String s = in.next();
			
			for (int i = order.length() - 1; i >= 0; i--) {
				switch (order.charAt(i)) {
				case 'A':
					s = a(s);
					break;
				case 'J':
					s = c(s);
					break;
				case 'M':
					s = m(s);
					break;
				case 'P':
					s = p(s);
					break;
				case 'E':
					s = e(s);
					break;
				case 'C':
					s = j(s);
					break;
				}
			}
			System.out.println(s);
		}
		out.close();
	}

	public static void main(String[] args) {
		new Main().run();
	}

	public void mapDebug(int[][] a) {
		System.out.println("--------map display---------");

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%3d ", a[i][j]);
			}
			System.out.println();
		}

		System.out.println("----------------------------");
		System.out.println();
	}

	public void debug(Object... obj) {
		System.out.println(Arrays.deepToString(obj));
	}

	class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
			//stream = new FileInputStream(new File("dec.in"));

		}

		int read() {
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

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] nextIntArray(int n) {
			int[] array = new int[n];
			for (int i = 0; i < n; i++)
				array[i] = nextInt();

			return array;
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		long[] nextLongArray(int n) {
			long[] array = new long[n];
			for (int i = 0; i < n; i++)
				array[i] = nextLong();

			return array;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		double[] nextDoubleArray(int n) {
			double[] array = new double[n];
			for (int i = 0; i < n; i++)
				array[i] = nextDouble();

			return array;
		}

		String next() {
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

		String[] nextStringArray(int n) {
			String[] array = new String[n];
			for (int i = 0; i < n; i++)
				array[i] = next();

			return array;
		}

		String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}
}