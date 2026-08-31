import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C implements Runnable {

	private void Solution() throws IOException {
		long q = nextLong();
		if (q == 1) {
			println("1");
			print("0");
			return;
		}
		ArrayList<Long> div = new ArrayList<Long>();
		long p = 2;
		while (p <= q / p) {
			while (q % p == 0) {
				div.add(p);
				q /= p;
			}
			p++;
		}
		if (q != 1) {
			div.add(q);
		}
		if (div.size() == 1) {
			println("1");
			print("0");
		} else if (div.size() == 2) {
			print("2");
		} else {
			println("1");
			print(div.get(0) * div.get(1));
		}
	}

	public static void main(String[] args) {
		new C().run();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tokenizer;

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			Solution();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	void print(Object... o) {
		for (int i = 0; i < o.length; i++) {
			if (i != 0)
				out.print(" ");
			out.print(o[i]);
		}
	}

	void println(Object... o) {
		for (int i = 0; i < o.length; i++) {
			if (i != 0)
				out.print(" ");
			out.print(o[i]);
		}
		out.println();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws NumberFormatException, IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(nextToken());
	}

	String nextLine() throws IOException {
		return in.readLine();
	}

	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens())
			tokenizer = new StringTokenizer(nextLine());
		return tokenizer.nextToken();
	}
}
