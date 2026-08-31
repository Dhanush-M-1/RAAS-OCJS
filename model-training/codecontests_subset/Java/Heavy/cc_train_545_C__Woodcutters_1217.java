//################################################################################################################
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;

//################################################################################################################
public class R303D2C {
	public static void main(String[] args) {
		R303D2C c = new R303D2C();
		InputReader1 reader = c.new InputReader1(System.in);
		OutputWriter writer = c.new OutputWriter(System.out);
		// think about the brute-force approach
		// read input
		// code boundary conditions
		int n = reader.readInt();
		long[] x = new long[n];
		long[] h = new long[n];
		for (int i = 0; i < h.length; i++) {
			x[i] = reader.readLong();
			h[i] = reader.readLong();
		}
		char[] ws = new char[n];
		int[] dp = new int[n];
		Arrays.fill(ws, ' ');
		ws[0] = 'l';
		dp[0] = 1;
		if (n >= 3) {
			if (((x[1] - h[1]) <= x[0]) && ((x[1] + h[1]) >= x[2])) {
				ws[1] = ' ';
				dp[1] = dp[0];
			} else if (((x[1] - h[1]) <= x[0])) {
				ws[1] = 'r';
				dp[1] = dp[0] + 1;
			} else {
				ws[1] = 'l';
				dp[1] = dp[0] + 1;
			}
		}
		for (int i = 2; i < n - 1; i++) {
			if (((x[i] - h[i]) <= x[i - 1]) && ((x[i] + h[i]) >= x[i + 1])) {
				ws[i] = ' ';
				dp[i] = dp[i - 1];
				continue;
			} else if (((x[i] - h[i]) <= x[i - 1])) {
				// try to fall it to the right
				dp[i] = dp[i - 1] + 1;
				ws[i] = 'r';
			} else if (((x[i] + h[i]) >= x[i + 1])) {
				// try to fall it to the left
				if (ws[i - 1] == ' ' || ws[i - 1] == 'l') {
					ws[i] = 'l';
					dp[i] = dp[i - 1] + 1;
				} else if (x[i - 1] + h[i - 1] < x[i] - h[i]) {
					ws[i] = 'l';
					dp[i] = dp[i - 1] + 1;
				} else {
					if (dp[i - 2] + 1 > dp[i - 1]) {
						ws[i - 1] = ' ';
						ws[i] = 'l';
						dp[i] = dp[i - 2] + 1;
					} else {
						ws[i] = ' ';
						dp[i] = dp[i - 1];
					}
				}
			} else {
				// we have two options, explore both
				if (ws[i - 1] == ' ' || ws[i - 1] == 'l') {
					ws[i] = 'l';
					dp[i] = dp[i - 1] + 1;
				} else {
					if (x[i - 1] + h[i - 1] < x[i] - h[i]) {
						ws[i] = 'l';
						dp[i] = dp[i - 1] + 1;
					} else {
						if (dp[i - 2] + 1 > dp[i - 1] + 1) {
							ws[i - 1] = ' ';
							ws[i] = 'l';
							dp[i] = dp[i - 2] + 1;
						} else {
							ws[i] = 'r';
							dp[i] = dp[i - 1] + 1;
						}
					}
				}
			}
		}
		if (n >= 2) {
			dp[n - 1] = dp[n - 2] + 1;
		}
		int mx = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > mx) {
				mx = dp[i];
			}
		}
		writer.println(mx);
		reader.close();
		writer.close();
	}

	class InputReader1 {
		// private final boolean finished = false;

		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public InputReader1(InputStream stream) {
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

		public int peek() {
			if (numChars == -1)
				return -1;
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					return -1;
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar];
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

		public String readString() {
			int length = readInt();
			if (length < 0)
				return null;
			byte[] bytes = new byte[length];
			for (int i = 0; i < length; i++)
				bytes[i] = (byte) read();
			try {
				return new String(bytes, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return new String(bytes);
			}
		}

		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private String readLine0() {
			StringBuffer buf = new StringBuffer();
			int c = read();
			while (c != '\n' && c != -1) {
				if (c != '\r')
					buf.appendCodePoint(c);
				c = read();
			}
			return buf.toString();
		}

		public String readLine() {
			String s = readLine0();
			while (s.trim().length() == 0)
				s = readLine0();
			return s;
		}

		public String readLine(boolean ignoreEmptyLines) {
			if (ignoreEmptyLines)
				return readLine();
			else
				return readLine0();
		}

		public BigInteger readBigInteger() {
			try {
				return new BigInteger(readString());
			} catch (NumberFormatException e) {
				throw new InputMismatchException();
			}
		}

		public char readCharacter() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			return (char) c;
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

		public boolean isExhausted() {
			int value;
			while (isSpaceChar(value = peek()) && value != -1)
				read();
			return value == -1;
		}

		public String next() {
			return readString();
		}

		public boolean readBoolean() {
			return readInt() == 1;
		}

		public void close() {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class OutputWriter {
		private final PrintWriter writer;

		public OutputWriter(OutputStream stream) {
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					stream)));
		}

		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}

		public void println(String s) {
			writer.println(s);
		}

		public void println(int x) {
			writer.println(x);
		}

		public void print(int x) {
			writer.print(x);
		}

		public void println(long x) {
			writer.println(x);
		}

		public void printSpace() {
			writer.print(" ");
		}

		public void close() {
			writer.close();
		}
	}
}
