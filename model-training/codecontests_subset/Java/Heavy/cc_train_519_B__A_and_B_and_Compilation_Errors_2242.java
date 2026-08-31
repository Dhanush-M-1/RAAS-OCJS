import java.io.*;
import java.util.*;

public class SolveA {
	BufferedReader br;
	StringTokenizer in;
	PrintWriter out;

	public String nextToken() throws IOException {
		while (in == null || !in.hasMoreTokens()) {
			in = new StringTokenizer(br.readLine());
		}
		return in.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	public static void main(String[] args) throws IOException {
		new SolveA().run();
	}
	int diff(int[] a, int[] b) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			if (a[i] != b[i]) {
				return a[i];
			}
		}
		return a[n - 1];
	}
	public void solve() throws IOException {
		int n = nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		
		int[] b = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			b[i] = nextInt();
		}
		
		int[] c = new int[n - 2];
		for (int i = 0; i < n - 2; i++) {
			c[i] = nextInt();
		}
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		
		out.println(diff(a, b));
		out.println(diff(b, c));
	}

	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in)); // new
																		// InputStreamReader(System.in)
			out = new PrintWriter(System.out); // System.out

			solve();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}