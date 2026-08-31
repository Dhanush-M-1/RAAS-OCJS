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
		int n = nextInt();
		String s = next();
		out.println(checkOk(s));

	}

	private String checkOk(String s) {
		for (int i = 1; i <= s.length(); i++)
			if (check(s, i))
				return "yes";
		return "no";
	}

	private boolean check(String s, int l) {
		String chk = s;
		for (int i = 0; i <= 50; i++)
			chk = chk + "----------";
		for (int i = 0; i < s.length(); i++)
			if (chk.charAt(i) == '*')
				if (chk.charAt(i + l) == '*')
					if (chk.charAt(i + l + l) == '*')
						if (chk.charAt(i + l + l + l) == '*')
							if (chk.charAt(i + l + l + l + l) == '*')
								return true;
		return false;
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
		new A().run();
	}

}
