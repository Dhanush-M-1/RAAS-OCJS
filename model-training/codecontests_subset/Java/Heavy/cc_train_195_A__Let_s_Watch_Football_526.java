import java.io.*;
import java.util.*;

public class A {

	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	long nextLong() throws Exception {
		return Long.parseLong(next());
	}

	double nextDouble() throws Exception {
		return Double.parseDouble(next());
	}

	void solve() throws Exception {
		int a = nextInt();
		int b = nextInt();
		int t = nextInt();
		int ans = a * t - b * t + b - 1;
		ans /= b;
		if (ans < 0)
			ans = 0;
		out.println(ans);

	}

	void run() {
		try {
			Locale.setDefault(Locale.US);
			boolean oj = System.getProperty("ONLINE_JUDGE") != null;
			Reader reader = oj ? new InputStreamReader(System.in)
					: new FileReader("input.txt");
			Writer writer = oj ? new OutputStreamWriter(System.out)
					: new FileWriter("output.txt");
			in = new BufferedReader(reader);
			out = new PrintWriter(writer);
			solve();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		new A().run();

	}

}
