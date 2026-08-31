import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
public class Main {
	private static final PrintStream ps = System.out;
	private static final InputStream IS = System.in;
	private static final byte[] BUFFER = new byte[1024];
	private static int ptr = 0;
	private static int buflen = 0;

	public static void main(String[] args) {
		int n = ni();
		int[] a = new int[n+2];
		
		for (int i = 1; i <= n; i++) {
			a[i] = ni();
		}
		
		int change = 0;
		int i = 1;
		while (i <= n) {
			if (a[i] == i) {
				change++;
				a[i] = 0;
				if (a[i+1] == i+1) {
					a[i+1] = 0;
				}
			}
			i++;
		}
		ps.println(change);
	}

	private static boolean hasNextByte() {
		if (ptr < buflen)
			return true;
		else {
			ptr = 0;
			try {
				buflen = IS.read(BUFFER);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (buflen <= 0)
				return false;
		}
		return true;
	}

	private static int readByte() {
		if (hasNextByte())
			return BUFFER[ptr++];
		else
			return -1;
	}

	private static boolean isPrintableChar(int c) {
		return 33 <= c && c <= 126;
	}

	public static boolean hasNext() {
		while (hasNextByte() && !isPrintableChar(BUFFER[ptr]))
			ptr++;
		return hasNextByte();
	}

	public static String n() {
		if (!hasNext())
			throw new NoSuchElementException();
		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while (isPrintableChar(b)) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	public static long nl() {
		if (!hasNext())
			throw new NoSuchElementException();
		long n = 0;
		boolean minus = false;
		int b = readByte();
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		if (b < '0' || '9' < b)
			throw new NumberFormatException();
		while (true) {
			if ('0' <= b && b <= '9') {
				n *= 10;
				n += b - '0';
			} else if (b == -1 || !isPrintableChar(b))
				return minus ? -n : n;
			else
				throw new NumberFormatException();
			b = readByte();
		}
	}

	public static int ni() {
		long nl = nl();
		if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE)
			throw new NumberFormatException();
		return (int) nl;
	}

	public static double nextDouble() {
		return Double.parseDouble(n());
	}

	private static int[] nia(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}
}
