import java.util.*;
import java.io.*;
public class Civilization
{
	public static void main(String[] args) throws Exception
	{
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int q = in.nextInt();
		
		ArrayList<Integer>[] adj = new ArrayList[n];
		for(int x = 0; x < adj.length; x++)
		{
			adj[x] = new ArrayList<Integer>();
		}
		
		DisjointSet ds = new DisjointSet(n);
		for(int y = 0; y < m; y++)
		{
			int a = in.nextInt() - 1;
			int b = in.nextInt() - 1;
			
			adj[a].add(b);
			adj[b].add(a);
			
			ds.union(a, b);
		}
		
		boolean[] visited = new boolean[adj.length];
		for(int z = 0; z < adj.length; z++)
		{
			if(!visited[z])
			{
				visited[z] = true;
				
				ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
				queue.add(z);
				
				int last = z;
				while(queue.size() > 0)
				{
					int node = queue.remove();
					
					last = node;
					
					for(int next : adj[node])
					{
						if(!visited[next])
						{
							visited[next] = true;
							queue.add(next);
						}
					}
				}
				
				queue.add(last);
				queue.add(-1);
				queue.add(0);
				
				int path = 0;
				while(queue.size() > 0)
				{
					int node = queue.remove();
					int parent = queue.remove();
					int dist = queue.remove();
					
					path = Math.max(path, dist);
					
					for(int next : adj[node])
					{
						if(next != parent)
						{
							queue.add(next);
							queue.add(node);
							queue.add(dist + 1);
						}
					}
				}
				
				ds.path[ds.find(last)] = path;
			}
		}
		
		for(int a = 0; a < q; a++)
		{
			int type = in.nextInt();
			
			if(type == 1)
			{
				out.println(ds.path[ds.find(in.nextInt() - 1)]);
			}
			else
			{
				ds.union(in.nextInt() - 1, in.nextInt() - 1);
			}
		}
		
		out.close();
	}
	
	static class DisjointSet
	{
		int[] parent;
		int[] rank;
		int[] path;
		
		public DisjointSet(int n)
		{
			parent = new int[n];
			rank = new int[n];
			path = new int[n];
			
			for(int i = 0; i < parent.length; i++)
			{
				parent[i] = i;
			}
		}
		
		public int find(int x)
		{
			if(parent[x] != x)
			{
				parent[x] = find(parent[x]);
			}
			
			return parent[x];
		}
		
		public boolean union(int x, int y)
		{
			int a = find(x);
			int b = find(y);
			
			if(a == b)
			{
				return false;
			}
			else
			{
				int newPath = Math.max(path[a], Math.max(path[b], ((path[a] + 1) / 2) + ((path[b] + 1) / 2) + 1));
				
				if(rank[a] < rank[b])
				{
					parent[a] = b;
					path[b] = newPath;
				}
				else if(rank[a] > rank[b])
				{
					parent[b] = a;
					path[a] = newPath;
				}
				else
				{
					parent[b] = a;
					path[a] = newPath;
					rank[a]++;
				}
				
				return true;
			}
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
