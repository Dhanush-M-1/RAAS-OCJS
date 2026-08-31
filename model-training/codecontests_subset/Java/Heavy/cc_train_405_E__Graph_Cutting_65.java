import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class GraphCutting {


	static class Edge implements Comparable<Edge>
	{
		int u,v;
		public Edge(int u,int v)
		{
			this.u = u;
			this.v = v;
		}
		public int compareTo(Edge o) {
			if(this.u == o.u) return this.v - o.v;
			return this.u - o.u;
		}
	}

	static int N,E;
	static ArrayList<Integer> g[];
	static TreeSet<Edge> usedEdges = new TreeSet();
	static boolean seen[];
    static PrintWriter out = new PrintWriter(System.out);
	public static Edge dfs(int u)
	{

		seen[u] = true;
		TreeSet<Edge> children = new TreeSet();
		TreeSet<Edge> extra = new TreeSet();
		for(Integer k : g[u])
		{
			
			if(usedEdges.contains(new Edge(u,k))) continue;
			usedEdges.add(new Edge(u,k));
			usedEdges.add(new Edge(k,u));
			children.add(new Edge(u,k));
			if(seen[k]) continue;
			Edge ex = dfs(k);
			if(ex == null) continue;
			extra.add(ex);
		}
		
		for(Edge e : extra)
		{
			out.printf("%d %d %d\n",e.v + 1,e.u + 1,u + 1);
			children.remove(new Edge(u,e.u));
		}
		int size = children.size();
		if( (size & 1) == 1)
		{
			while(size != 1)
			{
				Edge first = children.pollFirst();
				Edge second = children.pollFirst();
				out.printf("%d %d %d\n",first.v + 1 ,u + 1,second.v + 1);
				size -= 2;
			}
			return children.pollFirst();
		}
		else
		{
			while(size != 0)
			{
				Edge first = children.pollFirst();
				Edge second = children.pollFirst();
				out.printf("%d %d %d\n",first.v + 1,u + 1,second.v + 1);
				size -= 2;
			}
			
			return null;
		}
	}
	public static void main(String[]args )throws Throwable
	{
		IR in = new IR(System.in);
		N = in.j(); E = in.j();
		g = new ArrayList[N];
		seen = new boolean[N];
		for(int i = 0 ; i < N ; ++i)
			g[i] = new ArrayList();
		for(int j = 0 ; j < E ; j++)
		{
			int u = in.j() ; int v = in.j();
			--u; --v;
			g[u].add(v);
			g[v].add(u);
		}
		if((E & 1) == 1)
		{
			System.out.println("No solution");
			return;
		}
		dfs(0);
		out.flush();
		out.close();

	}
	static	class IR {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public IR(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int j() {
			return Integer.parseInt(next());
		}
		public long ll(){
			return Long.parseLong(next());
		}

	}
}
