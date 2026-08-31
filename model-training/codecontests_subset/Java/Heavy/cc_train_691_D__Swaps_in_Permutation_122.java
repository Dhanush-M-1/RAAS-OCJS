import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class D14 {
	static boolean[] visited;
	static int[] r;
	static ArrayList<Integer>[] adj;
	public static void main(String[] args) throws Exception {
		FastScanner in = new FastScanner();
		int n = in.nextInt(), m = in.nextInt();
		r = new int[n];
		for(int i = 0; i < n; i++)
			r[i] = in.nextInt();
		
		adj = new ArrayList[n];
		for(int i = 0; i < n; i++)
			adj[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < m; i++) {
			int a = in.nextInt() - 1,
				b = in.nextInt() - 1;
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		visited = new boolean[n];
		for(int i = 0; i < n; i++)
			bfs(i);
		
		PrintWriter pw = new PrintWriter(System.out);
		for(int a : r) {
			pw.print(a);
			pw.append(' ');
		}
		pw.println();
		pw.flush();
		pw.close();
	}

	static void bfs(int u) {
		if(visited[u])
			return;
		
		TreeSet<Integer> indices = new TreeSet<Integer>(),
						 values = new TreeSet<Integer>();
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(u);
		visited[u] = true;
		while(!q.isEmpty()) {
			u = q.poll();
			indices.add(u);
			values.add(r[u]);
			
			for(Integer neighbor : adj[u])
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					q.offer(neighbor);
				}
		}
		
		while(!indices.isEmpty())
			r[indices.pollFirst()] = values.pollLast();
	}
	
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;
		public FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}
		
		String next() throws Exception {
			while(!st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		
		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}
	}
}
