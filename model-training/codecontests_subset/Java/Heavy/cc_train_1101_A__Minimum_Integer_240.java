import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
public class AEducation58 {

	public static void main(String[] args) {
		FastScanner in = new FastScanner(System.in);
		PrintWriter out=  new PrintWriter(System.out);
		int T = in.nextInt();
		while(T --> 0) {
			int L = in.nextInt();
			int R = in.nextInt();
			int D = in.nextInt();
			int left = L / D;
			int right = R / D;
			int pos1 = D;
			int pos2 = D*(left - 1);
			int pos3 = D*left;
			int pos4 = D*(right+1);
			if(pos1 < L)
				out.println(pos1);
			else if(pos2 > 0)
				out.println(pos2);
			else if(pos3 > 0 && pos3 < L) {
				out.println(pos3);
			}
			else {
				out.println(pos4);
			}
		}
		out.close();
	}
	
	/**
	 * Source: Matt Fontaine
	 */
	static class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int chars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
		}

		int read() {
			if (chars == -1)
				throw new InputMismatchException();
			if (curChar >= chars) {
				curChar = 0;
				try {
					chars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (chars <= 0)
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

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String next() {
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

		public String nextLine() {
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
/*
5
2 4 2
5 10 4
3 10 1
1 2 3
4 6 5
outputCopy
6
4
1
3
10
*/