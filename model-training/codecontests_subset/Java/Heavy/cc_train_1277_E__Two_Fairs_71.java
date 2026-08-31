import java.io.*;
import java.util.*;

public class e {
	public static void main(String[] args) { new e(); }
	FS in = new FS();
	PrintWriter out = new PrintWriter(System.out);

	int t, n, m, a, b;
	ArrayList<Integer>[] adj;
	
	e() {
		t = in.nextInt();
		while (t-- > 0) {
			n = in.nextInt();
			m = in.nextInt();
			a = in.nextInt() - 1;
			b = in.nextInt() - 1;

			adj = new ArrayList[n];
			for (int i = 0; i < n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;
				adj[u].add(v);
				adj[v].add(u);
			}			
			
			boolean[] vis = new boolean[n];
			ArrayDeque<Integer> q = new ArrayDeque<>();
			vis[a] = true; q.add(a);
			while (q.size() > 0) {
				int node = q.poll();
				for (int nbr : adj[node]) {
					if (vis[nbr]) continue;
					if (nbr == b) continue;
					vis[nbr] = true;
					q.add(nbr);
				}
			}
			int bside = 0;
			for (int i = 0; i < n; i++)
				if (i != b && !vis[i])
					bside++;

			Arrays.fill(vis, false);
			vis[b] = true; q.add(b);
			while (q.size() > 0) {
				int node = q.poll();
				for (int nbr : adj[node]) {
					if (vis[nbr]) continue;
					if (nbr == a) continue;
					vis[nbr] = true;
					q.add(nbr);
				}
			}
			int aside = 0;
			for (int i = 0; i < n; i++)
				if (i != a && !vis[i])
					aside++;
			long ans = aside; ans *= bside;
			out.println(ans);
		}
		out.close();
	}

	
	
	int abs(int x) { if (x < 0) return -x; return x; }
	long abs(long x) { if (x < 0) return -x; return x; }
	int max(int x, int y) { if (x < y) return y; return x; }
	int min(int x, int y) { if (x > y) return y; return x; }
	long max(long x, long y) { if (x < y) return y; return x; }
	long min(long x, long y) { if (x > y) return y; return x; }

	class FS {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens()) {
				try { st = new StringTokenizer(br.readLine()); }
				catch (Exception e) {}
			} return st.nextToken();
		}
		int nextInt() { return Integer.parseInt(next()); }
		long nextLong() { return Long.parseLong(next()); }
		double nextDouble() { return Double.parseDouble(next()); }

		void intArr(int sz, int[] x) { for (int i = 0; i < sz; i++) x[i] = nextInt(); }
		void longArr(int sz, long[] x) { for (int i = 0; i < sz; i++) x[i] = nextLong(); }
		void doubleArr(int sz, double[] x) { for (int i = 0; i < sz; i++) x[i] = nextDouble(); }
	}
}

