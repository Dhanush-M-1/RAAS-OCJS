
import java.io.*;
import java.util.*;

public class A {
	InputStream is;

	int __t__ = 1;
	int __f__ = 0;
	int __FILE_DEBUG_FLAG__ = __f__;
	String __DEBUG_FILE_NAME__ = "src/A2";

	FastScanner in;
	PrintWriter out;

	public void solve() {
		int n = in.nextInt(), k = in.nextInt(), s = in.nextInt(), t = in.nextInt();
		
		int[] c = new int[n];
		int[] v = new int[n];
		for (int i = 0; i < n; i++) {
			c[i] = in.nextInt();
			v[i] = in.nextInt();
		}
		int[] pos = new int[k+2];
		for (int i = 1; i <= k; i++) {
			pos[i] = in.nextInt();
		}
		pos[0] = 0;
		pos[k+1] = s;
		Arrays.sort(pos);
		
		double lo = 0, hi = 1e10;
		for (int i = 0; i < 100; i++) {
			double mid = (hi + lo) / 2;
			if (ok(mid, pos, t))
				hi = mid;
			else
				lo = mid;
		}
		
		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (lo <= v[i])
				minCost = Math.min(minCost, c[i]);
		}
		System.out.println(minCost == Integer.MAX_VALUE ? -1 : minCost);
	}

	private boolean ok(double mid, int[] pos, int t) {
		int n = pos.length;
		double fastest = 0;
		for (int i = 0; i < n - 1; i++) {
			if (pos[i+1] - pos[i] > mid) return false;
			
			long d = pos[i+1] - pos[i];
			fastest += Math.max((2 * d - mid), 0) * 2 + Math.min((mid - d), d); 
		}
		return fastest <= t;
	}

	public void run() {
		if (__FILE_DEBUG_FLAG__ == __t__) {
			try {
				is = new FileInputStream(__DEBUG_FILE_NAME__);
			} catch (FileNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			System.out.println("FILE_INPUT!");
		} else {
			is = System.in;
		}
		in = new FastScanner(is);
		out = new PrintWriter(System.out);

		solve();
	}

	public static void main(String[] args) {
		new A().run();
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
			return nextIntArray(n, 0);
		}

		int[] nextIntArray(int n, int margin) {
			int[] array = new int[n + margin];
			for (int i = 0; i < n; i++)
				array[i + margin] = nextInt();

			return array;
		}

		int[][] nextIntMap(int n, int m) {
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextIntArray(m);
			}
			return map;
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		long[] nextLongArray(int n) {
			return nextLongArray(n, 0);
		}

		long[] nextLongArray(int n, int margin) {
			long[] array = new long[n + margin];
			for (int i = 0; i < n; i++)
				array[i + margin] = nextLong();

			return array;
		}

		long[][] nextLongMap(int n, int m) {
			long[][] map = new long[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextLongArray(m);
			}
			return map;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		double[] nextDoubleArray(int n) {
			return nextDoubleArray(n, 0);
		}

		double[] nextDoubleArray(int n, int margin) {
			double[] array = new double[n + margin];
			for (int i = 0; i < n; i++)
				array[i + margin] = nextDouble();

			return array;
		}

		double[][] nextDoubleMap(int n, int m) {
			double[][] map = new double[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextDoubleArray(m);
			}
			return map;
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

