

import java.io.BufferedInputStream;
import java.util.*;
import static java.lang.Math.*;

public class C268A {

	public void solve() throws Exception {
		int n = nextInt();
		int[] home = new int[105];
		int[] guest = new int[105];
		for (int i = 0; i < n; i++) {
			home[nextInt()]++;
			guest[nextInt()]++;
		}
		int res = 0;
		for (int i = 0; i < guest.length; i++) {
			res += home[i] * guest[i];
		}
		println(res);
	}

	// ------------------------------------------------------

	void debug(Object... os) {
		System.err.println(Arrays.deepToString(os));
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

	int nextInt() throws Exception {
		return Integer.parseInt(nextWord());
	}

	long nextLong() throws Exception {
		return Long.parseLong(nextWord());
	}
	
	public static void main(String[] args) throws Exception {
		new C268A().solve();
	}
}
