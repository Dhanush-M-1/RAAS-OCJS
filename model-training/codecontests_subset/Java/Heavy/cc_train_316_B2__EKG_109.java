import java.io.*;
import java.util.*;

public class Main implements Runnable {

	public void _main() throws IOException {
		int n = nextInt();
		int we = nextInt() - 1;
		int[] a = new int[n];
		int[] inDeg = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt() - 1;
			if (a[i] >= 0) {
				++inDeg[a[i]];
			}
		}
		int m = 0;
		for (int i = 0; i < n; i++) {
			if (inDeg[i] == 0) {
				++m;
			}
		}		
		int[] chains = new int[m - 1];
		int add = 1;
		m = 0;
		for (int i = 0; i < n; i++) {
			if (inDeg[i] != 0) continue;
			int chainLength = 0;
			int ourPos = -1;
			for (int j = i; j >= 0; j = a[j]) {
				if (j == we) {
					ourPos = chainLength;
				}
				++chainLength;
			}
			if (ourPos >= 0) {
				add += chainLength - ourPos - 1;				
			} else {
				chains[m] = chainLength;
				++m;
			}
		}
		boolean[] can = new boolean[n + 1];
		can[0] = true;
		for (int len : chains) {
			boolean[] ncan = new boolean[n + 1];
			for (int i = 0; i <= n; i++) {
				if (can[i]) {
					ncan[i] = true;
					if (i + len <= n) {
						ncan[i + len] = true;
					}
				}
			}
			can = ncan;
		}
		for (int i = 0; i <= n; i++) {
			if (can[i]) {
				out.println(i + add);
			}
		}
	}


	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer st;

	private String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String rl = in.readLine();
			if (rl == null)
				return null;
			st = new StringTokenizer(rl);
		}
		return st.nextToken();
	}

	private int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	private long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	private double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.UK);
		new Thread(new Main()).start();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			//in = new BufferedReader(new FileReader("a.in"));
			//out = new PrintWriter(new FileWriter("a.out"));

			_main();

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(202);
		}
	}

}
