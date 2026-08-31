import java.io.*;

import java.awt.geom.Point2D;
import java.text.*;
import java.math.*;
import java.util.*;

public class Main implements Runnable {

	final String filename = "";

	public void solve() throws Exception {
		long ax = iread(), ay = iread();
		long bx = iread(), by = iread();
		long cx = iread(), cy = iread();
		for (int i = 0; i < 4; i++) {
			long cc = cx * cx + cy * cy;
			long vc1 = (bx - ax) * cx + (by - ay) * cy;
			long vc2 = (bx - ax) * (-cy) + (by - ay) * cx;
			if (cc==0)
			{
				if (ax==bx && ay==by)
				{
					out.write("YES\n");
					return;
				}
			} else
			if (vc1 % cc == 0 && vc2 % cc == 0) {
				out.write("YES\n");
				return;
			}
			long t = ay;
			ay = ax;
			ax = -t;
		}
		out.write("NO\n");
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new BufferedWriter(new OutputStreamWriter(System.out));
			// in = new BufferedReader(new FileReader(filename+".in"));
			// out = new BufferedWriter(new FileWriter(filename+".out"));
			solve();
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public int iread() throws Exception {
		return Integer.parseInt(readword());
	}

	public double dread() throws Exception {
		return Double.parseDouble(readword());
	}

	public long lread() throws Exception {
		return Long.parseLong(readword());
	}

	BufferedReader in;

	BufferedWriter out;

	public String readword() throws IOException {
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

	public static void main(String[] args) {
		try {
			Locale.setDefault(Locale.US);
		} catch (Exception e) {

		}
		// new Thread(new Main()).start();
		new Thread(null, new Main(), "1", 1 << 25).start();
	}
}