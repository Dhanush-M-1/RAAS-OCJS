import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main
{
	static InputStream inputStream = System.in;
	static OutputStream outputStream = System.out;
	static PrintWriter out = new PrintWriter(outputStream);
	static InputReader in = new InputReader(inputStream);
	
	static public class EDGE
	{
		int to,next;
		EDGE()
		{
		}
		EDGE(int x,int y)
		{
			to = x;
			next = y;
		}
	}
	
	static EDGE edge[];
	static int head[];
	static int edgecnt;
	static int ans[];
	static boolean vis[];
	static int idx[];
	static void init(int n,int m)
	{
		edge = new EDGE [m * 2];
		edgecnt = 0;
		head = new int [n + 1];
		Arrays.fill(head, 1,n + 1, -1);
		ans = new int [n + 1];
		vis = new boolean [n + 1];
		idx = new int [n + 1];
		
	}
	static void add(int s, int t)
	{
		edge[edgecnt] = new EDGE(t,head[s]);
		head[s] = edgecnt++;
	}
	static void bfs(int x)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		vis[x] = true;
		q.offer(x);
		List<Integer> num = new ArrayList<Integer>();
		List<Integer> index = new ArrayList<Integer>();
		while(!q.isEmpty())
		{
			x = q.poll();
			num.add(x);
			index.add(idx[x]);
			for(int i = head[x]; i!=-1; i = edge[i].next)
			{
				int v = edge[i].to;
				if(vis[v]) continue;
				vis[v] = true;
				q.offer(v);
			}
		}
		Collections.sort(num);
		Collections.sort(index);
		for(int i = 0; i < num.size(); i++)
			ans[index.get(num.size() - i - 1)] = num.get(i);	
	}
	public static void main(String[] args)
	{
		int n = Integer.parseInt(in.next());
		int m = Integer.parseInt(in.next());
		init(n, m);
		int a[] = new int [n+1];
		for(int i = 1; i <= n ;i++)
		{
			a[i] = Integer.parseInt(in.next());
			idx[a[i]] = i;
		}
		for(int i = 1; i <= m; i++)
		{
			int s = Integer.parseInt(in.next()), t = Integer.parseInt(in.next());
			s = a[s];
			t = a[t];
			add(s, t);
			add(t, s);
		}
		for(int i = 1; i <= n; i++)
			if(!vis[i]) bfs(i);
		for(int i = 1; i <= n; i++) out.println(ans[i]);
		out.close();
	}
	
	static class InputReader 
	{
        BufferedReader reader;
        StringTokenizer tokenizer;
        public InputReader(InputStream inputStream) 
        {
            reader = new BufferedReader(new InputStreamReader(inputStream), 32624);
            tokenizer = null;
        }
        public String next() 
        {
            while (tokenizer == null || !tokenizer.hasMoreTokens())
            {
                try 
                {
                	String line = reader.readLine();
                	if(line == null) 
                	{
                		out.close();
                		System.exit(0);
                	}
                    tokenizer = new StringTokenizer(line);
                } 
                catch (IOException ex)
                {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return tokenizer.nextToken();
        }
    }
}

 		 					 	  	  	  	 				   	 	