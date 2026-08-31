import java.io.*;
import java.util.*;

public class E
{

	static void dfs(int u, int[] used, int avoid)
	{
		used[u] = comp;

		for (int v : adj.get(u))
		{
			if (used[v] != 0 || v == avoid)
				continue;
			
			dfs(v, used, avoid);
		}
	}

	static ArrayList<ArrayList<Integer>> adj;
	static int comp;

	static void solve(FastIO io)
	{
		int n = io.nextInt();
		int m = io.nextInt();

		int a = io.nextInt() - 1;
		int b = io.nextInt() - 1;
		
		adj = new ArrayList<>();

		int[] edges = new int[n];

		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<>());

		for (int i = 0; i < m; i++)
		{
			int u = io.nextInt() - 1;
			int v = io.nextInt() - 1;

			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		
		int[] compA = new int[n];

		comp = 1;
		for (int i = 0; i < n; i++)
			if (compA[i] == 0 && i != a)
			{
				dfs(i, compA, a);
				comp++;
			}

		int[] compB = new int[n];
		comp = 1;
		for (int i = 0; i < n; i++)
			if (compB[i] == 0 && i != b)
			{
				dfs(i, compB, b);
				comp++;
			}

		long ttlA = 0, ttlB = 0;

		for (int i = 0; i < n; i++)
		{
			if (i == a || i == b)
				continue;

			if (compA[i] != compA[b])
				ttlA++;

			if (compB[i] != compB[a])
				ttlB++;
		}

		io.println(ttlA * ttlB);
	}

	public static void main(String[] args) {
		FastIO io = new FastIO();
		int max = (int)1e9 + 1;



		int t = io.nextInt();
		
		for (int i = 0; i < t; i++)
			solve(io);


		io.close();
	}
}

class FastIO extends PrintWriter
{
	BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer("");

	FastIO()
	{
		super(System.out);
	}

	public String next()
	{
		while (!st.hasMoreTokens())
		{
			try {
				st = new StringTokenizer(r.readLine());
			} catch (Exception e) {
				//TODO: handle exception
			}
		}
		return st.nextToken();
	}

	public int nextInt()
	{
		return Integer.parseInt(next());
	}

	public long nextLong()
	{
		return Long.parseLong(next());
	}

	public double nextDouble()
	{
		return Double.parseDouble(next());
	}
}
