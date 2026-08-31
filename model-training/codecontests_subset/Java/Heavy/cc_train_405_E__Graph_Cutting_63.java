// package CF;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class A {
	static final int VIS = 2, EXP = 1, UN = 0;
	static ArrayList<Integer> [] adj;
	static int [] vis;
	static StringBuilder sb;
	static int dfs(int u){
		vis[u] = EXP;
		TreeSet<Integer> set = new TreeSet<>();
		for(int v:adj[u])
			if(vis[v] == UN){
				int t = dfs(v);
				if(t != -1)
					sb.append(u+1).append(" ").append(v+1).append(" ").append(t+1).append("\n");
				else set.add(v);
			}
			else if(vis[v] == VIS)
				set.add(v);
		while(set.size() >= 2){
			int x = set.first();
			set.remove(x);
			int y = set.first();
			set.remove(y);
			sb.append(x+1).append(" ").append(u+1).append(" ").append(y+1).append("\n");
		}
		vis[u] = VIS;
		if(set.size() == 1)
			return set.first();
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), m = sc.nextInt();
		if((m & 1) != 0)
			out.println("No solution");
		else{
			adj = new ArrayList[n];
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<>();
			}
			sb = new StringBuilder();
			vis = new int[n];
			while(m-->0){
				int u = sc.nextInt(), v = sc.nextInt();
				u--; v--;
				adj[u].add(v);
				adj[v].add(u);
			}
			sb = new StringBuilder();
			dfs(0);
			out.print(sb);
		}
		out.flush();
		out.close();
	}
	
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner(FileReader fileReader) {
			br = new BufferedReader(fileReader);
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}