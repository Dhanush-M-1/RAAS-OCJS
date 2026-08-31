import java.util.ArrayDeque;
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
		final int n = in.readInt();
		int m = in.readInt();
		int[] w = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			w[i] = in.readInt();
		}
		long ans = 0;
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		while (m-- > 0) {
			ArrayDeque<Integer> lifted = new ArrayDeque<>();
			int book = in.readInt();
			while (!stack.isEmpty()) {
				int b = stack.pop();
				if (b == book) {
					break;
				}
				lifted.push(b);
				ans += w[b];
			}
			while (!lifted.isEmpty()) {
				stack.push(lifted.pop());
			}
			stack.push(book);

		}
		out.println(ans);
	}
}

class InputReader {
    private BufferedReader input;
    private StringTokenizer line = new StringTokenizer("");
	public InputReader(InputStream in) {
        input = new BufferedReader(new InputStreamReader(in));
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

