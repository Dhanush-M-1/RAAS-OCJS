import java.util.*;
import java.io.*;

public class d
{
	public static void main(String[] arg) throws IOException
	{
		new d();
	}	
	public d() throws IOException
	{
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = in.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		HashSet<Integer>[] xList = new HashSet[100_001];
		HashSet<Integer>[] yList = new HashSet[100_001];
		int[] xCount = new int[100_001];
		int[] yCount = new int[100_001];
		for(int i = 0; i < n; i++)
		{
			x[i] = in.nextInt();
			y[i] = in.nextInt();
			xCount[x[i]]++;
			yCount[y[i]]++;
		}
		int[][] xl = new int[100_001][];
		int[][] yl = new int[100_001][];

		for(int i = 0; i <= 100_000; i++)
		{
			xl[i] = new int[xCount[i]];
			yl[i] = new int[yCount[i]];
			xCount[i] = 0;
			yCount[i] = 0;
		}
		for(int i = 0; i < n; i++)
		{
			if(xList[x[i]] == null) xList[x[i]] = new HashSet<Integer>();
			if(yList[y[i]] == null) yList[y[i]] = new HashSet<Integer>();
			xList[x[i]].add(y[i]);
			yList[y[i]].add(x[i]);
			xl[x[i]][xCount[x[i]]++] = y[i];
			yl[y[i]][yCount[y[i]]++] = x[i];
		}
		for(int i = 0; i <= 100_000; i++)
		{
			Arrays.sort(xl[i]);
			Arrays.sort(yl[i]);
		}
		long ans = 0;
		for(int i = 0; i < n; i++)
		{
			if(xl[x[i]].length <= yl[y[i]].length)
			{
				for(int v : xl[x[i]])
				{
					if(v >= y[i]) break;
					int dist = y[i]-v;
					if(x[i]-dist >= 0 && xList[x[i]-dist] != null && xList[x[i]-dist].contains(y[i]) && xList[x[i]-dist].contains(v))
					{
						ans++;
					}
				}
			}
			else
			{
				for(int v : yl[y[i]])
				{
					if(v >= x[i]) break;
					int dist = x[i]-v;
					if(y[i]-dist >= 0 && yList[y[i]-dist] != null && yList[y[i]-dist].contains(x[i]) && yList[y[i]-dist].contains(v))
					{
						ans++;
					}
				}
			}
		}

		out.println(ans);
		in.close(); out.close();
	}
	class FastScanner
	{
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(InputStream in)
		{
			br = new BufferedReader(new InputStreamReader(in));
			st = new StringTokenizer("");
		}
		public String next() throws IOException
		{
			while(!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public int nextInt() throws IOException
		{
			return Integer.parseInt(next());
		}
		public void close() throws IOException
		{
			br.close();
		}
	}
}
