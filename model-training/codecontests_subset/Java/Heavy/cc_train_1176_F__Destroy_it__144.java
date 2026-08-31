import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.OptionalLong;

public class Main {

	InputStream is;
	PrintWriter out;
	String INPUT = "";

	private static final long M = 1000000007;

	void solve() {
		int t = ni();
		long dp[] = new long[10];
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;
		while (t-- > 0) {
			int n = ni();
			int cards[][] = na(n, 2);
			// calculate
			long[][][] best = cal(cards);
			//
			long[] dp2 = dp.clone();
			for (int i = 0; i < 10; i++) {
				if (dp[i] >= 0) {
					for (int c = 1; c <= 3; c++) // cards
						for (int cost = 1; cost <= 3; cost++) { // cost
							if (best[c][cost][0]>=0)
								dp2[(i + c) % 10] = Math.max(dp2[(i + c) % 10],
										dp[i] + best[c][cost][((i + c) % 10 < i) ? 1 : 0]);
						}
				}
			}
//			tr(best);
			dp = dp2;
		}
		OptionalLong ans = Arrays.stream(dp).max();
		out.println(ans.isPresent() ? ans.getAsLong() : 0);
	}

	private long[][][] cal(int[][] cards) {
		// 1-3 cards, 1-3 cost, with/with 10
		long[][][] dp = new long[4][4][2];
		for (int i = 3; i >= 0; i--)
			for (int c = 3; c >= 0; c--)
				dp[i][c][0] = dp[i][c][1] = Integer.MIN_VALUE;
		dp[0][0][0] = dp[0][0][1] = 0;

		for (int a[] : cards) {
			for (int i = 3; i >= 1; i--) {
				for (int c = 3; c >= a[0]; c--) {
					dp[i][c][0] = Math.max(dp[i][c][0], dp[i - 1][c - a[0]][0] + a[1]);
					dp[i][c][1] = Math.max(dp[i][c][1], Math.max(dp[i - 1][c - a[0]][0] + 2 * a[1], dp[i - 1][c - a[0]][1] +  a[1]));
				}
			}
		}

		return dp;
	}

	void run() throws Exception {
		is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);

		long s = System.currentTimeMillis();
		solve();
		out.flush();
		if (!INPUT.isEmpty())
			tr(System.currentTimeMillis() - s + "ms");
	}

	public static void main(String[] args) throws Exception {
		new Main().run();
	}

	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;

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

	private double nd() {
		return Double.parseDouble(ns());
	}

	private char nc() {
		return (char) skip();
	}

	private String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != '
									// ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	private char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n) {
			if (!(isSpaceChar(b)))
				buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	private char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}

	private int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}

	private int[][] na(int n, int m) {
		int[][] a = new int[n][];
		for (int i = 0; i < n; i++)
			a[i] = na(m);
		return a;
	}

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

	private static void tr(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
}