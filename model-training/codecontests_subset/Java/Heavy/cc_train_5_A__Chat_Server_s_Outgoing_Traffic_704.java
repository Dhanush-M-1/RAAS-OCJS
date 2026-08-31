import java.io.BufferedInputStream;
import java.util.*;

import static java.lang.Math.*;

public class C005A {

	boolean allowedDebug = true;

	public void solve() throws Exception {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int bytes = 0;
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.charAt(0) == '+') {
				count++;
				continue;
			}
			if (s.charAt(0) == '-') {
				count--;
				continue;
			}
			bytes += s.subSequence(s.indexOf(':') + 1, s.length()).length()
					* count;
		}
		println(bytes);
	}

	// ------------------------------------------------------

	void debug(Object... o) {
		if (allowedDebug) {
			System.err.println(Arrays.deepToString(o));
		}
	}

	void print(Object... os) {
		if (os != null && os.length > 0)
			System.out.print(os[0].toString());
		for (int i = 1; i < os.length; ++i)
			System.out.print(" " + os[i].toString());
	}

	void println(Object... os) {
		print(os);
		System.out.println();
	}

	BufferedInputStream bis = new BufferedInputStream(System.in);

	String nextWord() throws Exception {
		char c = (char) bis.read();
		while (c <= ' ')
			c = (char) bis.read();
		StringBuilder sb = new StringBuilder();
		while (c > ' ') {
			sb.append(c);
			c = (char) bis.read();
		}
		return new String(sb);
	}

	String nextLine() throws Exception {
		char c = (char) bis.read();
		while (c <= ' ')
			c = (char) bis.read();
		StringBuilder sb = new StringBuilder();
		while (c != '\n' && c != '\r') {
			sb.append(c);
			c = (char) bis.read();
		}
		return new String(sb);
	}

	int ni() throws Exception {
		return Integer.parseInt(nextWord());
	}

	long nl() throws Exception {
		return Long.parseLong(nextWord());
	}

	public static void main(String[] args) throws Exception {
		new C005A().solve();
	}
}
