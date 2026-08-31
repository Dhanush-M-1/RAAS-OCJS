import java.io.IOException;
import java.util.InputMismatchException;

public class AncientProphesy {
    public static void main(String[] args) {
        FasterScanner sc = new FasterScanner();
        
        String S = sc.nextLine();
        int N = S.length();
        
        int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[][][] freq = new int[100][100][3];
        for (int i = 0; i <= N - 10; i++) {
        	int[] tmp = getProphesy(S, i);
        	int d = tmp[0], m = tmp[1], y = tmp[2];
        	freq[d][m][y]++;
        }
        
        int maxFreq = 0;
        int[] best = null;
        for (int y = 0; y < 3; y++) {
        	for (int m = 1; m <= 12; m++) {
        		for (int d = 1; d <= months[m]; d++) {
        			if (freq[d][m][y] > maxFreq) {
        				maxFreq = freq[d][m][y];
        				best = new int[] { d, m, y };
        			}
        		}
        	}
        }
        System.out.format("%02d-%02d-%04d\n", best[0], best[1], best[2] + 2013);
    }

    public static int[] getProphesy(String S, int idx) {
    	for (int i = 0; i < 10; i++) {
    		char c = S.charAt(i + idx);
    		if (((i == 2 || i == 5) && (c != '-')) || (i != 2 && i != 5 && c == '-')) {
				return new int[] { 0, 0, 0 };
    		}
    	}
    	int d = Integer.parseInt(S.substring(idx, idx + 2));
    	int m = Integer.parseInt(S.substring(idx + 3, idx + 5));
    	int y = Integer.parseInt(S.substring(idx + 6, idx + 10));
    	if (y < 2013 || y > 2015) {
    		return new int[] { 0, 0, 0 };
    	} else {
    		return new int[] { d, m, y - 2013 };
    	}
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
	        return nextIntArray(n, 0);
	    }
	    
	    public int[] nextIntArray(int n, int off) {
	    	int[] arr = new int[n + off];
	    	for (int i = 0; i < n; i++) {
	    		arr[i + off] = nextInt();
	    	}
	    	return arr;
	    }
	    
	    public long[] nextLongArray(int n) {
	    	return nextLongArray(n, 0);
	    }
        
		public long[] nextLongArray(int n, int off) {
		    long[] arr = new long[n + off];
		    for (int i = 0; i < n; i++) {
		        arr[i + off] = nextLong();
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