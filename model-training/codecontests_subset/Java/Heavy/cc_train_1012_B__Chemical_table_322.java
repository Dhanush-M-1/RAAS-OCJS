import java.util.*;
import java.io.*;

public class Main
{
	static Dsu[] array;

	public static void main(String[] args)
	{
		FastReader reader = new FastReader();
		PrintWriter writer = new PrintWriter(System.out);

		int n = reader.nextInt();
		int m = reader.nextInt();
		int q = reader.nextInt();

		array = new Dsu[n];
		for (int i=0; i<n; i++)
			array[i] = new Dsu(i);

		int[] last = new int[m];
		Arrays.fill(last, -1);
		boolean[] cols = new boolean[m];

		while (q > 0)
		{
			int r = reader.nextInt()-1;
			int c = reader.nextInt()-1;

			if (last[c] != -1)
			{
				union(r, last[c]);
				//writer.println (" match " + r + " " + last[c]);
			}

			last[c] = r;
			cols[c] = true;
			q--;
		}

		boolean[] rows = new boolean[n];
		for (int i=0; i<n; i++)
			rows[findRoot(i)] = true;

		int count=0;
		for (int i=0; i<n; i++)
		{
			if (rows[i])
				count++;
		}
		//writer.println(count + " rows");

		for (int i=0; i<m; i++)
		{
			if (!cols[i])
				count++;
		}

		//writer.println(count + " cols");

		/*for (int i=0; i<n; i++)
			writer.println(findRoot(i) + " parent");*/

		count--;
		writer.println(count);
		writer.close();
	}

	static int  findRoot(int u)
	{
		while (array[u].parent != u)
		{
			array[u].parent = array[array[u].parent].parent;
			u = array[u].parent;
		}

		return u;
	}

	static void union (int a, int b)
	{
		int rA = findRoot(a);
		int rB = findRoot(b);

		if (rA == rB)
			return;

		if (array[rA].size < array[rB].size)
		{
			array[rA].parent = rB;
			array[rB].size += array[rA].size;
		}
		else
		{
			array[rB].parent = rA;
			array[rA].size += array[rB].size;
		}
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

class Dsu
{
	int parent;
	int size;

	public Dsu(int p)
	{
		parent = p;
		size = 1;
	}
}