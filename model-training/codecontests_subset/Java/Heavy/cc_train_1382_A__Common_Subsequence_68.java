import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.TreeMap;

public class A {
	private static Reader reader = new Reader();
	private static PrintWriter writer = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
		int t = reader.readInt();
		while (t-- > 0) {
			TreeMap<Integer, Integer> aMap = new TreeMap<>();
			int n = reader.readInt();
			int m = reader.readInt();
			for (int i = 0; i < n; i++) {
				int x = reader.readInt();
				aMap.put(x, 1);
			}
			int ans = -1;
			for (int i = 0; i < m; i++) {
				int x = reader.readInt();
				if (ans == -1 && aMap.containsKey(x)) {
					ans = x;
				}
			}
		    if (ans == -1) {
		    	writer.println("NO");
		    } else {
		    	writer.println("YES");
		    	writer.println(1 + " " + ans);
		    }
		}
		reader.close();
		writer.close();
	}

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream input;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			this(System.in);
		}

		public Reader(String fileName) throws FileNotFoundException {
			this(new FileInputStream(fileName));
		}

		public Reader(InputStream inputStream) {
			input = new DataInputStream(inputStream);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readString() throws IOException {
			byte c = read();
			while (c <= ' ') {
				c = read();
			}
			StringBuilder string = new StringBuilder();
			do {
				if (Character.isValidCodePoint(c)) {
					string.appendCodePoint(c);
				}
				c = read();
			} while (!isWhitespace(c));
			return string.toString();
		}

		public int readInt() throws IOException {
			int result = 0;
			byte c = read();
			while (c <= ' ') {
				c = read();
			}
			boolean isNegative = (c == '-');
			if (isNegative) {
				c = read();
			}
			do {
				result = result * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (isNegative) {
				return -result;
			}
			return result;
		}

		public int[] readIntArray(int n) throws IOException {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = readInt();
			}
			return a;
		}

		public long readLong() throws IOException {
			long result = 0;
			byte c = read();
			while (c <= ' ') {
				c = read();
			}
			boolean isNegative = (c == '-');
			if (isNegative) {
				c = read();
			}
			do {
				result = result * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (isNegative) {
				return -result;
			}
			return result;
		}

		public long[] readLongArray(int n) throws IOException {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = readLong();
			}
			return a;
		}

		public double readDouble() throws IOException {
			double result = 0, div = 1;
			byte c = read();
			while (c <= ' ') {
				c = read();
			}
			boolean isNegative = (c == '-');
			if (isNegative) {
				c = read();
			}
			do {
				result = result * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					result += (c - '0') / (div *= 10);
				}
			}
			if (isNegative) {
				return -result;
			}
			return result;
		}

		private boolean isWhitespace(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private void fillBuffer() throws IOException {
			bytesRead = input.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead) {
				fillBuffer();
			}
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (input == null) {
				return;
			}
			input.close();
		}

	}
}




