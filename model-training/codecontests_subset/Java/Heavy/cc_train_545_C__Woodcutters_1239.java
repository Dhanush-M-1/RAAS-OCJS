import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Agostinho Junior (junior94)
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskC {

	public void solve(int testNumber, InputReader in, OutputWriter out) {
		int n = in.readInt();
		int[] x = new int[n];
		int[] h = new int[n];

		for (int i = 0; i < n; i++) {
			x[i] = in.readInt();
			h[i] = in.readInt();
		}

		int[][] dp = new int[n][3];
		int[] mul = {-1, 1, 0};

		for (int i = n - 1; i >= 0; i--) {
			for (int now = 0; now < 3; now++) {
				dp[i][now] = -(int)1e6;
				for (int next = 0; next < 3; next++) {
					int a = x[i];
					int b = x[i] + h[i] * mul[now];

					if (a > b) {
						a ^= b;
						b ^= a;
						a ^= b;
					}

					int c = i == n - 1 ? b + 1 : x[i + 1];
					int d = i == n - 1 ? b + 1 : x[i + 1] + h[i + 1] * mul[next];

					if (c > d) {
						c ^= d;
						d ^= c;
						c ^= d;
					}

					if (b < c) {
						if (i > 0 && x[i - 1] >= a) {
							continue;
						}
						if (i == n - 1) {
							dp[i][now] = 1;
						} else {
							dp[i][now] = Math.max(dp[i][now], Math.abs(mul[now]) + dp[i + 1][next]);
						}
					}
				}
			}
		}

		out.println(dp[0][0]);
	}

}

class InputReader {
	private BufferedReader input;
	private StringTokenizer line = new StringTokenizer("");

	public InputReader(InputStream in) {input = new BufferedReader(new InputStreamReader(in));
	}

	public void fill() {
		try {
			if(!line.hasMoreTokens()) line = new StringTokenizer(input.readLine());
		} catch(IOException io) { io.printStackTrace(); System.exit(0);}
	}

	public int readInt() {
		fill();
		return Integer.parseInt(line.nextToken());
	}

}

class OutputWriter {
	private PrintWriter output;

	public OutputWriter(OutputStream out) {
		output = new PrintWriter(out);
	}

	public void println(Object o) {
		output.println(o);
	}

	public void close() {
		output.close();
	}
}

