import java.io.*;
import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws Exception {
		int tc = sc.nextInt();
		while(tc-- > 0) {
			int n = sc.nextInt();
			int cp = 0, cc = 0;
			boolean flag = true;
			while(n-- > 0) {
				int p = sc.nextInt(), c = sc.nextInt();
				int dp = p - cp, dc = c - cc;
				flag &= (dp >= 0 && dc >= 0);
				flag &= (dp >= dc);
				cp = p; cc = c;
			}
			out.println(flag ? "YES" : "NO");
		}
		out.close();
	}
}

class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream system) {
		br = new BufferedReader(new InputStreamReader(system));
	}

	public Scanner(String file) throws Exception {
		br = new BufferedReader(new FileReader(file));
	}

	public String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public String nextLine() throws IOException {
		return br.readLine();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	public Long nextLong() throws IOException {
		return Long.parseLong(next());
	}
}
