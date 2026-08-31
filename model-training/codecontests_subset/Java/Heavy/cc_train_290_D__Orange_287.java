import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class C {

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
		String s = next();
		int c = nextInt();
		for (int i = 0; i < s.length(); i++) {
			String t = s.charAt(i) + "";
			if (Character.isLowerCase(s.charAt(i)) && (s.charAt(i) - 'a' < c))
				out.print(t.toUpperCase());
			else if (Character.isUpperCase(s.charAt(i)) && (s.charAt(i) - 'A' < c))
				out.print(t.toUpperCase());
			else
				out.print(t.toLowerCase());
		}
		out.println();
	}

	void run() {
		try {
			Locale.setDefault(Locale.US);
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(new OutputStreamWriter(System.out));
			solve();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		new C().run();
	}

}
