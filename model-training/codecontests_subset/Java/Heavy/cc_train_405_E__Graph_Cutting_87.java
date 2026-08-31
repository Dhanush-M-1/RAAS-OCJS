import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class C {

	static final int UNVISITED = 0, VISITED = 1, EXPLORED = 2;
	static ArrayList<Integer>[] adjList;
	static ArrayList<Triple> ans;
	static int[] dfs_state;
	
	static int dfs(int u)
	{
		dfs_state[u] = EXPLORED;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int v: adjList[u])
			if(dfs_state[v] == UNVISITED)
			{
				int z = dfs(v);
				if(z == 0)
					q.add(v);
				else
					ans.add(new Triple(u, v, z));
			}
			else
				if(dfs_state[v] == VISITED)
					q.add(v);
		int z = 0;
		while(!q.isEmpty())
		{
			int v = q.remove();
			if(q.isEmpty())
				z = v;
			else
				ans.add(new Triple(v, u, q.remove()));
		}
		dfs_state[u] = VISITED;
		return z;
	}
	
    public static void main(String[] args) throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt(), m = sc.nextInt();
        
        if(m%2 == 1)
        	out.println("No solution");
        else
        {
        	adjList = new ArrayList[n + 1];
        	for(int i = 1; i <= n; ++i)
        		adjList[i] = new ArrayList<Integer>();
        	for(int i = 0; i < m; ++i)
        	{
        		int u = sc.nextInt(), v = sc.nextInt();
        		adjList[u].add(v);
        		adjList[v].add(u);
        	}
        	
        	ans = new ArrayList<Triple>(m>>1);
        	dfs_state = new int[n + 1];
        	dfs(1);
        	for(Triple t: ans)
        		out.println(t);
        }
        out.flush();
        out.close();
    }
    
    static class Triple
    {
    	int x, y, z;
    	
    	Triple(int a, int b, int c) { x = a; y = b; z = c; }
    	
    	public String toString() { return x + " " + y + " " + z; }
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