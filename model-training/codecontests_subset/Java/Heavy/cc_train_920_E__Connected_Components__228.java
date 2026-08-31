import java.util.*;
import java.io.*;
import java.math.BigInteger;
 
public class Main
{
	static final int mod = (int)1e9+7;
	static Set<Integer>[] adj;
	static TreeSet<Integer> unvis;
	static int[] com;
	public static void main(String[] args) throws Exception
	{
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int m = in.nextInt();
		adj = new Set[n + 1];
		Set<Integer> set = new HashSet();
		for(int i = 1; i <= n; i++)
		{
			adj[i] = new HashSet();
			set.add(i);
		}
		unvis = new TreeSet(set);
		while(m-- > 0)
		{
			int a = in.nextInt();
			int b = in.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		int c = 0;
		com = new int[n];
		for(int i = 1; i <= n; i++)
		{
			if(unvis.contains(i))
			{
				dfs(i, c);
				c++;
			}
		}
		Arrays.sort(com, 0, c);
		out.println(c);
		for(int i = 0; i < c; i++)
			out.print(com[i] + " ");
		out.flush();
	}

	static void dfs(int ind, int c)
	{
		unvis.remove(ind);
		com[c]++;
		int i = 0;

		while(true)
		{
		 	if(unvis.higher(i) == null)
		 		break;
		 	i = unvis.higher(i);
		 	if(adj[ind].contains(i))
		 		continue;
		 	dfs(i, c);
		}
	}
}
 
class FastReader
{
	BufferedReader br;
	StringTokenizer st;
 
	public FastReader()
	{
	    br = new BufferedReader(new InputStreamReader(System.in));
	}
 
	public String next() throws IOException
	{
	    if(st == null || !st.hasMoreElements())
	    {
	        st = new StringTokenizer(br.readLine());
	    }
	    return st.nextToken();
	}
 
	public int nextInt() throws IOException
	{
	    return Integer.parseInt(next());
	}
 
	public long nextLong() throws IOException
	{
	    return Long.parseLong(next());
	}
 
	public String nextLine() throws IOException
	{
		return br.readLine();
	}
}