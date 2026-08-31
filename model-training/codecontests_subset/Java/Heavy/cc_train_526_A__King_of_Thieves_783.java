import java.io.*;
import java.util.*;
import java.math.*;

public class A implements Runnable {
	private static BufferedReader in;
	private static PrintWriter out;
	private static StringTokenizer st;
	private static Random rnd;

	private void solve() throws IOException {
		int lineLength = nextInt();
		char[] line = nextToken().toCharArray();
		boolean result = false;
		for (int i = 0; i < lineLength; i++) {
			for (int j = 1; j <= lineLength; j++) {
				boolean ok = true;
				for (int k = 0; k <= 4; k++) {
					int pos = i + j * k;
					if (pos < lineLength && line[pos] == '*')
						;
					else
						ok = false;
				}
				if (ok) {
					result = true;
				}
			}
		}
		out.println(result ? "yes" : "no");
	}

	public static void main(String[] args) {
		new A().run();
	}

	public void run() {
		try {
			final String className = this.getClass().getName().toLowerCase();

			try {
				in = new BufferedReader(new FileReader(className + ".in"));
				out = new PrintWriter(new FileWriter(className + ".out"));
				// in = new BufferedReader(new FileReader("input.txt"));
				// out = new PrintWriter(new FileWriter("output.txt"));
			} catch (FileNotFoundException e) {
				in = new BufferedReader(new InputStreamReader(System.in));
				out = new PrintWriter(System.out);
			}

			rnd = new Random();

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(42);
		}
	}

	private String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String line = in.readLine();

			if (line == null)
				return null;

			st = new StringTokenizer(line);
		}

		return st.nextToken();
	}

	private int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	private double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
}