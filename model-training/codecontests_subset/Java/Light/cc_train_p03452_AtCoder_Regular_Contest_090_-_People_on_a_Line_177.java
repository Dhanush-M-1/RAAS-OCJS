import java.io.*;
import java.util.*;

public class Main {

	ArrayList<Integer>[] g;
	
	boolean[] vis;
	int[] delta;
	
	void submit() {
		int n = nextInt();
		int m = nextInt();
		
		g = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			g[i] = new ArrayList<>();
		}
		
		while (m-- > 0) {
			int v = nextInt() - 1;
			int u = nextInt() - 1;
			int d = nextInt();
			g[v].add(u);
			g[v].add(d);
			g[u].add(v);
			g[u].add(-d);
		}
		
		vis = new boolean[n];
		delta = new int[n];
		
		for (int i = 0; i < n; i++) {
			if (!vis[i]) {
				if (!dfs(i, 0)) {
					out.println("No");
					return;
				}
			}
		}
		
		out.println("Yes");
	}
	
	boolean dfs(int v, int x) {
		vis[v] = true;
		delta[v] = x;
		
		for (int i = 0; i < g[v].size(); i += 2) {
			int u = g[v].get(i);
			int d = g[v].get(i + 1);
			if (!vis[u]) {
				if (!dfs(u, x + d)) {
					return false;
				}
			} else {
				if (delta[u] != x + d) {
					return false;
				}
			}
		}
		
		return true;
	}

	void preCalc() {

	}

	void stress() {

	}

	void test() {

	}

	Main() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		preCalc();
		submit();
		//stress();
		//test();
		out.close();
	}

	static final Random rng = new Random();

	static int rand(int l, int r) {
		return l + rng.nextInt(r - l + 1);
	}

	public static void main(String[] args) throws IOException {
		new Main();
	}

	BufferedReader br;
	PrintWriter out;
	StringTokenizer st;

	String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return st.nextToken();
	}

	String nextString() {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
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
}
