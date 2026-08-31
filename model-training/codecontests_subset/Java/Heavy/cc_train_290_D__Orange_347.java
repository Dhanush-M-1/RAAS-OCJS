import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main implements Runnable {

	private void solve() throws IOException {
		String s = next().toLowerCase();
		int n = nextInt();
		String ans = "";
		for (char c : s.toCharArray()) {
			if (c < n + 97)
				ans += Character.toUpperCase(c);
			else
				ans += Character.toLowerCase(c);
		}
		out.println(ans);
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	String next() throws IOException {
		while (!st.hasMoreTokens()) {
			String line = in.readLine();
			if (line == null)
				return null;
			eat(line);
		}
		return st.nextToken();
	}

	public static void main(String[] args) {
		new Thread(null, new Main(), "Main", 1 << 28).start();
	}

	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer st;

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			eat("");
			solve();
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(566);
		}
	}

	private void eat(String s) {
		st = new StringTokenizer(s);
	}

}