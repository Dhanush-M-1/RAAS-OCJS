import java.io.*;
import java.util.*;

public class C {

	void solve() throws IOException {
		String s = next();
		int a = nextInt();
		String res="";
		s = s.toLowerCase();
		for (int i = 0; i<s.length(); i++) {
			if (s.charAt(i)<a+97) {
				res = res+(char)(s.charAt(i)-'a'+'A');
			} else {
				res = res+s.charAt(i);
			}
		}
		out.println(res);
	}

	void run() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		new C().run();
	}

	BufferedReader br;
	PrintWriter out;
	StringTokenizer str;

	String next() throws IOException {
		while (str == null || !str.hasMoreTokens()) {
			str = new StringTokenizer(br.readLine());
		}
		return str.nextToken();
	}

	int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	long nextLong() throws IOException {
		return Long.parseLong(next());
	}

}
