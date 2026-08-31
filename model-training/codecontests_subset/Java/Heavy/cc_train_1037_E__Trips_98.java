
import java.io.*;
import java.util.*;

/*
Solution Sketch:
*/

public class trips {

	static final boolean stdin = true;
	static final String filename = "";
	static FastScanner br;
	static PrintWriter pw;

	public static void main(String[] args) throws IOException {

		if (stdin) {
			br = new FastScanner();
			pw = new PrintWriter(new OutputStreamWriter(System.out));
		}

		else {
			br = new FastScanner(filename + ".in");
			pw = new PrintWriter(new FileWriter(filename + ".out"));
		}

		X solver = new X();
		solver.solve(br, pw);
	}

	static class X {
		public void solve(FastScanner br, PrintWriter pw) throws IOException {
			int n = br.nextInt(); int m = br.nextInt(); int k = br.nextInt(); int[] deg = new int[n];
			TreeSet<Pair> s = new TreeSet<Pair>();
			LinkedList<Integer>[] adj = new LinkedList[n];
			LinkedList<Pair> edges = new LinkedList<Pair>();
			for(int i = 0; i < adj.length; i++) {
				adj[i] = new LinkedList<Integer>();
			}
			for(int i = 0; i < m; i++) {
				int u = br.nextInt(); int v = br.nextInt(); 
				u--; v--;
				adj[u].add(v);
				adj[v].add(u);
				edges.add(new Pair(u,v));
				deg[u]++; deg[v]++;
			}
			for(int i = 0; i < n; i++) {
				s.add(new Pair(deg[i], i));
			}
			boolean[] vis = new boolean[n];
			while(!s.isEmpty()) {
//				pw.println("set first: " + (s.first().f + " " + s.first().s));
				if(s.first().f < k) {
					Pair p = s.pollFirst();
					for(int e : adj[p.s]) {
						if(vis[e]) {continue;}
						s.remove(new Pair(deg[e], e));
						deg[e]--;
						s.add(new Pair(deg[e], e));
					}
					vis[p.s] = true;
				}
				else {
					break;
				}
			}
			TreeSet<Pair> visited = new TreeSet<Pair>();
			Collections.reverse(edges);
			ArrayList<Integer> ans = new ArrayList<Integer>();
			for(Pair pr : edges) {
				
				ans.add(s.size());
//
//				pw.println();
//				pw.println("DEGREES b4:");
//				for(int i = 0; i < n; i++){
//					pw.print(deg[i] + " ");
//				}
//				pw.println("Edges: " + (pr.f+1) + " " + (pr.s+1));
				if(!vis[pr.f] && !vis[pr.s]) {
//					pw.println("EDGE RUN");
					
					s.remove(new Pair(deg[pr.f], pr.f));
					s.remove(new Pair(deg[pr.s], pr.s));
					deg[pr.f]--;
					deg[pr.s]--;
					s.add(new Pair(deg[pr.f],pr.f));
					s.add(new Pair(deg[pr.s], pr.s));
//					pw.println("DEGREES:");
//					for(int i = 0; i < n; i++){
//						pw.print(deg[i] + " ");
//					}
					
//					pw.println();
//					pw.println("SET:");
//					for(Pair curr : s) {
//						pw.print(curr.f + " " + curr.s + "  ");
//					}
//					pw.println();
//					pw.println("VISITED:");
//					for(int i = 0; i < n; i++) {
//						pw.print(vis[i] + " ");
//					}
					while(!s.isEmpty()) {
						if(s.first().f < k) {
							Pair p = s.pollFirst();
							for(int e : adj[p.s]) {
								if(visited.contains(new Pair(p.s, e))) {
									continue;
								}
								if(vis[e] || ((p.s == pr.f && e == pr.s) || (p.s == pr.s && e == pr.f))) {
									continue;
								}
								s.remove(new Pair(deg[e], e));
								deg[e]--;
								s.add(new Pair(deg[e], e));
							}
							vis[p.s] = true;
						}
						else {
							break;
						}
					}
					visited.add(new Pair(pr.f, pr.s));
					visited.add(new Pair(pr.s, pr.f));
				}
				
				
			}
			Collections.reverse(ans);
			for(int a : ans) {
				pw.println(a);
			}
			pw.close();
		}
		public static class Pair implements Comparable<Pair>{
			int f,s;
			public Pair(int f, int s) {
				this.f = f;
				this.s = s;
			}
			@Override
			public int compareTo(Pair o) {
				// TODO Auto-generated method stub
				if(this.f == o.f) {
					return this.s - o.s;
				}
				return this.f - o.f;
			}
		}
	}

	//fastscanner class
	public static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(String s) {
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
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

}
 

