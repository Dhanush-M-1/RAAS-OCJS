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
		
		int ans = 0;
		int last = -(int)2e9;
		
		for (int i = 0; i < n; i++) {
			if (last < x[i] - h[i]) {
				ans++;
				last = x[i];
			} else if (i == n - 1 || x[i] + h[i] < x[i + 1]) {
				ans++;
				last = x[i] + h[i];
			} else {
				last = x[i];
			}
		}

		out.println(ans);
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

