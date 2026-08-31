import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

@SuppressWarnings("unchecked")
public class f {
	static class Solver {

		int N, M, K, Q, unions[][], IDX;
		long limits[], oo = (long) Integer.MAX_VALUE * Integer.MAX_VALUE, dist[];
		ArrayList<int[]> adj[];
		ArrayDeque<Query> qq[][];
		DisjointSet DSU;
		
		void solve(int testNumber, FastScanner s, PrintWriter out) {
			N = s.nextInt(); M = s.nextInt(); K = s.nextInt(); Q = s.nextInt();
			Arrays.setAll(adj = new ArrayList[N], x -> new ArrayList<>());
			for(int m = 0, u, v, w; m < M; m++) {
				u = s.nextInt() - 1; v = s.nextInt() - 1; w = s.nextInt();
				adj[u].add(new int[] { v, w }); adj[v].add(new int[] { u, w });
			}
			
			unions = new int[N - 1][2]; limits = new long[N - 1]; IDX = 0;
			PriorityQueue<State> q = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
			Arrays.fill(dist = new long[N], oo);
			for (int i = 0; i < K; i++) {
				q.add(new State(i, 0)); dist[i] = 0;
			}

			State cur; long cdist, dto; int vtx, to;
			// multi source dijkstra - get closest station to all vertices
			while(!q.isEmpty()) {
				cur = q.poll(); cdist = cur.dist; vtx = cur.vtx;
				if(dist[vtx] < cdist) continue; // outdated
				
				for(int[] e : adj[vtx]) {
					to = e[0]; dto = cdist + e[1];
					if(dist[to] > dto) {
						dist[to] = dto;
						q.add(new State(to, dto));
					}
				}
			}
			
			PriorityQueue<Edge> eq = new PriorityQueue<>((a, b) -> Long.compare(a.thr, b.thr));
			for(int i = 0; i < N; i++)
				for(int[] e : adj[i])
					if(e[0] > i)
						eq.add(new Edge(i, e[0], e[1] + dist[i] + dist[e[0]]));
			
			DSU = new DisjointSet(N);
			Edge ce;
			while (IDX < N - 1) {
				ce = eq.poll();
				if(!DSU.union(ce.a, ce.b)) continue;
				unions[IDX][0] = ce.a; unions[IDX][1] = ce.b; limits[IDX++] = ce.thr;			
			}
			
			int[] qAns = new int[Q]; qq = new ArrayDeque[2][N]; Arrays.fill(qAns, N - 1);
			Arrays.setAll(qq[0], x -> new ArrayDeque<>());
			Arrays.setAll(qq[1], x -> new ArrayDeque<>());
			for(int i = 0, m = N - 1 >> 1; i < Q; i++)
				qq[0][m].add(new Query(s.nextInt() - 1, s.nextInt() - 1, 0, N - 1, i));
			
			int done = 0, w = 0;
			while(done < Q) {
				// pass through disjoint set, update queries
				Arrays.fill(DSU.s, -1);
				for(int i = 0; i < N - 1; i++) {
					DSU.union(unions[i][0], unions[i][1]);
					// process queries at this time step
					while(!qq[w][i].isEmpty()) {
						Query curq = qq[w][i].poll();
						if(DSU.find(curq.a) == DSU.find(curq.b)) {
							// they've been joined by now 
							qAns[curq.qi] = i; curq.hi = curq.m - 1; curq.recalc();
						} else {
							// they've not been joined
							curq.lo = curq.m + 1; curq.recalc();
						}
						if(curq.lo > curq.hi) done++;
						else qq[w ^ 1][curq.m].add(curq);
					}
				}
				w ^= 1; // flip the queue we use
			}
			
			for(int x : qAns) out.println(limits[x]);
			
		}
		
		HashMap<Integer, Long> merge(HashMap<Integer, Long> a, HashMap<Integer, Long> b) {
			HashMap<Integer, Long> big, small;
			if(a.size() > b.size()) { big = a; small = b; }
			else { big = b; small = a; }
			for(Entry<Integer, Long> e : small.entrySet()) 
				big.put(e.getKey(), min(e.getValue(), big.getOrDefault(e.getKey(), oo)));
			return big;
		}
		
		static long min(long a, long b) { return a < b ? a : b; }
		
		static class Query {
			int a, b, lo, hi, m, f, qi;
			Query(int aa, int bb, int ll, int hh, int qq) {
				a = aa; b = bb; lo = ll; hi = hh; m = lo + hi >> 1; f = -1; qi = qq;
			}
			void recalc() { m = lo + hi >> 1; }
		}
		
		static class State {
			int vtx; long dist;
			State(int v, long d) { vtx = v; dist = d; }
		}
		
		static class Edge {
			int a, b; long thr;
			Edge(int aa, int bb, long tt) { a = aa; b = bb; thr = tt; }
		}
		
		static class DisjointSet {
			int s[], sz;
			
			public DisjointSet(int n) { Arrays.fill(s = new int[sz = n], -1); }
			
			public int find(int i) {
				return s[i] < 0 ? i : (s[i] = find(s[i]));
			}
			
			public boolean union(int a, int b) {
				if ((a = find(a)) == (b = find(b))) return false;
				if(s[a] == s[b]) s[a]--;
				if(s[a] <= s[b]) s[b] = a; else s[a] = b;
				sz--; return true;
			}
		}
		
	}

	final static boolean cases = false;

	public static void main(String[] args) {

		FastScanner s = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		Solver solver = new Solver();
		for (int t = 1, T = cases ? s.nextInt() : 1; t <= T; t++)
			solver.solve(t, s, out);

		out.close();

	}

	static int min(int a, int b) {
		return a < b ? a : b;
	}

	static int max(int a, int b) {
		return a > b ? a : b;
	}

	static long min(long a, long b) {
		return a < b ? a : b;
	}

	static long max(long a, long b) {
		return a > b ? a : b;
	}

	static int swap(int a, int b) {
		return a;
	}

	static Object swap(Object a, Object b) {
		return a;
	}

	static String ts(Object... o) {
		return Arrays.deepToString(o);
	}

	static class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
		}

		public FastScanner(File f) throws FileNotFoundException {
			this(new FileInputStream(f));
		}

		public FastScanner(String s) {
			this.stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
		}

		int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public String next() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}

		// Jacob Garbage

		public int[] nextIntArray(int N) {
			int[] ret = new int[N];
			for (int i = 0; i < N; i++)
				ret[i] = this.nextInt();
			return ret;
		}

		public int[][] next2DIntArray(int N, int M) {
			int[][] ret = new int[N][];
			for (int i = 0; i < N; i++)
				ret[i] = this.nextIntArray(M);
			return ret;
		}

		public long[] nextLongArray(int N) {
			long[] ret = new long[N];
			for (int i = 0; i < N; i++)
				ret[i] = this.nextLong();
			return ret;
		}

		public long[][] next2DLongArray(int N, int M) {
			long[][] ret = new long[N][];
			for (int i = 0; i < N; i++)
				ret[i] = nextLongArray(M);
			return ret;
		}

		public double[] nextDoubleArray(int N) {
			double[] ret = new double[N];
			for (int i = 0; i < N; i++)
				ret[i] = this.nextDouble();
			return ret;
		}

		public double[][] next2DDoubleArray(int N, int M) {
			double[][] ret = new double[N][];
			for (int i = 0; i < N; i++)
				ret[i] = this.nextDoubleArray(M);
			return ret;
		}

	}
}