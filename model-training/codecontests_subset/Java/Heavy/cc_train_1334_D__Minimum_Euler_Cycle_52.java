import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Locale;
import java.util.StringTokenizer;

public class Solution implements Runnable {
	
	private PrintStream out;
	private BufferedReader in;
	private StringTokenizer st;
	
	public void solve() throws IOException {
		long time0 = System.currentTimeMillis();
		
		int t = nextInt();
		for (int test = 1; test <= t; test++) {
			int n = nextInt();
			long l = nextLong();
			long r = nextLong();
			int[] answer = solve(n, l, r);
			for (int i = 0; i < answer.length; i++) {
				out.print(answer[i] + " ");
			}
			out.println();
		}
		
		System.err.println("time: " + (System.currentTimeMillis() - time0));
	}
	
	private int[] solve(int n, long l, long r) {
		int[] answer = new int[(int) (r - l + 1)];
		long done = 0;
		for (int i = 1; i <= n - 1; i++) {
			int lineLength = 2 * (n - i);
			if (done + lineLength < l || done + 1 > r) {
				done = done + lineLength;
			} else {
				for (int j = i + 1; j <= n; j++) {
					done = addVertex(i, done, answer, l, r);
					done = addVertex(j, done, answer, l, r);
				}
			}
		}
		done = addVertex(1, done, answer, l, r);
		return answer;
	}
	
	private long addVertex(int v, long done, int[] answer, long l, long r) {
		done++;
		if (l <= done && done <= r) {
			answer[(int) (done - l)] = v;
		}
		return done;
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
	
	public long nextLong() throws IOException {
		return Long.parseLong(next());
	}
	
	public int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	
	public String next() throws IOException {
		while (!st.hasMoreTokens()) {
			String line = in.readLine();
			if (line == null) {
				return null;
			}
			st = new StringTokenizer(line);
		}
		return st.nextToken();
	}
	
	@Override
	public void run() {
		try {
			solve();
			out.close();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}
	
	public Solution(String name) throws IOException {
		Locale.setDefault(Locale.US);
		if (name == null) {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintStream(new BufferedOutputStream(System.out));
		} else {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(name + ".in")));
			out = new PrintStream(new BufferedOutputStream(new FileOutputStream(name + ".out")));
		}
		st = new StringTokenizer("");
	}
	
	public static void main(String[] args) throws IOException {
		new Thread(new Solution(null)).start();
	}
}
