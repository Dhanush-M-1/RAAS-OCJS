import java.io.*;
import java.util.*;

public class First {

	public static void main(String[] args) throws Exception {
		String[] s=new String[2];
		s[0]=s();
		s[1]=s();
		out.println(s[0]+" "+s[1]);
		int n=i();
		for( int i=0 ; i<n ; i++ ){
			String[] t=new String[2];
			t[0]=s();
			t[1]=s();
			if( s[0].equals(t[0]) ) s[0]=t[1];
			else s[1]=t[1];
			out.println(s[0]+" "+s[1]);
		}
		out.close();

	}
	static InputReader in = new InputReader(System.in);
	static OutputWriter out = new OutputWriter(System.out);

	static char[][] cnm( int n, int m ){
		char[][] c=new char[n][m];
		for( int i=0 ; i<n ; i++ ){
			c[i]=s().toCharArray();
		}
		return c;
	}
	
	static int i() {
		return in.readInt();
	}

	static long l() {
		return in.readLong();
	}

	static double d() {
		return in.readDouble();
	}

	static String s() {
		return in.readString();
	}

	static int[] Iarr( int no) {
		int[] array=new int[no];
		for (int i = 0; i < no; i++) {
			array[i] = i();
		}
		return array;
	}
	
	static long[] Larr( int no) {
		long[] array=new long[no];
		for (int i = 0; i < no; i++) {
			array[i] = l();
		}
		return array;
	}
	
	static String[] Sarr( int no) {
		String[] array=new String[no];
		for (int i = 0; i < no; i++) {
			array[i] = s();
		}
		return array;
	}
	
	static double[] Darr( int no) {
		double[] array=new double[no];
		for (int i = 0; i < no; i++) {
			array[i] = d();
		}
		return array;
	}

	private static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

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

		public int readInt() {
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

		public String readString() {
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

		public double readDouble() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, readInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, readInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}

		public long readLong() {
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

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public String next() {
			return readString();
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}

	private static class OutputWriter {
		private final PrintWriter writer;

		public OutputWriter(OutputStream outputStream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}

		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}

		public void print(Object... objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}

		public void println(Object... objects) {
			print(objects);
			writer.println();
		}

		public void close() {
			writer.close();
		}

		public void flush() {
			writer.flush();
		}
	}
}