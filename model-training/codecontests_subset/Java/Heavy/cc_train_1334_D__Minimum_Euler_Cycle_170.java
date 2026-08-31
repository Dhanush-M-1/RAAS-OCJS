import java.io.*;
import java.util.*;

public class D {
	Reader source;
	BufferedReader br;
	StringTokenizer in;
	PrintWriter out;

	public String nextToken() throws Exception {
		while (in == null || !in.hasMoreTokens()) {
			in = new StringTokenizer(br.readLine());
		}
		return in.nextToken();
	}
	public int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}
	public long nextLong() throws Exception {
		return Long.parseLong(nextToken());
	}
	public double nextDouble() throws Exception {
		return Double.parseDouble(nextToken());
	}
	
	public void solve() throws Exception {
		int t = nextInt();
		for (int i = 0; i < t; i++) {
			int n = nextInt();
			long l = nextLong();
			long r = nextLong();
			int a = 1;
			while (a < n && l > 2 * (n - a)) {
				l = l - 2 * (n - a);
				r = r - 2 * (n - a);
				a++;
			}
			if (a == n) a = 1;
			int b = a + 1;
			while (l > 2) {
				l = l - 2;
				r = r - 2;
				b++;
			}
			//out.println("a=" + a + " b=" + b + " l=" + l + " r=" + r);
			while (l <= r) {
				if (l % 2 == 1) {
					out.print(a + " ");
				} else {
					out.print(b + " ");
					b++;
					if (b > n) {
						a++;
						if (a == n) a = 1;
						b = a + 1;
					}
				}
				l++;
			}
			out.println();
		}
	}

	public void run() throws Exception {
		source = OJ ? new InputStreamReader(System.in) : new FileReader("D.in");
		br = new BufferedReader(source);
		out = new PrintWriter(System.out);
		solve();
		out.flush();
	}
	public static void main(String[] args) throws Exception {
		new D().run();
	}
	private boolean OJ = System.getProperty("ONLINE_JUDGE") != null;
}