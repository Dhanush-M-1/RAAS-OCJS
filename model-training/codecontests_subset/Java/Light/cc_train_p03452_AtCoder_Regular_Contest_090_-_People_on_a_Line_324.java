import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean dfs(int node, long cost, boolean[] visited, long[] costs, ArrayList<HashMap<Integer, Long>> adj){
		visited[node] = true;
		costs[node] = cost;
		//System.out.println(node + " " + cost);
		
		for(final Entry<Integer, Long> entry : adj.get(node).entrySet()){
			final int next = entry.getKey();
			final long next_cost = costs[node] + entry.getValue();
			
			if(!visited[next]){
				if(!dfs(next, next_cost, visited, costs, adj)){ return false; }
			}else{
				if(costs[next] != next_cost){ return false; }
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		final int N = sc.nextInt();
		final int M = sc.nextInt();
		
		ArrayList<HashMap<Integer, Long>> adj = new ArrayList<HashMap<Integer, Long>>();
		for(int i = 0; i < N; i++){ adj.add(new HashMap<Integer, Long>()); }
		
		for(int i = 0; i < M; i++){
			final int L = sc.nextInt() - 1;
			final int R = sc.nextInt() - 1;
			final long D = sc.nextLong();
			
			adj.get(L).put(R, D);
			adj.get(R).put(L, -D);
		}
		
		boolean[] visited = new boolean[N];
		long[] costs = new long[N];
		
		for(int i = 0; i < N; i++){
			if(visited[i]){ continue; }
			if(!dfs(i, 0, visited, costs, adj)){
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
		
	}
	
	public static class Scanner implements Closeable {
		private BufferedReader br;
		private StringTokenizer tok;
 
		public Scanner(InputStream is) throws IOException {
			br = new BufferedReader(new InputStreamReader(is));
		}	
 
		private void getLine() throws IOException {
			while (!hasNext()) {
				tok = new StringTokenizer(br.readLine());
			}
		}
 
		private boolean hasNext() {
			return tok != null && tok.hasMoreTokens();
		}
 
		public String next() throws IOException {
			getLine();
			return tok.nextToken();
		}
 
		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
 
		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}
 
		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
 
		public void close() throws IOException {
			br.close();
		}
	}
}