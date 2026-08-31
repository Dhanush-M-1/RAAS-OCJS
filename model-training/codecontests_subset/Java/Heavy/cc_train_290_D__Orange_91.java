import java.util.*;
import java.math.*;
import java.io.*;

public class Solurion {

	private void solve() throws Exception {
		String s = nextToken();
		int _16 = nextInt();
		String ans = "";
		for (int i = 0; i < s.length(); ++i) {
			char _19 = s.charAt(i);
			if (Character.toLowerCase(_19) < _16 + 97) {
				ans = ans + Character.toUpperCase(_19);
			} else {
				ans = ans + Character.toLowerCase(_19);
			}
		}
		out.println(ans);
		//System.out.println((char) ('a' + (26 - a)));
	}

	public void run() {
		try {
			solve();
		} catch (Exception e) {
			NOO(e);
		} finally {
			out.close();
		}
	}

	PrintWriter out;
	BufferedReader in;
	StringTokenizer St;

	void NOO(Exception e) {
		e.printStackTrace();
		System.exit(42);
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}

	String nextToken() {
		while (!St.hasMoreTokens()) {
			try {
				String line = in.readLine();
				if (line == null)
					return null;
				St = new StringTokenizer(line);
			} catch (Exception e) {
				NOO(e);
			}
		}
		return St.nextToken();
	}

	private Solurion(String name) {
		try {
			in = new BufferedReader(new FileReader("input.txt"));
			St = new StringTokenizer("");
			out = new PrintWriter(new FileWriter("output.txt"));
		} catch (Exception e) {
			NOO(e);
		}
	}

	private Solurion() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			St = new StringTokenizer("");
			out = new PrintWriter(System.out);
		} catch (Exception e) {
			NOO(e);
		}
	}

	public static void main(String[] args) {
		//Locale.setDefault(Locale.US);
		new Solurion().run();
	}
}
