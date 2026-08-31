import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
		int n = in.nextInt();
		int M = 100000;
		int[] numByX = new int[M + 1];
		int[] numByY = new int[M + 1];
		int[] firstByX = new int[M + 1];
		int[] nextByX = new int[n];
		int[] firstByY = new int[M + 1];
		int[] nextByY = new int[n];
		Arrays.fill(firstByX, -1);
		Arrays.fill(firstByY, -1);
		Set<Long> all = new HashSet<Long>();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
			++numByX[x[i]];
			++numByY[y[i]];
			nextByX[i] = firstByX[x[i]];
			firstByX[x[i]] = i;
			nextByY[i] = firstByY[y[i]];
			firstByY[y[i]] = i;
			long key = x[i] * (long)(M + 1) + y[i];
			all.add(key);
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int first;
			int[] next;
			if (numByX[x[i]] < numByY[y[i]]) {
				first = firstByX[x[i]];
				next = nextByX;
			} else {
				first = firstByY[y[i]];
				next = nextByY;
			}
			int x1 = x[i];
			int y1 = y[i];
			for (int j = first; j >= 0; j = next[j]) {
				int x2 = x[j];
				int y2 = y[j];
				if (x1 > x2) continue;
				if (y1 > y2) continue;
				int x3, y3, x4, y4;
				int side = (x2 - x1) + (y2 - y1);
				if (side == 0) continue;
				if (x1 == x2) {
					x3 = x1 + side;
					y3 = y1;
					x4 = x2 + side;
					y4 = y2;
				} else {
					x3 = x1;
					y3 = y1 + side;
					x4 = x2;
					y4 = y2 + side;
				}
				long key3 = x3 * (long)(M + 1) + y3;
				long key4 = x4 * (long)(M + 1) + y4;
				if (all.contains(key3) && all.contains(key4)) {
					++ans;
				}
			}
		}
		out.println(ans);
    }
}

class FastScanner {

	private BufferedReader in;
	private StringTokenizer st;

	public FastScanner(InputStream stream) {
		in = new BufferedReader(new InputStreamReader(stream));
	}

	public String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(in.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return st.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}

}

