import java.io.*;
import java.util.*;

// :%s/C455/"name"/
// if (debug) 

public class C455 {
	public static void main(String[] args) { new C455(); }
	FS in = new FS();
	PrintWriter out = new PrintWriter(System.out);

	int t;
	int n, m, q;
	ArrayList<Integer>[] adj;
	DSU set;

	boolean debug = !true, multi = !true;

	C455() {
		if (multi) t = in.nextInt();
		do {
			if (multi) if (z(t--)) break;

			n = in.nextInt();
			m = in.nextInt();
			q = in.nextInt();
			
			adj = new ArrayList[n];
			int[] deg = new int[n];
			for (int i = 0; i < n; i++)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;
				adj[u].add(v); deg[u]++;
				adj[v].add(u); deg[v]++;
			}

			int cmps = 0;
			int[] cmpId = new int[n];
			Arrays.fill(cmpId, -1);
			for (int i = 0; i < n; i++)
				if (cmpId[i] == -1) {
					ArrayDeque<Integer> pre = new ArrayDeque<>();			
					pre.add(i); cmpId[i] = cmps;
					while (!z(pre.size())) {
						int node = pre.poll();
						for (int nbr : adj[node])
							if (cmpId[nbr] == -1) {
								cmpId[nbr] = cmps;
								pre.add(nbr);
							}
					}
					cmps++;
				}

			ArrayDeque<Integer>[] Q = new ArrayDeque[cmps];
			for (int i = 0; i < cmps; i++)
				Q[i] = new ArrayDeque<>();

			int[] cmpSz = new int[cmps];
			for (int i = 0; i < n; i++) {
				if (deg[i] == 1) {
					Q[cmpId[i]].add(i);
					deg[i]--;
				}
				cmpSz[cmpId[i]]++;
			}
			int[] build = new int[cmps];
			for (int i = 0; i < cmps; i++) {
				for (build[i] = 0; !z(Q[i].size()); build[i]++) {
					if (cmpSz[i] <= 2)
						break;
					ArrayDeque<Integer> nxt = new ArrayDeque<>();
					while (!z(Q[i].size())) {
						int node = Q[i].poll();	
						for (int nbr : adj[node]) {
							if (z(deg[nbr]))
								continue;
							deg[nbr]--;
							if (deg[nbr] == 1)
								nxt.add(nbr);
						}
						cmpSz[i]--;
					}
					Q[i] = nxt;
				}
				build[i] = (build[i] << 1) + (cmpSz[i] / 2);
			}

			set = new DSU(cmps, build);
			for (int i = 0; i < q; i++) {
				int t = in.nextInt() - 1;
				int x = cmpId[in.nextInt() - 1];
				if (z(t))
					out.println(set.diameter[set.find(x)]);
				else {
					int y = cmpId[in.nextInt() - 1];
					set.union(x, y);
				}
			}

		} while (debug || multi);
		out.close();
	}

	class DSU {
		int[] s, diameter;
		DSU (int n, int[] build) {
			Arrays.fill(s = new int[n], -1);
			diameter = build.clone();
		}
		int find(int i) { return s[i] < 0 ? i : (s[i] = find(s[i])); }
		boolean union(int i, int j) {
			if ((i = find(i)) == (j = find(j)))
				return false;
			
			int di = (diameter[i] >> 1) + (diameter[i] & 1);
			int dj = (diameter[j] >> 1) + (diameter[j] & 1);
			int d = max(diameter[i], diameter[j]);
			diameter[i] = max(d, 1 + di + dj); 
			diameter[j] = max(d, 1 + di + dj);

			if (s[i] == s[j]) s[i]--;
			if (s[i] <= s[j]) s[j] = i;
			else s[i] = j;
			return true;
		}
	}

	int min(int a, int b) { if (a < b) return a; return b; }	
	int max(int a, int b) { if (a > b) return a; return b; }	
	long min(long a, long b) { if (a < b) return a; return b; }	
	long max(long a, long b) { if (a > b) return a; return b; }	

	boolean z(int x) { if (x == 0) return true; return false; }	
	boolean z(long x) { if (x == 0) return true; return false; }	

	void sort(int[] arr) {
		int sz = arr.length, j;
		Random r = new Random();
		for (int i = 0; i < sz; i++) {
			j = r.nextInt(sz);
			arr[i] = arr[j]^(arr[i]^(arr[j] = arr[i]));
		} Arrays.sort(arr);
	}

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
	}
}
