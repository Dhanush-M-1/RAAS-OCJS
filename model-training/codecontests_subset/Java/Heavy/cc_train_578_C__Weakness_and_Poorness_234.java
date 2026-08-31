import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;

public class Main {
	private void solve() {
		FastScanner scanner = new FastScanner();
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		double[] b = new double[n];
		double low = -10e5, high = +10e5;
		double prevL = low, prevH = high;

		while (high - low > 1e-20) {
			double x = (high + low) / 2.0;
			for (int i = 0; i < n; i++) {
				b[i] = a[i] - x;
			}
			double minSum = getMinSum(b);
			double maxSum = getMaxSum(b);
			if (minSum > 0 || -minSum < maxSum) {
				low = x;
			} else {
				high = x;
			}

			// TLE回避
			if (high == prevH && low == prevL) {
				break;
			}
			prevH = high;
			prevL = low;
		}
		System.out.println(Math.max(Math.abs(getMinSum(b)), getMaxSum(b)));
	}

	// 最長部分増加列シリーズ
	double getMaxSum(double[] a) {
		double maxS = a[0], curS = 0;
		for (int i = 0; i < a.length; i++) {
			if (curS < 0) {
				curS = 0;
			}
			curS += a[i];
			maxS = Math.max(maxS, curS);
		}
		return maxS;
	}

	double getMinSum(double[] a) {
		double minS = a[0], curS = 0;
		for (int i = 0; i < a.length; i++) {
			if (curS > 0) {
				curS = 0;
			}
			curS += a[i];
			minS = Math.min(minS, curS);
		}
		return minS;
	}

	public static void main(String[] args) {
		new Main().solve();
	}
}

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

	private static boolean isPrintableChar(int c) {
		return 33 <= c && c <= 126;
	}

	private void skipUnprintable() {
		while (hasNextByte() && !isPrintableChar(buffer[ptr]))
			ptr++;
	}

	public boolean hasNext() {
		skipUnprintable();
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

	public int nextInt() {
		return (int) nextLong();
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
}