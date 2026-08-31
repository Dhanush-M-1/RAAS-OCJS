import java.io.*;

import java.awt.geom.Point2D;
import java.text.*;
import java.math.*;
import java.util.*;

public class Main implements Runnable {

	final String filename = "";

	public void solve() throws Exception {
		int maxx = iread(), maxy = iread(), w = iread();
		final int max = 100000;
		Pair[] p = new Pair[max];
		for (int i = 0; i < max; i++)
			p[i] = new Pair(i + 1);
		Arrays.sort(p);

		Pair pp = new Pair(1);

		int[] left = new int[max + 1], right = new int[max + 1];
		int cur = max;
		for (int i = 0; i < max;) {
			int j = i;
			while (j < max - 1 && p[j + 1].compareTo(p[i]) == 0)
				j++;

			pp.n = p[i].d;
			pp.d = p[i].n;
			while (cur > 0 && p[cur - 1].compareTo(pp) > 0)
				cur--;
			int r = cur - 1;
			while (cur > 0 && p[cur - 1].compareTo(pp) == 0)
				cur--;
			int l = cur;
			while (i <= j) {
				left[p[i].x] = l;
				right[p[i].x] = r;
				i++;
			}
		}

		int[] yy = new int[max + 1];
		int cur_y = maxy;
		int cur_sum = 0;

		long best = Long.MAX_VALUE;
		long best_x = -1, best_y = -1;
		for (int i = 1; i <= maxx; i++) {
			for (int j = left[i]; j <= right[i]; j++) {
				int y = p[j].x;
				yy[y]++;
				if (y <= cur_y)
					cur_sum++;
			}
			while (cur_sum >= w) {
				cur_sum -= yy[cur_y];
				cur_y--;
			}
			long ss = i * (long) (cur_y + 1);
			if (cur_y < maxy && best > ss) {
				best = ss;
				best_x = i;
				best_y = cur_y + 1;
			}
		}
		if (best == Long.MAX_VALUE) {
			out.write("-1\n");
			return;
		}
		out.write(best_x + " " + best_y);
	}

	class Pair implements Comparable<Pair> {
		int x;
		long n, d;

		public Pair(int x) {
			this.x = x;
			n = x;
			d = rev(x);
		}

		@Override
		public int compareTo(Pair o) {
			long t = n * o.d - d * o.n;
			if (t > 0)
				return 1;
			if (t < 0)
				return -1;
			return 0;
		}

	}

	int rev(int x) {
		int y = 0;
		while (x > 0) {
			y *= 10;
			y += x % 10;
			x /= 10;
		}
		return y;
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
		new Thread(new Main()).start();
		// new Thread(null, new Main(), "1", 1<<25).start();
	}
}