import java.io.*;
import java.util.*;

public class B {

	BufferedReader in;
	StringTokenizer st;
	PrintWriter out;

	String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(in.readLine());
		return st.nextToken();
	}

	int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	long nextLong() throws Exception {
		return Long.parseLong(next());
	}

	double nextDouble() throws Exception {
		return Double.parseDouble(next());
	}

	static class Edge {
		int t, cost;

		public Edge(int t, int cost) {
			this.t = t;
			this.cost = cost;
		}
	}

	public static void shortestPaths(List<Edge>[] edges, int s, int[] prio,
			int[] pred) {
		Arrays.fill(pred, -1);
		Arrays.fill(prio, Integer.MAX_VALUE);
		prio[s] = 0;
		PriorityQueue<Long> q = new PriorityQueue<Long>();
		q.add((long) s);
		while (!q.isEmpty()) {
			long cur = q.poll();
			int curu = (int) cur;
			if (cur >>> 32 != prio[curu])
				continue;
			for (Edge e : edges[curu]) {
				int v = e.t;
				int nprio = prio[curu] + e.cost;
				if (prio[v] > nprio) {
					prio[v] = nprio;
					pred[v] = curu;
					q.add(((long) nprio << 32) + v);
				}
			}
		}
	}

	void solve() throws Exception {
		int n = nextInt();
		int x = nextInt();
		n = n + 1;
		int in[] = new int[n];
		int outa[] = new int[n];

		List<Edge>[] edges = new List[n];
		for (int i = 0; i < n; i++)
			edges[i] = new ArrayList<Edge>();

		for (int i = 1; i < n; i++) {
			outa[i] = nextInt();
			if (outa[i] != x)
				edges[outa[i]].add(new Edge(i, 1));
			in[outa[i]]++;
		}

		int d[] = new int[n];
		int p[] = new int[n];

		shortestPaths(edges, 0, d, p);
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i = 1; i < n; i++)
			if (in[i] == 0)
				if (d[i] != 2147483647 && i != x) {
					l.add(d[i]);
					// System.err.println("KNAP: " + d[i]);
				}

		int k = d[x];

		// System.err.println("INIT: " + k);

		int MAX = 10000;
		boolean kp[] = new boolean[MAX + 1];
		kp[0] = true;
		for (int w : l)
			for (int i = MAX; i >= w; i--)
				if (kp[i - w])
					kp[i] = true;

		for (int i = 0; i < MAX; i++)
			if (kp[i])
				out.println((k + i));

	}

	void run() {
		try {
			Locale.setDefault(Locale.US);
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(new OutputStreamWriter(System.out));
			solve();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		new B().run();
	}

}
