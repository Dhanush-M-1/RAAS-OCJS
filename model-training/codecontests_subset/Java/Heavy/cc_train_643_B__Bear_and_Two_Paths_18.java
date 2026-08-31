import java.io.IOException;
import java.util.InputMismatchException;

public class BearAndTwoPaths {
    public static void main(String[] args) {
        FasterScanner sc = new FasterScanner();
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        
        if (N <= 4 || K < N + 1) {
        	System.out.println(-1);
        	return;
        }
        
        int[] ord = new int[N];
        ord[0] = A;
        ord[1] = C;
        ord[N - 2] = D;
        ord[N - 1] = B;
        int idx = 1;
        for (int i = 2; i < N - 2; i++) {
        	while (idx == A || idx == B || idx == C || idx == D) {
        		idx++;
        	}
        	ord[i] = idx++;
        }

        StringBuilder sbv = new StringBuilder();
        for (int i = 0; i < N; i++) {
        	sbv.append(ord[i] + " ");
        }
        
        StringBuilder sbu = new StringBuilder();
        sbu.append(String.format("%d %d ", ord[1], ord[0]));
        for (int i = 2; i < N - 2; i++) {
        	sbu.append(ord[i] + " ");
        }
        sbu.append(String.format("%d %d", ord[N - 1], ord[N - 2]));
        
        System.out.println(sbv.toString());
        System.out.println(sbu.toString());
    }

	public static class FasterScanner {
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = System.in.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
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

		public String nextString() {
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

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int nextInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n) {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextInt();
			}
			return arr;
		}

		public int[] nextIntArray(int n, int offset) {
			int[] arr = new int[n + offset];
			for (int i = 0; i < n; i++) {
				arr[i + offset] = nextInt();
			}
			return arr;
		}

		public long[] nextLongArray(int n) {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLong();
			}
			return arr;
		}

		public long[] nextLongArray(int n, int offset) {
			long[] arr = new long[n + offset];
			for (int i = 0; i < n; i++) {
				arr[i + offset] = nextLong();
			}
			return arr;
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
	}
}