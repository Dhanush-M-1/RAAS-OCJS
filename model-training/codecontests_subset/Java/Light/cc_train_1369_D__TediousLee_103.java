import java.io.*;
import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter out = new PrintWriter(System.out);
	static final int MAXN = (int) 2e6 + 5, MOD = (int) 1e9 + 7;
	
	static int fix(long x) {
		return (int) (x % MOD + MOD) % MOD;
	}

	public static void main(String[] args) throws Exception {
		int dp[] = new int[MAXN];
		for(int i = 3; i < MAXN; i++) {
			long cur = (2L * dp[i - 2] + dp[i - 1]);
			dp[i] = fix(cur + (i % 3 == 0 ? 4 : 0));
		}
		
		int t = sc.nextInt();
		while(t-- > 0) out.println(dp[sc.nextInt()]);
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