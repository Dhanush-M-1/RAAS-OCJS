import java.io.IOException;

public class CFB {

	private static final int IN_BUFFER_SIZE = 1 << 16;
	private static final int OUT_BUFFER_SIZE = 1 << 16;
	private byte[] input = new byte[IN_BUFFER_SIZE];
	private int ix = IN_BUFFER_SIZE;
	private int bytesRead = ix;
	private byte[] output = new byte[OUT_BUFFER_SIZE];
	private int ox = 0;

	private void readMore() {
		try {
			bytesRead = System.in.read(input, 0, IN_BUFFER_SIZE);
			if (bytesRead <= 0)
				throw new RuntimeException();
			ix = 0;
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	private void flushOut() {
		System.out.write(output, 0, ox);
		ox = 0;
	}

	private void append(char c) {
		if (ox == OUT_BUFFER_SIZE)
			flushOut();
		output[ox++] = (byte) c;
	}

	private int nextInt() {
		skipSpaces();
		int ret = 0;
		if (ix == bytesRead) {
			readMore();
		}
		int sign = 1;
		if (input[ix] == '-') {
			sign = -1;
			ix++;
		}
		while (true) {
			if (ix == bytesRead) {
				try {
					readMore();
				} catch (RuntimeException e) {
					return ret;
				}
			}
			if (input[ix] < '0') {
				break;
			}
			ret *= 10;
			ret += input[ix++] - '0';
		}
		return sign * ret;
	}

	int cntSize;

	private void skipSpaces() {
		while (true) {
			if (ix == bytesRead) {
				readMore();
			}
			if (input[ix] > ' ')
				break;
			ix++;
		}
	}

	private char[] nn = new char[32];

	private void printInt(int n) {
		if (n == 0) {
			append('0');
		} else {
			if (n < 0) {
				append('-');
				n = -n;
			}
			int kk = 0;
			while (n > 0) {
				nn[kk++] = (char) (n % 10 + '0');
				n /= 10;
			}
			for (int i = kk - 1; i >= 0; i--) {
				append(nn[i]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new CFB().work();
	}

	private void work() {

		int n = nextInt();
		int x = nextInt();
		int[] a = new int[n + 1];
		int[] pos = new int[n + 1];
		int[] start = new int[n];
		int sn = 0;
		sz = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			int next = nextInt();
			if (next == 0) {
				start[sn++] = i;
			} else {
				pos[next] = i;
			}
			a[i] = next;
		}

		int sbSz = 0;
		int sbPos = 0;
		for (int i = 0; i < sn; i++) {
			int s = start[i];
			int cnt = 1;
			int k = 0;
			if (s == x)
				k = 1;
			while (pos[s] != 0) {
				s = pos[s];
				cnt++;
				if (s == x)
					k = cnt;
			}
			sz[cnt]++;
			if (k > 0) {
				sbSz = cnt;
				sbPos = k;
			}
		}

		sz[sbSz]--;

		len = new int[n];
		m = 0;
		for (int i = 0; i <= n; i++) {
			if (sz[i] > 0) {
				len[m++] = i;
			}
		}

		memo = new int[m][n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j <= n - 1; j++) {
				memo[i][j] = -1;
			}
		}

		for (int i = sbPos; i <= n; i++) {
			if (canDo(0, i - sbPos) == 1) {
				printInt(i);
				append('\n');
			}
		}

		if (ox > 0)
			flushOut();
		System.out.close();
	}

	private int m, len[], sz[], memo[][];

	private int canDo(int k, int sum) {
		if (sum == 0)
			return 1;
		if (k == m)
			return sum == 0 ? 1 : 0;
		if (memo[k][sum] >= 0)
			return memo[k][sum];
		int ret = canDo(k + 1, sum);
		if (ret == 0) {
			int ss = sum;
			for (int i = 0; i < sz[len[k]]; i++) {
				ss -= len[k];
				if (ss < 0)
					break;
				int t = canDo(k + 1, ss);
				if (t == 1) {
					ret = 1;
					break;
				}
			}
		}
		return memo[k][sum] = ret;
	}
}
