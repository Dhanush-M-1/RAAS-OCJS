import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.StringTokenizer;

public class B {
	
	private int f(int[] a, int x) {
		int res = 1;
		while (a[x] != 0) {
			res++;
			x = a[x];
		}
		return res;
	}
	
	private boolean ff(int[] a, int x, int y) {
		if (x == y) {
			return false;
		}
		while (a[x] != 0) {
			x = a[x];
			if (x == y) {
				return false;
			}
		}
		return true;
	}

	private void solve() throws IOException {
		int n = nextInt();
		int x = nextInt();
		int[] a = new int[n + 1];
		boolean[] f = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = nextInt();
			f[a[i]] = true;
		}
		
		ArrayList<Integer> size = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			if (!f[i] && ff(a, i, x)) {
				size.add(f(a, i));
			}
		}
		
		int[] d = new int[n + 1];
		d[0] = 1;
		for (int s: size) {
			for (int i = n; i >= 0; i--) {
				if (d[i] == 1) {
					d[i + s] = 1;
				}
			}
		}
		
		int k = f(a, x);
		for (int i = 0; i <= n; i++) {
			if (d[i] == 1) {
				println(k + i);
			}
		}
	}

	private String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	private int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(nextToken());
	}

	private double nextDouble() throws NumberFormatException, IOException {
		return Double.parseDouble(nextToken());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	private void print(Object o) {
		writer.print(o);
	}

	private void println(Object o) {
		writer.println(o);
	}

	private void printf(String format, Object... o) {
		writer.printf(format, o);
	}

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		Locale.setDefault(Locale.US);
		new B().run();
		System.err.printf("%.3f\n", 1e-3 * (System.currentTimeMillis() - time));
	}

	BufferedReader reader;
	StringTokenizer tokenizer;
	PrintWriter writer;

	private void run() {
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(System.out);
			solve();
			reader.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(13);
		}
	}
}