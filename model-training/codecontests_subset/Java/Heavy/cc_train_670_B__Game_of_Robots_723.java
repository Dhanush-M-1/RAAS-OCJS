import java.io.IOException;
import java.io.BufferedInputStream;

public class SolverF {

	public static void main(String args[]) {
		 MyScanner in = new MyScanner();
		 int size = in.nextInt();
		 int n = in.nextInt();
		 int[] arr = new int[size];
		 for (int i = 0; i < size; i++) {
		     arr[i] = in.nextInt();
		 }
		 System.out.println(robots(n, arr));
		 in.close();
	}

	static int robots(int n, int[] arr) {
		int x = 1;
		while (n > x) {
			n -= x;
			x++;
		}
		return arr[n - 1];
	}

	static class MyScanner {

		private byte[] buffer = new byte[1024];

		private BufferedInputStream stream;

		private int pointer;

		private int len;

		private MyScanner() {
			try {
				stream = new BufferedInputStream(System.in);
				pointer = 0;
				len = stream.read(buffer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private int next() {
			byte value = -1;
			try {
				if (pointer >= len) {
					len = stream.read(buffer);
					pointer = 0;
				}
				if (len <= 0) {
					return -1;
				}
				value = buffer[pointer++];
				return value;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return value;
		}

		private int nextInt() {
			int value = 0;
			int next = next();
			while (isSpaceChar(next)) {
				next = next();
			}
			int sign = 1;
			if (next == '-') {
				sign = -1;
				next = next();
			}
			while (!isSpaceChar(next)) {
				value *= 10;
				value += next - '0';
				next = next();
			}
			return value * sign;
		}

		private String nextString() {
			StringBuilder text = new StringBuilder();
			int next;
			while (!isSpaceChar(next = next())) {
				text.append((char) next);
			}
			return text.toString();
		}

		private long nextLong() {
			long value = 0;
			int next = next();
			while (isSpaceChar(next)) {
				next = next();
			}
			long sign = 1;
			if (next == '-') {
				sign = -1;
				next = next();
			}
			while (!isSpaceChar(next)) {
				value *= 10;
				value += next - '0';
				next = next();
			}
			return value * sign;
		}

		private int[] nextIntArray(int size) {
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = nextInt();
			}
			return arr;
		}

		private boolean isSpaceChar(int c) {
			return c == '\n' || c == ' ' || c == '\r' || c == '\t' || c == -1;
		}

		private void close() {
			try {
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}