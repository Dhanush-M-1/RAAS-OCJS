import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class A {
	private static Kattio io = new Kattio(System.in);

	public static void main(String[] args) {
		new A().solve();
	}

	private final void solve() {
		int n = io.getInt();
		int k = 0;

		int[] a = new int[n];
		for(int i = 0; i < n; ++i) {
			a[i] = io.getInt();
			k = Math.max(k, a[i]);
		}

		while(!win(n, a, k)) {
			++k;
		}

		io.println(k);
		io.flush();
		io.close();
	}

	private final boolean win(int n, int[] a, int k) {
		int me = 0, opponent = 0;
		for(int i = 0; i < n; ++i) {
			opponent += a[i];
			me += k - a[i];
		}
		return me > opponent;
	}
}

class Kattio extends PrintWriter {
	public Kattio(InputStream i) {
		super(new BufferedOutputStream(System.out));
		r = new BufferedReader(new InputStreamReader(i));
	}
	public Kattio(InputStream i, OutputStream o) {
		super(new BufferedOutputStream(o));
		r = new BufferedReader(new InputStreamReader(i));
	}

	public boolean hasMoreTokens() {
		return peekToken() != null;
	}

	public int getInt() {
		return Integer.parseInt(nextToken());
	}

	public double getDouble() { 
		return Double.parseDouble(nextToken());
	}

	public long getLong() {
		return Long.parseLong(nextToken());
	}

	public String getWord() {
		return nextToken();
	}

	private BufferedReader r;
	private String line;
	private StringTokenizer st;
	private String token;

	private String peekToken() {
		if (token == null) 
			try {
				while (st == null || !st.hasMoreTokens()) {
					line = r.readLine();
					if (line == null) return null;
					st = new StringTokenizer(line);
				}
				token = st.nextToken();
			} catch (IOException e) { }
		return token;
	}

	private String nextToken() {
		String ans = peekToken();
		token = null;
		return ans;
	}
}