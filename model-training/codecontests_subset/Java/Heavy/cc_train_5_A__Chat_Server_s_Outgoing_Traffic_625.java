import java.io.*;
import java.util.*;

public class A implements Runnable {

	public static void main(String[] args) {
		new Thread(new A()).start();
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	boolean eof = false;

	public void run() {
		Locale.setDefault(Locale.US);
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			solve();
			out.close();
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(239);
		}
	}

	String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return "0";
			}
		}
		return st.nextToken();
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

	private void solve() throws IOException {
		HashSet<String> names = new HashSet<String>();
		long ans = 0;
		while (true) {
			String s = br.readLine();
			if (s == null)
				break;
			if (s.charAt(0) == '+') {
				names.add(s.substring(1));
			} else {
				if (s.charAt(0) == '-') {
					names.remove(s.substring(1));
				} else {
					s = s.substring(s.indexOf(':') + 1);
					ans += s.length() * names.size();
				}
			}
		}
		out.println(ans);
	}
}