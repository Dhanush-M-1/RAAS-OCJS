import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P920E
{
	static HashSet<Integer>[] g;
	public static void main(String[] args)
	{
		FastScanner scan = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int n = scan.nextInt();
		int m = scan.nextInt();
		g = new HashSet[n];
		for (int i = 0; i < n; i++)
			g[i] = new HashSet<>();
		for (int i = 0; i < m; i++)
		{
			int a = scan.nextInt()-1;
			int b = scan.nextInt()-1;
			g[a].add(b);
			g[b].add(a);
		}
		int min = Integer.MAX_VALUE;
		int v = -1;
		for (int i = 0; i < n; i++)
		{
			if (g[i].size() < min)
			{
				min = g[i].size();
				v = i;
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int x : g[v])
			list.add(x);
		boolean[] vis = new boolean[n];
		ArrayList<Integer> comps = new ArrayList<>();
		int main = n-list.size();
		for (int i = 0; i < list.size(); i++)
		{
			int vert = list.get(i);
			if (vis[vert])
				continue;
			vis[vert] = true;
			ArrayDeque<Integer> ad = new ArrayDeque<>();
			ad.add(vert);
			boolean samecomp = false;
			int size = 0;
			while (!ad.isEmpty())
			{
				int p = ad.poll();
				size++;
				HashSet<Integer> here = g[p];
				int conn = 0;
				for (int j = 0; j < list.size(); j++)
				{
					int x = list.get(j);
					if (p == x)
						continue;
					if (!here.contains(x))
					{
						conn++;
						if (!vis[x])
							ad.add(x);
						vis[x] = true;
					}
				}
				if (conn+g[p].size() < n-1)
					samecomp = true;
			}
			if (samecomp)
				main += size;
			else
				comps.add(size);
		}
		comps.add(main);
		Collections.sort(comps);
		pw.println(comps.size());
		for (int i = 0; i < comps.size(); i++)
		{
			if (i > 0)
				pw.print(" ");
			pw.print(comps.get(i));
		}
		pw.println();
		pw.flush();
	}
	
	static class FastScanner
	{
		BufferedReader br;
		StringTokenizer st;

		public FastScanner()
		{
			try
			{
				br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine());
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		public String next()
		{
			if (st.hasMoreTokens())
				return st.nextToken();
			try
			{
				st = new StringTokenizer(br.readLine());
			} catch (Exception e)
			{
				e.printStackTrace();
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

		public String nextLine()
		{
			String line = "";
			try
			{
				line = br.readLine();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			return line;
		}
	}
}