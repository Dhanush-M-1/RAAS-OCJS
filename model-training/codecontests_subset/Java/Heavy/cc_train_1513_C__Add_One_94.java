import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	void run() throws Exception {
		int cnt_tests = nextInt();
		for (int test = 0; test < cnt_tests; test++) {
			solve();
		}
	}

	static long mod = 1000_000_007;
	
	static final int MAX_SIZE = 200_000 + 51; 
	static long dp [] = new long[MAX_SIZE];

	static long sum(long a, long b) {
		return (a + b) % mod;
	}
	
	static long mul(long a, long b) {
		return (a * b) % mod;
	}
	
	static {
		for (int i = 0; i < 10; i++) {
			dp[i] = 1;
		}
		
		for (int i = 10; i < MAX_SIZE; i++) {
			dp[i] = sum(dp[i-9], dp[i-10]);
		}
	}

	static final int DIGITS = 10;
	static int cnt[] = new int[DIGITS];

	private void solve() throws IOException {
		int n = nextInt();
		int m = nextInt();
		for (int i = 0; i < DIGITS; i++) {
			cnt[i] = 0;
		}

		while(n > 0) {
			cnt[n % 10]++;
			n /= 10;
		}
		
		long result = 0;

		for (int i = 0; i < DIGITS; i++) {
//			System.out.println(" += " + dp[i+m] + " x " + cnt[i]);
			result = sum(result, mul(cnt[i], dp[i + m]));
		}

		out.println(result);		
	}

	public static void main(String[] args) throws Exception {
		Main instance = new Main();
		instance.initStreams();
		instance.run();
		instance.closeStreams();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st = new StringTokenizer("");

	void initStreams() throws FileNotFoundException {
		if (new File("input.txt").exists()) {
			try {
				System.setIn(new FileInputStream("input.txt"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
	}

	void closeStreams() throws IOException {
		in.close();
		out.close();
	}

	String nextString() throws IOException {
		while (!st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextString());
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextString());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextString());
	}
}
