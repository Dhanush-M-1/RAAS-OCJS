import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class A50 {

	static boolean test = false;

	private void solve() throws Throwable, IOException {
		long ax = iread(), ay = iread(), bx = iread(), by = iread(), cx = iread(), cy = iread();

		for (int i = 0; i < 4; i++) {
			long cc = cx * cx + cy * cy;
			long vc1 = (bx - ax) * cx + (by - ay) * cy;
			long vc2 = (bx - ax) * (-cy) + (by - ay) * cx;

			if (cc == 0) {
				if (ax == bx && ay == by) {
					out.write("YES\n");
					return;
				}
			} else if (vc1 % cc == 0 && vc2 % cc == 0) {
				out.write("YES\n");
				return;
			}
			long t = ay;
			ay = ax;
			ax = -t;
		}

		out.write("NO\n");
	}

	public int iread() throws Exception {
		return Integer.parseInt(wread());
	}

	public double dread() throws Exception {
		return Double.parseDouble(wread());
	}

	public long lread() throws Exception {
		return Long.parseLong(wread());
	}

	public String wread() throws IOException {
		StringBuilder b = new StringBuilder();
		int c;
		c = in.read();
		while (c >= 0 && c <= ' ')
			c = in.read();
		if (c < 0)
			return "";
		while (c > ' ') {
			b.append((char) c);
			c = in.read();
		}
		return b.toString();
	}

	public static void main(String[] args) throws Throwable {
		new A50().solve();
		out.close();
	}

	public A50() throws Throwable {
		if (test) {
			in = new BufferedReader(new FileReader(new File(testDataFile)));
		} else {
			new BufferedReader(inp);
		}
	}

	static InputStreamReader inp = new InputStreamReader(System.in);
	static BufferedReader in = new BufferedReader(inp);
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

	static String testDataFile = "testdata.txt";
	BufferedReader reader = null;
}