import java.io.*;
import java.math.BigInteger;
import java.util.*;




public class Main {
	
	static InputReader in = new InputReader(System.in);
	static PrintWriter out = new PrintWriter(System.out);
	
	
	public static void main(String[] args) {

		long xa = in.nextLong();
		long ya = in.nextLong();
		long xb = in.nextLong();
		long yb = in.nextLong();
		long xc = in.nextLong();
		long yc = in.nextLong();
		
		long ab = dist(xa, ya, xb, yb);
		long bc = dist(xb, yb, xc, yc);
		
		if(ab != bc) {
			System.out.println("no");
			return;
		}
		
		if( xb - xa == xc - xb && yb - ya == yc - yb ) 
			System.out.println("no");
		else
			System.out.println("yes");
		
		
		out.close();
	}
	
	static long dist(long xa, long ya, long xb, long yb) {
		long ret = 0;
		ret += (xa - xb) * (xa - xb);
		ret += (ya - yb) * (ya - yb);
		return ret;
	}
	
	
	
	static double slope(long xa, long ya, long xb, long yb) {
		return (double)(yb - ya) / (xb - xa); 
	}
	
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	
	static class MyTreeMap extends TreeMap<Long, Integer> {
		void add(long n) {
			int x = getOrDefault(n, 0);
			put(n, x + 1);
		}
		void del(long n) {
			int x = get(n);
			if(x > 1) {
				put(n, x - 1);
			}
			else {
				remove(n);
			}
		}
	}
}


class InputReader {

	private final InputStream stream;
	private final byte[] buf = new byte[8192];
	private int curChar, snumChars;

	public InputReader(InputStream st) {
		this.stream = st;
	}

	public int read() {
		if (snumChars == -1)
			throw new InputMismatchException();
		if (curChar >= snumChars) {
			curChar = 0;
			try {
				snumChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (snumChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int nextInt() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public long nextLong() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public int[] nextIntArray(int n) {
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		return a;
	}

	public String readString() {
		int c = read();
		while (isSpaceChar(c)) {
			c = read();
		}
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
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

	public boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	private boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}

}