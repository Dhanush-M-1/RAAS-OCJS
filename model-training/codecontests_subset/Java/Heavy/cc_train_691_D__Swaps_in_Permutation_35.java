import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class D {

	static Queue<Integer>[] adjList;
	static boolean[] visited;
	
	static ArrayList<Integer> bfs(int u)
	{
		ArrayList<Integer> ret = new ArrayList<Integer>();
		visited[u] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);
		while(!q.isEmpty())
		{
			u = q.remove();
			ret.add(u);
			for(int v: adjList[u])
				if(!visited[v])
				{
					visited[v] = true;
					q.add(v);
				}
		}
		return ret;
	}
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt(), m = sc.nextInt();
		int[] p = new int[n];
		for(int i = 0; i < n; ++i)
			p[i] = sc.nextInt();
		adjList = new Queue[n];
		for(int i = 0; i < n; ++i)
			adjList[i] = new LinkedList<Integer>();
		while(m-->0)
		{
			int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
		visited = new boolean[n];
		for(int i = 0; i < n; ++i)
			if(!visited[i])
			{
				ArrayList<Integer> idx = bfs(i);
				Integer[] val = new Integer[idx.size()];
				for(int j = 0; j < val.length; ++j)
					val[j] = p[idx.get(j)];
				Arrays.sort(val);
				Collections.sort(idx);
				for(int j = 0; j < val.length; ++j)
					p[idx.get(j)] = val[val.length - j - 1];
			}
		StringBuilder sb = new StringBuilder();
		for(int x: p)
			sb.append(x + " ");
		out.println(sb);
		out.flush();
		out.close();
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){    br = new BufferedReader(new InputStreamReader(s));}

		public Scanner(FileReader r){    br = new BufferedReader(r);}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}

		public boolean ready() throws IOException {return br.ready();}


	}
}