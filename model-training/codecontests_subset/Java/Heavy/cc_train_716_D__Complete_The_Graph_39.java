import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class A {

	static final long INF = (long)1e18;

	static long[] dijkstra(int S, int N, ArrayList<Edge>[] adjList)
	{
		long[] D = new long[N];
		Arrays.fill(D, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		D[S] = 0;
		pq.add(new Edge(S, 0));
		while(!pq.isEmpty())
		{
			Edge cur = pq.remove();
			if(cur.cost > D[cur.node])
				continue;
			for(Edge nxt: adjList[cur.node])
			{
				long totalCost = cur.cost + Math.max(nxt.cost, 1);
				if(totalCost < D[nxt.node])
					pq.add(new Edge(nxt.node, D[nxt.node] = totalCost));
			}
		}
		return D;
	}

	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int N = sc.nextInt(), M = sc.nextInt(), L = sc.nextInt(), S = sc.nextInt(), T = sc.nextInt();
		ArrayList<Edge>[] adjList = new ArrayList[N];
		for(int i = 0; i < N; ++i)
			adjList[i] = new ArrayList<>(1);
		long[][] adjMat = new long[N][N];
		for(long[] x: adjMat)
			Arrays.fill(x, -1);
		while(M-->0)
		{
			int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
			adjList[u].add(new Edge(v, w));
			adjList[v].add(new Edge(u, w));
			adjMat[u][v] = adjMat[v][u] = w;
		}
		long[] dist = dijkstra(S, N, adjList);
		if(dist[T] == -1 || dist[T] > L)
			out.println("NO");
		else
		{
			PriorityQueue<Edge> pq = new PriorityQueue<>(new Comp());
			if(dist[T] < L)
			{
				pq.add(new Edge(T, L));
				dist[T] = L;
			}
			boolean good = true;
			while(!pq.isEmpty())
			{
				Edge cur = pq.remove();
				if(cur.node == S)
					good = false;
				if(cur.cost != dist[cur.node])
					continue;
				for(Edge nxt: adjList[cur.node])
					if(dist[nxt.node] + Math.max(nxt.cost, 1) < cur.cost)
						if(nxt.cost == 0)
							adjMat[cur.node][nxt.node] = adjMat[nxt.node][cur.node] = cur.cost - dist[nxt.node];
						else
							pq.add(new Edge(nxt.node, dist[nxt.node] = cur.cost - nxt.cost));
			}
			if(!good)
				out.println("NO");
			else
			{
				out.println("YES");
				for(int i = 0; i < N; ++i)
					for(int j = i + 1; j < N; ++j)
						if(adjMat[i][j] != -1)
							out.printf("%d %d %d\n", i, j, Math.max(adjMat[i][j], 1));
			}
		}
		out.flush();
		out.close();
	}

	static class Edge implements Comparable<Edge>
	{
		int node;
		long cost;

		Edge(int a, long b) { node = a; cost = b; }

		public int compareTo(Edge e)
		{
			if(cost != e.cost)
				return cost > e.cost ? 1 : -1;
				return node - e.node;
		}
	}
	
	static class Comp implements Comparator<Edge>
	{
		public int compare(Edge e1, Edge e2)
		{
			if(e1.cost != e2.cost)
				return e1.cost > e2.cost ? -1 : 1;
			return e1.node - e2.node;
		}
	}

	static class Scanner 
	{
		StringTokenizer st;	
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException { return Double.parseDouble(next()); }
	}
}