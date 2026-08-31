import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D
{
	static long BIG = (long)1e13;
	static int ASONE = 2, ASBIG = 1, NOTUSED = 0; 
	static void dijkstra(ArrayList<Integer>[] adj, long[][] adjm, int[] from, long[] cost, int useBig, int s)
	{
		PriorityQueue<Long> pq = new PriorityQueue<>();
		pq.add(0L+s);
		cost[s] = 0;
		boolean[] isDone = new boolean[adj.length];
		while (!pq.isEmpty())
		{
			long p = pq.poll();
			int v = (int)(p%1000);
			long c = p/1000;
			if (isDone[v]) continue;
			//System.out.printf("Looking at %d with cost %d, %d\n", v,c,useBig);
			isDone[v] = true;
			for (int i = 0; i < adj[v].size(); ++i)
			{
				int vv = adj[v].get(i);
				long cc = adjm[v][vv];
				boolean isBig = cc == BIG;
				if (isBig && useBig == NOTUSED) continue;
				long newCost = isBig ? c+(useBig==ASONE?1:BIG) : c + cc;
				if (cost[vv] == -1 || newCost < cost[vv]) {
					cost[vv] = newCost;
					from[vv] = v;
					//System.out.printf("Updating cost of %d to %d, %d\n", vv, newCost, useBig);
					pq.add(1000*newCost+vv);
				}
			}
		}

	}
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer toks = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(toks.nextToken());
		int m = Integer.parseInt(toks.nextToken());
		int L = Integer.parseInt(toks.nextToken());
		int s = Integer.parseInt(toks.nextToken());
		int t = Integer.parseInt(toks.nextToken());
		ArrayList<Integer>[] adj = new ArrayList[n]; 
		long[][] adjm = new long[n][n];
		for (int i = 0; i < n; ++i) Arrays.fill(adjm[i], -1);
		for (int i = 0; i < n; ++i) adj[i] = new ArrayList<Integer>();
		for (int i = 0; i < m; ++i)
		{
			toks = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(toks.nextToken());
			int v = Integer.parseInt(toks.nextToken());
			int w = Integer.parseInt(toks.nextToken());
			adj[u].add(v);
			adj[v].add(u);
			adjm[u][v] = w == 0 ? BIG : (long)w;
			adjm[v][u] = w == 0 ? BIG : (long)w;
		}
		int[] from = new int[n];
		long[] cost = new long[n];
		Arrays.fill(from,-1); Arrays.fill(cost, -1);		
		dijkstra(adj, adjm, from, cost, ASONE, s);
		if (cost[t] > L || cost[t] == -1) { System.out.println("NO"); return; }
		Arrays.fill(from,-1); Arrays.fill(cost, -1);		
		dijkstra(adj, adjm, from, cost, ASBIG, s);
		if (cost[t] != -1 && cost[t] < L) { System.out.println("NO"); return; }
		outer: for (int i = 0; i < adj.length; ++i) 
			for (int j = 0; j < adj[i].size(); ++j)
			{
				int v = adj[i].get(j);
				if (adjm[i][v] != BIG) continue;
				adjm[i][v] = adjm[v][i] = 1;
				Arrays.fill(from,-1); Arrays.fill(cost, -1);		
				dijkstra(adj, adjm, from, cost, ASBIG, s);
				if (cost[t] != -1 && cost[t] <= L) { adjm[i][v] = adjm[v][i] += L-cost[t]; break outer; } 
			}
		printGraph(adj,adjm);
	}

	static void printGraph(ArrayList<Integer>[] adj, long[][] adjm)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("YES\n");
		for (int i = 0; i < adj.length; ++i)
		{
			for (int j = 0; j < adj[i].size(); ++j)
			{
				int v = adj[i].get(j);
				if (v > i) continue;
				sb.append(i).append(' ').append(v).append(' ').append(adjm[i][v]).append('\n');
			}
		}
		System.out.print(sb);
	}
}
