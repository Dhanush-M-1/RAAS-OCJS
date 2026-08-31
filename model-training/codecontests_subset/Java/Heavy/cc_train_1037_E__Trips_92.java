import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args)
	{
		FastReader reader = new FastReader();
		PrintWriter writer = new PrintWriter(System.out);

		int n = reader.nextInt();
		int m = reader.nextInt();
		int k = reader.nextInt();

		Node[] graph = new Node[n];
		for (int i=0; i<n; i++)
			graph[i] = new Node();

		int[][] edges = new int[m][2];
		int[] ans = new int[m];

		for (int i=0; i<m; i++)
		{
			edges[i][0] = reader.nextInt()-1;
			edges[i][1] = reader.nextInt()-1;

			graph[edges[i][0]].list.add(edges[i][1]);
			graph[edges[i][1]].list.add(edges[i][0]);
		}

		Set<Integer> set = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i=0; i<n; i++)
		{
			set.add(i);
			if (graph[i].list.size() < k)
			{
				q.add(i);
				set.remove(i);
			}
		}

		for (int i=m-1; i>=0; i--)
		{
			while (!q.isEmpty())
			{
				int u = q.remove();
				//set.remove(u);

				for (int v : graph[u].list)
					if (set.contains(v))
					{
						graph[v].list.remove(u);
						if (graph[v].list.size() < k)
						{
							q.add(v);
							set.remove(v);
						}
					}	
			}

			ans[i] = set.size();

			int u = edges[i][0];
			int v = edges[i][1];

			if (set.contains(u) && set.contains(v))
			{
				graph[v].list.remove(u);
				graph[u].list.remove(v);

				if (graph[u].list.size() < k)
				{
					q.add(u);
					set.remove(u);
				}
				if (graph[v].list.size() < k)
				{
					q.add(v);
					set.remove(v);
				}
			}
		}

		for (int i=0; i<m; i++)
			writer.println(ans[i]);

		writer.close();
	}

	static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next()
		{
			while (st == null || !st.hasMoreElements())
			{
				try
				{
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt()
		{
			return Integer.parseInt(next());
		}

		long nextLong()
		{
			return Long.parseLong(next());
		}

		double nextDouble()
		{
			return Double.parseDouble(next());
		}

		String nextLine()
		{
			String str = "";
			try
			{
				str = br.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			return str;
		}
	}
}

class Node
{
	boolean was = false;
	Set<Integer> list = new HashSet<Integer>();
}