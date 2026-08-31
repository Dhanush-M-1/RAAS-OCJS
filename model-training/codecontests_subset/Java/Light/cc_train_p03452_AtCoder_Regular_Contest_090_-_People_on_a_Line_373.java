import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
static ArrayList<edge> []adj;
static boolean []visited;
static int []dist;
public static boolean dfs(int u,int d)
{
	visited[u]=true;
	boolean ans=true;
	dist[u]=d;
	for(edge e:adj[u])
		if(visited[e.v])
			ans&=dist[e.v]==d+e.w;
		else
			ans &=dfs(e.v,d+e.w);
	return ans;
}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		adj=new ArrayList[n];
		visited=new boolean[n];
		dist=new int [n];
		
		for(int i=0;i<n;i++)
			adj[i]=new ArrayList();
		while(m-->0)
		{
			int u=sc.nextInt()-1,v=sc.nextInt()-1,w=sc.nextInt();
			adj[u].add(new edge(v,w));
			adj[v].add(new edge(u,-w));
			
		}
		boolean ans=true;
		for(int i=0;i<n;i++)
			if(!visited[i])
				ans&=dfs(i,0);
		System.out.println(ans?"Yes":"No");

	}
	static class edge
	{
		int v,w;
		edge(int a,int b)
		{
			v=a;w=b;
		}
	}
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		public Scanner(InputStream S)
		{
			br=new BufferedReader(new InputStreamReader(S));
		}
		public String nextLine() throws IOException
		{
			return br.readLine();
		}
		public String next()  throws IOException
		{
			while(st==null || !st.hasMoreTokens())
				st=new StringTokenizer(nextLine());
			return st.nextToken();
		}
		public int nextInt()  throws IOException
		{
			return Integer.parseInt(next());
		}
		public double nextDouble()  throws IOException
		{
			return Double.parseDouble(next());
		}
		public boolean ready() throws IOException
		{
			return br.ready();
		}
	}
}
