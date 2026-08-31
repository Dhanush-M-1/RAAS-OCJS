import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Queue;
import java.util.Stack;

public class A248 {
	InputStream is;
	PrintWriter out;
	/**
	 * Go to Sublime, copy & pase the input Use Ctrl+A, Ctrl+Shift+L, Ctrl+Enter
	 * to create this string
	 */
	String INPUT = "3\n100 200 100";

	void solve() {
		int n = ni();
		int[] arr = na(n);

		int x = 0;
		int y = 0;
		for (int i = 0; i < n; i++) {
			if(arr[i] == 100)
				x++;
			else y++;
		}
		
		if(x % 2 == 1){
			out.println("NO");
			return;
		}
		
		if(x == 0 && y % 2 == 1){
			out.println("NO");
			return;
		}
		
		out.println("YES");
	}

	private static boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	private static void debug(Object... o) {
		if (!oj)
			System.out.println(Arrays.deepToString(o));
	}

	static int[][] packD(int n, int[] from, int[] to) {
		int[][] result = new int[n][];
		int[] goOutCount = new int[n];
		for (int f : from)
			goOutCount[f]++;
		for (int i = 0; i < n; i++)
			result[i] = new int[goOutCount[i]];
		for (int i = 0; i < from.length; i++) {
			--goOutCount[from[i]];
			result[from[i]][goOutCount[from[i]]] = to[i];
		}
		return result;
	}

	void run() throws Exception {
		is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);

		long s = System.currentTimeMillis();
		solve();
		out.flush();
		debug(System.currentTimeMillis() - s + "ms");
	}

	public static void main(String[] args) throws Exception {
		new A248().run();
	}

	private byte[] inbuf = new byte[1024];
	private int lenbuf = 0, ptrbuf = 0;

	private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	private boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	private int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	/**
	 * Next Double.
	 */
	private double nd() {
		return Double.parseDouble(ns());
	}

	/**
	 * Next Char.
	 */
	private char nc() {
		return (char) skip();
	}

	/**
	 * Next String.
	 */
	private String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b !=
									// ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	/**
	 * Next Char array.
	 */
	private char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	/**
	 * Next Matrix.
	 */
	private char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}

	/**
	 * Next Array.
	 */
	private int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}

	/**
	 * Next Integer.
	 */
	private int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	/**
	 * Next Long.
	 */
	private long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
}