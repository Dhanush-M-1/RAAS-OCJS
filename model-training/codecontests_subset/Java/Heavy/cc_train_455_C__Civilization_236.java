



import java.io.*;
import java.util.*;

public class civilization {

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
		
		static int N, M, Q;
		static ArrayList<Integer>[] edges;
		static int[] d;
		static int[] d2;
		static boolean[] vis;
		static int ind;
		
		public void solve(FastScanner br, PrintWriter pw) throws IOException {
			
			N = br.nextInt();
			M = br.nextInt();
			Q = br.nextInt();
			edges = new ArrayList[N];
			d = new int[N];
			vis = new boolean[N];
			d2 = new int[N];
			UnionFindSet ufs = new UnionFindSet(N);
			
			for(int i = 0; i < N; i++) {
				edges[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < M; i++) {
				int a = br.nextInt();
				int b = br.nextInt();
				
				a--;
				b--;
				edges[a].add(b);
				edges[b].add(a);
				ufs.union(a, b);
				
			}
			
			
			int[] dia = new int[N];
			
			for(int i = 0; i < N; i++) {
				if(!vis[i]) { 				
					int cI = dfs(i,-1, d);
					int val = d2[dfs(cI,-1, d2)];
					dia[ufs.find(i)] = val;
				}
 			}
			
			for(int i = 0; i < Q; i++) {
				if(br.nextInt() == 1) {
					int x = br.nextInt();
					x--;
					pw.println(dia[ufs.find(x)]);
				}
				else {
					int x = br.nextInt();
					int y = br.nextInt();
					x--;
					y--;
					if(ufs.isSameSet(x, y)) {
						continue;
					}
					
					int d1 = dia[ufs.find(x)];
					int d2 = dia[ufs.find(y)];
					int d3 = (int) Math.ceil((double)d1/2) + (int)Math.ceil((double)d2/2);
					d3++;
					ufs.union(x, y);
					
					dia[ufs.find(x)] = Math.max(d1, Math.max(d2, d3));
					
				}
			}
			
			pw.close();
		}
		
		
		public static int dfs(int v, int pV, int[] d) {
			int max = d[v];
			int ind = v;
			for(Integer e : edges[v]) {
				if(e == pV) {
					continue;
				}
				d[e] = d[v]+1;
				int val = dfs(e,v, d);
				if(d[val] > max) {
					max = d[val];
					ind = val;
				}
				
			}
			
			vis[v] = true;
			
			return ind;
			
		}
	
		
		
		public class UnionFindSet {
		    int n;
		    int[] parent;
			int[] rank;
		 
		    public UnionFindSet(int n) {
		        this.n = n;
		        parent = new int[n];
				rank = new int[n];
		        init();
		    }
		 
		    public void init(){
		        for (int i = 0; i < n; i++) {
		            parent[i] = i;
					rank[i] = 0;
		        }
		    }
		 
		    public int find(int id) {
		        if (parent[id] == id)
		            return id;
		        return parent[id] = find(parent[id]);
		    }
		 
		    public void union(int x, int y) {
		        if (isSameSet(x,y))
		            return;
				int p = find(x);
				int q = find(y);
			if(rank[p] < rank[q]){
				parent[p] = q;
			}
			else{
				parent[q] = p;
			}

			if(rank[p] == rank[q]){
				rank[p]++;
			}
		    }
		 
		    public boolean isSameSet(int x, int y) {
		        return find(x) == find(y);
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
 

