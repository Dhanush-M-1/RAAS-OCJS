import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class EEdu37 {
	public static void main(String[] args) {
		FS scan = new FS(System.in);
		int N = scan.nextInt(),  M = scan.nextInt();
		ArrayList<Integer>[] adj = new ArrayList[N];
		for(int i=0;i<N;i++)adj[i] = new ArrayList<>();
		for(int i=0;i<M;i++) {
			int u = scan.nextInt()-1, v = scan.nextInt()-1;
			adj[u].add(v);
			adj[v].add(u);
		}
		DisjointSet ds = new DisjointSet(N);
		boolean[] seen = new boolean[N];
		
		if(N<=500) {
			boolean[][] mat = new boolean[N][N];
			
			for(int i=0;i<N;i++)Arrays.fill(mat[i], true);
			for(int i =0;i<N;i++)for(int j : adj[i])mat[i][j] = mat[j][i] =false;
			
			ArrayDeque<Integer> q = new ArrayDeque<>();
			ArrayList<Integer> sol = new ArrayList<>();
			for(int i=0;i<N;i++) {
				if(seen[i])continue;
				seen[i] = true;
				
				q.add(i);
				int sz = 0;
				while(!q.isEmpty()) {
					int x = q.poll();
					sz++;
					for(int j=0;j<N;j++) {
						if(mat[x][j] && !seen[j]) {
							seen[j] = true;
							q.add(j);
						}
					}
				}
				sol.add(sz);
				
				
			}
			Collections.sort(sol);
			PrintWriter out = new PrintWriter(System.out);
			out.println(sol.size());
			for(int i=0;i<sol.size();i++)out.print(sol.get(i)+" ");
			out.println();
			out.close();
			
			return;
		}
		
		
		boolean[] a = new boolean[N];
		
		int idx = -1, min = 1000000;
		for(int i=0;i<N;i++)if(adj[i].size()< min) { min = adj[i].size(); idx = i;}
		for(int start=idx;start<N+idx;start++) {
			int i = start%N;
			if(seen[i])continue;
			
			seen[i] = true;
			ArrayDeque<Integer> q = new ArrayDeque<>();
			q.add(i);
			while(!q.isEmpty()) {
				int x = q.poll();
				Arrays.fill(a, false);
				for(int j : adj[x]) {
					a[j] = true;
					if(seen[j])continue;
					seen[j] = true;
					q.add(j);
				}
				for(int j=0;j<N;j++) {
					if(!a[j]) {
						ds.union(x, j);
						seen[j] = true;
					}
				}
			}
			
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			if(!map.containsKey(ds.id[i]))map.put(ds.id[i], 1);
			else map.put(ds.id[i], map.get(ds.id[i])+1);
		}
		
		ArrayList<Integer> sol =  new ArrayList<>();
		for(int i : map.values())sol.add(i);
		
		Collections.sort(sol);
		PrintWriter out = new PrintWriter(System.out);
		out.println(sol.size());
		for(int i=0;i<sol.size();i++)out.print(sol.get(i)+" ");
		out.println();
		out.close();
	}
	private static class FS {
		BufferedReader br;
		StringTokenizer st;
		public FS(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}
		String next(){
			while(st==null||!st.hasMoreElements()){
				try{st = new StringTokenizer(br.readLine());}
				catch(IOException e){e.printStackTrace();}
			}
			return st.nextToken();
		}
		int nextInt() {return Integer.parseInt(next());}
		long nextLong() {return Long.parseLong(next());}
		double nextDouble() { return Double.parseDouble(next());}
	}
	private static class DisjointSet {
		int[] id, sz;
		public DisjointSet(int N) {//N=Number of verts
			id = new int[N];
			sz = new int[N];
			for (int i=0;i<N;i++){sz[i]=1;id[i]=i;}
		}
		 
		private int root(int i){
			return id[i] = (i!=id[i])?root(id[i]):i;
		}
		public boolean find(int p, int q){
			return root(p)==root(q);
		}
		public void union(int p, int q){
			int i=root(p);
			int j=root(q);
			if (sz[i]<sz[j]){id[i]=j;sz[j]+=sz[i];}
			else 			{id[j]=i;sz[i]+=sz[j];};
		}
	}
}
