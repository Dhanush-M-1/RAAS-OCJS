import java.io.IOException;
import java.util.InputMismatchException;

public class Main {
	void run() {
		MyScanner sc = new MyScanner();

		for (int T = sc.nextInt() - 1; 0 <= T; T--) {
			char[] q = new StringBuilder(sc.next()).reverse().toString().toCharArray();
			char[] s = sc.next().toCharArray();

			int n = q.length;
			int m = s.length;
			for (int i = 0; i < n; i++) {
				if (q[i] == 'C') {
					int tmp = s[0];
					for (int j = 0; j < m - 1; j++) {
						s[j] = s[j + 1];
					}
					s[m - 1] = (char)tmp;
				}
				if (q[i] == 'J') {
					int tmp = s[m - 1];
					for (int j = m - 1; 0 < j; j--) {
						s[j] = s[j - 1];
					}
					s[0] = (char)tmp;
				}
				if (q[i] == 'E') {
					int k = m % 2 == 0 ? 0 : 1;
					for (int j = 0; j < m / 2; j++) {
						int tmp = s[j];
						s[j] = s[j + m / 2 + k];
						s[j + m / 2 + k] = (char)tmp;
					}
				}
				if (q[i] == 'A') {
					for (int j = 0; j < m / 2; j++) {
						int tmp = s[j];
						s[j] = s[m - j - 1];
						s[m - j - 1] = (char)tmp;
					}
				}
				if (q[i] == 'M') {
					for (int j = 0; j < m; j++) {
						if ('0' <= s[j] && s[j] <= '8') s[j]++;
						else if (s[j] == '9') s[j] = '0';
					}
				}
				if (q[i] == 'P') {
					for (int j = 0; j < m; j++) {
						if ('1' <= s[j] && s[j] <= '9') s[j]--;
						else if (s[j] == '0') s[j] = '9';
					}
				}
			}
			System.out.println(s);
		}
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
		System.out.println("----------------------------" + '\n');
	}

	class MyScanner {
		int read() {
			try {
				return System.in.read();
			} catch (IOException e) {
				throw new InputMismatchException();
			}
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