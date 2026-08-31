import java.util.*;
import java.io.*;

public class D {
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[360]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			long n = in.nextLong();
			long l = in.nextLong();
			long r = in.nextLong();
			long idx = 2 * (n - 2) + 1;
			if (l - 1 <= idx) {
				int anchor = 0;
				idx = 0;
				long loc = -1;
				if ((l - 1 - idx) % 2 == 0)
					loc = anchor;
				else
					loc = anchor + (l - 1 - idx + 1) / 2;
				while (anchor == 0 && l <= r) {
					if (l - 1 == idx + 2 * (n - 2) + 1) {
						idx += 2 * (n - 2) + 1;
						anchor++;
						loc = n;
						System.out.print(n + ((l == r) ? "\n" : " "));
						l++;
						continue;
					}
					if ((l - 1 - idx) % 2 == 0) {
						loc = anchor;
						System.out.print((loc + 1) + ((l == r) ? "\n" : " "));
						l++;
						continue;
					}
					loc = anchor + (l - 1 - idx + 1) / 2;
					System.out.print((loc + 1) + ((l == r) ? "\n" : " "));
					l++;
				}
				while (l <= r) {
					if (l - 1 == n * (n - 1)) {
						loc = 1;
						System.out.print(1 + ((l == r) ? "\n" : " "));
						l++;
						continue;
					}
					if (l - 1 == idx + 2 * (n - anchor - 1)) {
						idx += 2 * (n - anchor - 1);
						anchor++;
						loc = n;
						System.out.print(n + ((l == r) ? "\n" : " "));
						l++;
						continue;
					}
					if ((l - 1 - idx) % 2 == 1) {
						loc = anchor;
						System.out.print((loc + 1) + ((l == r) ? "\n" : " "));
						l++;
						continue;
					}
					loc = anchor + (l - 1 - idx + 1) / 2;
					System.out.print((loc + 1) + ((l == r) ? "\n" : " "));
					l++;
				}
			} else if (l - 1 != n * (n - 1)) {
				int anchor = 2;
				while (l - 1 > idx) {
					idx += 2 * (n - anchor);
					anchor++;
				}
				anchor--;
				idx -= 2 * (n - anchor);
				long loc = -1;
				if (l - 1 - idx == 0)
					loc = n;
				else if ((l - 1 - idx) % 2 == 1)
					loc = anchor;
				else
					loc = anchor + (l - 1 - idx) / 2;
				while (l <= r) {
					if (l - 1 == n * (n - 1)) {
						loc = 1;
						System.out.print(1 + ((l == r) ? "\n" : " "));
						l++;
						continue;
					}
					if (l - 1 == idx + 2 * (n - anchor)) {
						idx += 2 * (n - anchor);
						anchor++;
						loc = n;
						System.out.print(n + ((l == r) ? "\n" : " "));
						l++;
						continue;
					}
					if ((l - 1 - idx) % 2 == 1) {
						loc = anchor;
						System.out.print(loc + ((l == r) ? "\n" : " "));
						l++;
						continue;
					}
					loc = anchor + (l - 1 - idx) / 2;
					System.out.print(loc + ((l == r) ? "\n" : " "));
					l++;
				}
			} else {
				System.out.println(1);
			}
		}
	}
}