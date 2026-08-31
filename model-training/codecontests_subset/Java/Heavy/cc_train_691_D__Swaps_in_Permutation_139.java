import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 public class _691D {

 }

 */

public class _691D
{
	class dsu
	{
		int[] p;
		int[] r;
		int[] P;

		public dsu(int[] p, int[] r, int[] P)
		{
			this.p = p;
			this.r = r;
			this.P = P;
		}

		int findSet(int x)
		{
			if (x != P[x])
			{
				P[x] = findSet(P[x]);
			}

			return P[x];
		}

		void union(int x, int y)
		{
			int fsx = findSet(x);
			int fsy = findSet(y);

			int rx = r[fsx];
			int ry = r[fsy];

			if (rx < ry)
			{
				P[fsx] = fsy;
			}
			else if (ry < rx)
			{
				P[fsy] = fsx;
			}
			else
			{
				P[fsy] = fsx;
				r[fsx]++;
			}
		}
	}

	public void solve() throws FileNotFoundException
	{
		InputStream inputStream = System.in;

		InputHelper inputHelper = new InputHelper(inputStream);

		PrintStream out = System.out;

		// actual solution
		int n = inputHelper.readInteger();

		int m = inputHelper.readInteger();

		int[] p = new int[n + 1];
		int[] r = new int[n + 1];
		int[] P = new int[n + 1];

		for (int i = 1; i <= n; i++)
		{
			p[i] = inputHelper.readInteger();
			P[p[i]] = p[i];
		}

		dsu dsu = new dsu(p, r, P);

		for (int i = 0; i < m; i++)
		{
			int a = inputHelper.readInteger();
			int b = inputHelper.readInteger();

			int fsa = dsu.findSet(a);
			int fsb = dsu.findSet(b);

			if (fsa != fsb)
			{
				dsu.union(fsa, fsb);
			}
		}

		HashMap<Integer, PriorityQueue<Integer>> mi = new HashMap<Integer, PriorityQueue<Integer>>();
		HashMap<Integer, PriorityQueue<Integer>> mn = new HashMap<Integer, PriorityQueue<Integer>>();

		for (int i = 1; i <= n; i++)
		{
			int fsi = dsu.findSet(i);

			if (!mi.containsKey(fsi))
			{
				mi.put(fsi, new PriorityQueue<Integer>());
				mn.put(fsi, new PriorityQueue<Integer>((a, b) -> b - a));
			}

			mi.get(fsi).add(i);
			mn.get(fsi).add(p[i]);
		}

		int[] pa = new int[n + 1];

		for (Integer i : mi.keySet())
		{
			PriorityQueue<Integer> tsi = mi.get(i);
			PriorityQueue<Integer> tsn = mn.get(i);

			// tsi.sort((a, b) -> a - b);
			// tsn.sort((a, b) -> b - a);

			while (!tsi.isEmpty())
			{
				pa[tsi.poll()] = tsn.poll();
			}
		}

		StringBuilder ans = new StringBuilder();
		for (int i = 1; i <= n; i++)
		{
			ans.append(pa[i]);
			ans.append(" ");
		}

		System.out.println(ans.toString());
		// end here
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		(new _691D()).solve();
	}

	class InputHelper
	{
		StringTokenizer tokenizer = null;
		private BufferedReader bufferedReader;

		public InputHelper(InputStream inputStream)
		{
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream);
			bufferedReader = new BufferedReader(inputStreamReader, 16384);
		}

		public String read()
		{
			while (tokenizer == null || !tokenizer.hasMoreTokens())
			{
				try
				{
					String line = bufferedReader.readLine();
					if (line == null)
					{
						return null;
					}
					tokenizer = new StringTokenizer(line);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}

			return tokenizer.nextToken();
		}

		public Integer readInteger()
		{
			return Integer.parseInt(read());
		}

		public Long readLong()
		{
			return Long.parseLong(read());
		}
	}
}