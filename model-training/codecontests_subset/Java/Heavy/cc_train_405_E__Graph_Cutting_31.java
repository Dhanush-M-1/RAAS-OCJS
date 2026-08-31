import java.util.*;
import java.io.*;
public class GraphCutting
{
	public static ArrayList<Edge>[] adj;
	public static boolean[] visited;
	public static boolean[] visited2;
	public static ArrayList<int[]> paths;
	
	public static void main(String[] args) throws Exception
	{
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int m = in.nextInt();
		
		adj = new ArrayList[n];
		for(int x = 0; x < adj.length; x++)
		{
			adj[x] = new ArrayList<Edge>();
		}
		
		for(int y = 0; y < m; y++)
		{
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;
			
			adj[a].add(new Edge(a, b, y));
			adj[b].add(new Edge(b, a, y));
		}
		
		if(m % 2 == 1)
		{
			out.println("No solution");
		}
		else
		{
			visited = new boolean[n];
			visited2 = new boolean[m];
			paths = new ArrayList<int[]>();
			
			dfs(0, -1);
			
			for(int[] path : paths)
			{
				out.println((path[0] + 1) + " " + (path[1] + 1) + " " + (path[2] + 1));
			}
		}
		
		out.close();
	}
	
	public static int dfs(int node, int parent)
	{
		if(visited[node])
		{
			return 1;
		}
		
		visited[node] = true;
		
		int prev = -1;
		for(Edge e : adj[node])
		{
			if(!visited2[e.id] && e.end != parent)
			{
				visited2[e.id] = true;
				
				int flag = dfs(e.end, node);
				
				if(flag == 1)
				{
					if(prev != -1)
					{
						paths.add(new int[] {prev, node, e.end});
						prev = -1;
					}
					else
					{
						prev = e.end;
					}
				}
			}
		}
		
		if(prev != -1)
		{
			paths.add(new int[] {prev, node, parent});
			return 0;
		}
		else
		{
			return 1;
		}
	}
	
	static class Edge
	{
		int start;
		int end;
		int id;
		
		public Edge(int s, int e, int i)
		{
			start = s;
			end = e;
			id = i;
		}
	}
	
	static class FastScanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public FastScanner(InputStream input)
		{
			br = new BufferedReader(new InputStreamReader(input));
			st = new StringTokenizer("");
		}
		
		public String next() throws IOException
		{
			if(st.hasMoreTokens())
			{
				return st.nextToken();
			}
			else
			{
				st = new StringTokenizer(br.readLine());
				return next();
			}
		}
		
		public int nextInt() throws IOException
		{
			return Integer.parseInt(next());
		}
	}
}
