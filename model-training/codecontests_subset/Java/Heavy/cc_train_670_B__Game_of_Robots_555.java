

import static java.lang.System.in;

import java.io.IOException;

public class B350 {

	public static byte[] buffer = new byte[8192];
	static int offset = 0;
	static int bufferSize = 0;

	public static void main(String[] args) throws IOException {
		int n = readInt();
		long k = readLong();
		long arr[] = new long[n + 1];
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			arr[i] = readLong();
		}
		for (int i = 1; i <= n; i++) {
			sum += i;
			if (sum >= k) {
				k = k - ((long) i) * (i - 1) / 2L;
				System.out.println(arr[(int)k]);
				break;
			}
		}
	}

	static int readInt() throws IOException {
		int number = 0;
		int s = 1;
		if (offset == bufferSize) {
			offset = 0;
			bufferSize = in.read(buffer);
		}
		for (; buffer[offset] < 0x30 || buffer[offset] == '-'; ++offset) {
			if (buffer[offset] == '-')
				s = -1;
			if (offset == bufferSize - 1) {
				offset = -1;
				bufferSize = in.read(buffer);
			}
		}
		for (; offset < bufferSize && buffer[offset] > 0x2f; ++offset) {
			number = number * 0x0a + buffer[offset] - 0x30;
			if (offset == bufferSize - 1) {
				offset = -1;
				bufferSize = in.read(buffer);
			}
		}
		++offset;
		return number * s;
	}

	static long readLong() throws IOException {
		long number = 0;
		long s = 1;
		if (offset == bufferSize) {
			offset = 0;
			bufferSize = in.read(buffer);
		}
		for (; buffer[offset] < 0x30 || buffer[offset] == '-'; ++offset) {
			if (buffer[offset] == '-')
				s = -1;
			if (offset == bufferSize - 1) {
				offset = -1;
				bufferSize = in.read(buffer);
			}
		}
		for (; offset < bufferSize && buffer[offset] > 0x2f; ++offset) {
			number = number * 0x0a + buffer[offset] - 0x30;
			if (offset == bufferSize - 1) {
				offset = -1;
				bufferSize = in.read(buffer);
			}
		}
		++offset;
		return number * s;
	}
}
