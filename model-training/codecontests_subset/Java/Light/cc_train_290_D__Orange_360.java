import java.io.*;
import java.util.*;

public class D implements Runnable {

	private void solve() throws IOException {
		String s = nextLine(), ans = "";
		int n = nextInt();
		s = s.toLowerCase();
		String x = s.toLowerCase(), y = s.toUpperCase();
		for (int i = 0; i < s.length(); i++) {
			int a = s.charAt(i);
			if (a < n + 97)
				ans += y.charAt(i); else
					ans += x.charAt(i);
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		new D().run();
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;

	public void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(System.out);
			solve();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(261);
		}
	}

	void halt() {
		writer.close();
		System.exit(0);
	}

	void print(Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}

	void println(Object... objects) {
		print(objects);
		writer.println();
	}

	String nextLine() throws IOException {
		return reader.readLine();
	}

	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens())
			tokenizer = new StringTokenizer(nextLine());
		return tokenizer.nextToken();
	}

	int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextToken());
	}
}
