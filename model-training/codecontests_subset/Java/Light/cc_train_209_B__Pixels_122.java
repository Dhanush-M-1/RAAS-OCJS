import java.io.*;
import java.util.*;

public class BB {
	public static void main(String[] args) {
		new BB().run();
	}

	BufferedReader br;
	StringTokenizer st;
	PrintWriter out;
	boolean eof;

	void run() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			solve();
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(-1);
		} finally {
			out.close();
		}
	}

	String nextToken() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				eof = true;
				return "0";
			}
		}
		return st.nextToken();
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}


	void solve() throws IOException {
		long[] v = {nextLong(), nextLong(), nextLong(), };
		Arrays.sort(v);
		out.println(v[0] % 2 == v[1] % 2 ? v[1] : v[2]);		
	}
}
