import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B475 {
	static int[] in, par, deg;
	static boolean[] dead;
	static ArrayDeque<Integer> sol;
	static ArrayList<Integer>[] adj;
	public static void main(String[] args) {
		FS scan = new FS(System.in);
		int N = scan.nextInt();
		in = new int[N];
		par = new int[N];
		deg = new int[N];
		dead = new boolean[N];
		
		adj = new ArrayList[N];
		for(int i=0;i<N;i++)adj[i] = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			par[i] = scan.nextInt()-1;
			if(par[i]!=-1) {
				adj[par[i]].add(i);
				in[par[i]]++;
				deg[par[i]]++;
				deg[i]++;
			}
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		sol = new ArrayDeque<>();
		for(int i=0;i<N;i++)if(in[i]==0)q.add(i);
		while(!q.isEmpty()) {
			int node = q.poll();
			
			if(par[node]!=-1) {
				in[par[node]]--;
				if(in[par[node]]==0)
					q.add(par[node]);
			}
			
			if(deg[node]%2==1)continue;
			
			sol.add(node);
			dead[node] = true;
			deg[node] = 0;
			for(int i : adj[node])
				deg[i]--;
			if(par[node]!=-1)deg[par[node]]--;
			
			dfs(node);
			
		}
		
		if(sol.size()!=N) {
			System.out.println("NO");
		}else {
			PrintWriter out = new PrintWriter(System.out);
			out.println("YES");
			for(int i : sol) {
				out.println(i+1);
			}
			out.close();
		}
	}
	
	private static void dfs(int node) {
		
		for(int i : adj[node]) {
			if(dead[i])continue;
			if(deg[i]%2 == 0) {
				sol.add(i);
				dead[i] = true;
				deg[i] = 0;
				for(int j : adj[i])deg[j]--;
				dfs(i);
			}
		}
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
}
