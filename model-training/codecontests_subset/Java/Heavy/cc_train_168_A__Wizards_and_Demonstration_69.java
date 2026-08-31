import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	StringTokenizer str = null;
	BufferedReader in;
	PrintWriter out;

	void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new OutputStreamWriter(System.out));
		solve();
		out.flush();
		out.close();
	}

	String nextString() throws IOException {
		return in.readLine();
	}

	String nextToken() throws IOException {
		if (str == null || !str.hasMoreElements()) {
			str = new StringTokenizer(nextString());
		}
		return str.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	void solve() throws IOException {

		int n = nextInt();
		int x = nextInt();
		int y = nextInt();
		for (int i = 0; i < 1000000000; i++) {
			if (get(n, x, i) >= y) {
				out.println(i);
				return;
			}
		}

	}

	private double get(int n, int x, int i) {
		return ((double) x + (double) i) * 100.0 / (double) n;
	}
}