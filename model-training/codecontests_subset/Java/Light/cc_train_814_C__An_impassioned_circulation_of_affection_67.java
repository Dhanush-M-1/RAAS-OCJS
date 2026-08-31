// practice with kaiboy
import java.io.*;
import java.util.*;

public class CF814C extends PrintWriter {
	CF814C() { super(System.out); }
	static class Scanner {
		Scanner(InputStream in) { this.in = in; } InputStream in;
		int k, l; byte[] bb = new byte[1 << 15];
		byte getc() {
			if (k >= l) {
				k = 0;
				try { l = in.read(bb); } catch (IOException e) { l = 0; }
				if (l <= 0) return -1;
			}
			return bb[k++];
		}
		int nextInt() {
			byte c = 0; while (c <= 32) c = getc();
			int a = 0; while (c > 32) { a = a * 10 + c - '0'; c = getc(); }
			return a;
		}
		int m = 1 << 7; byte[] cc = new byte[m];
		int read() {
			byte c = 0; while (c <= 32) c = getc();
			int n = 0;
			while (c > 32) {
				if (n == m) cc = Arrays.copyOf(cc, m <<= 1);
				cc[n++] = c; c = getc();
			}
			return n;
		}
		byte[] nextBytes() { int n = read(); return Arrays.copyOf(cc, n); }
	}
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF814C o = new CF814C(); o.main(); o.flush();
	}

	void main() {
		int n = sc.nextInt();
		byte[] cc = sc.nextBytes();
		int q = sc.nextInt();
		while (q-- > 0) {
			int m = sc.nextInt();
			byte c = (byte) sc.nextBytes()[0];
			int ans = 0;
			for (int i = 0, j = 0; i < n; i++) {
				if (j < i)
					j = i;
				while (j < n) {
					if (cc[j] != c) {
					 	if (m == 0)
							break;
						m--;
					}
					j++;
				}
				ans = Math.max(ans, j - i);
				if (i < j && cc[i] != c)
					m++;
			}
			println(ans);
		}
	}
}
