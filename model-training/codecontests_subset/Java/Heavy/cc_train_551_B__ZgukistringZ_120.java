
import java.util.*;
import java.lang.*;
import java.io.*;

public class Temp {
	static int imax = Integer.MAX_VALUE, imin = Integer.MIN_VALUE;
	static long lmax = Long.MAX_VALUE, lmin = Long.MIN_VALUE;
	static long mod = (long) 1e9 + 7;

	public static void main(String[] args) throws java.lang.Exception {
		InputReader in = new InputReader(System.in);
			PrintWriter out = new PrintWriter(System.out);
		// int test=in.ni();
		int test = 1;
		int i = 0, j = 0;
		while (test-- > 0) {
			// int n = in.ni();
//			File file=new File("C:\\Users\\EagleEye\\Desktop\\input.txt");
//			File file1=new File("C:\\Users\\EagleEye\\Desktop\\output.txt");
//			Scanner scan=new Scanner(file);
//			char astr[] = scan.next().toCharArray();
//			char bstr[] = scan.next().toCharArray();
//			char cstr[] = scan.next().toCharArray();
			char astr[] = in.ncs();
			char bstr[] = in.ncs();
			char cstr[] = in.ncs();
			int afrq[] = new int[26];
			int bfrq[] = new int[26];
			int cfrq[] = new int[26];

			for (i = 0; i < astr.length; i++) {
				afrq[astr[i] - 'a']++;
			}
			for (i = 0; i < bstr.length; i++) {
				bfrq[bstr[i] - 'a']++;
			}
			for (i = 0; i < cstr.length; i++) {
				cfrq[cstr[i] - 'a']++;
			}
			int ans = 0;
			int k = 1;
			int bcnt = 0, ccnt = 0;
			loop: while (true) {
				int tmp[] = afrq.clone();
				for (i = 0; i < 26; i++) {
					tmp[i] -= bfrq[i] * k;
					if (tmp[i] < 0)
						break loop;
				}
				int min = imax;
				for (i = 0; i < 26; i++) {
					if (cfrq[i] == 0)
						continue;
					tmp[i] /= cfrq[i];
					min = Math.min(tmp[i], min);
				}
				if (min + k > ans) {
					ans = min + k;
					bcnt = k;
					ccnt = min;
				}
				k++;
			}
			k = 1;
			loop: while (true) {
				int tmp[] = afrq.clone();
				for (i = 0; i < 26; i++) {
					tmp[i] -= cfrq[i] * k;
					if (tmp[i] < 0)
						break loop;
				}
				int min = imax;
				for (i = 0; i < 26; i++) {
					if (bfrq[i] == 0)
						continue;
					tmp[i] /= bfrq[i];
					min = Math.min(tmp[i], min);
				}
				if (min + k > ans) {
					ans = min + k;
					ccnt = k;
					bcnt = min;
				}
				k++;
			}
			StringBuilder bdr = new StringBuilder();
			for (i = 0; i < bcnt; i++) {
				bdr.append(bstr);
			}
			for (i = 0; i < ccnt; i++) {
				bdr.append(cstr);
			}
			for (i = 0; i < 26; i++) {
				afrq[i] -= (bfrq[i] * bcnt) + (cfrq[i] * ccnt);
			}
			for (i = 0; i < 26; i++) {
				if (afrq[i] <= 0) {
					continue;
				}
				for (j = 0; j < afrq[i]; j++) {
					bdr.append((char) (i + 'a'));
				}
			}
			out.println(bdr.toString());
			out.close();
		}
	}

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return x + " " + y;
		}
	}

	static void print(int arr[], int len) {
		for (int i = 0; i < len; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	static class InputReader {

		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
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

		public int ni() {
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
				res += c & 15;
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nl() {
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
				res += c & 15;
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String ns() {
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

		public char[] ncs() {
			return ns().toCharArray();
		}

		public String nLine() {
			int c = read();
			// while (c != '\n' && c != '\r' && c != '\t' && c != -1)
			// c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (c != '\n' && c != '\r' && c != '\t' && c != -1);
			return res.toString();
		}

		public static boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

	}

}
