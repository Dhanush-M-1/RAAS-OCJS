import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {
	class FastScanner {
		private final InputStream in = System.in;
		private final byte[] buffer = new byte[1024];
		private int ptr = 0;
		private int buflen = 0;

		private boolean hasNextByte() {
			if (ptr < buflen) {
				return true;
			} else {
				ptr = 0;
				try {
					buflen = in.read(buffer);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (buflen <= 0) {
					return false;
				}
			}
			return true;
		}

		private int readByte() {
			if (hasNextByte())
				return buffer[ptr++];
			else
				return -1;
		}

		private boolean isPrintableChar(int c) {
			return 33 <= c && c <= 126;
		}

		public boolean hasNext() {
			while (hasNextByte() && !isPrintableChar(buffer[ptr]))
				ptr++;
			return hasNextByte();
		}

		public String next() {
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

		public long nextLong() {
			if (!hasNext())
				throw new NoSuchElementException();
			long n = 0;
			boolean minus = false;
			int b = readByte();
			if (b == '-') {
				minus = true;
				b = readByte();
			}
			if (b < '0' || '9' < b) {
				throw new NumberFormatException();
			}
			while (true) {
				if ('0' <= b && b <= '9') {
					n *= 10;
					n += b - '0';
				} else if (b == -1 || !isPrintableChar(b)) {
					return minus ? -n : n;
				} else {
					throw new NumberFormatException();
				}
				b = readByte();
			}
		}

		public int nextInt() {
			long nl = nextLong();
			if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE)
				throw new NumberFormatException();
			return (int) nl;
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

	}

	public static void main(String[] args) {
		new Main().run();
	}

	void sim(long A, long B, long C, long D) {
		int cnt = 0;
		while (A > 0 && cnt++ < 100) {
			A -= B;
			if (A <= C) {
				A += D;
			}
			tr(A);
		}
	}

	void run() {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int T = sc.nextInt();
		for (int t = 0; t < T; ++t) {
			long A = sc.nextLong();
			long B = sc.nextLong();
			long C = sc.nextLong();
			long D = sc.nextLong();
			// sim(A,B,C,D);
			if (A < B) {
				pw.println("No");
				continue;
			}
			if (A % B > C) {
				pw.println("No");
				continue;
			}
			if (D >= B && B - 1 <= C) {
				pw.println("Yes");
				continue;
			}
			long g = gcd(D, B);
			A %= g;
			if (B - D - A > 0) {
				pw.println("No");
				continue;
			}
			if ((B - 1 - A % g) / g * g > C) {
				pw.println("No");
				continue;
			}
			pw.println("Yes");
		}
		pw.close();
	}

	long gcd(long a, long b) {
		if (a > b)
			return gcd(b, a);
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	void tr(Object... objects) {
		System.out.println(Arrays.deepToString(objects));
	}
}