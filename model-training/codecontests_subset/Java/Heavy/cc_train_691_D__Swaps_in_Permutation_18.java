import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;



public class Problem4 {

	static ArrayList<Integer> pos;
	static ArrayList<Integer> cur;
	static ArrayList<Integer>[] adj;
	static int[] p;
	static boolean[] vis;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		int n = in.nextInt();
		int m = in.nextInt();
		p = new int[n];
		adj = new ArrayList[n];
		vis = new boolean[n];
		int[] ans = new int[n];
		for(int i = 0; i < n; ++i)
		{
			p[i] = in.nextInt();
			adj[i] = new ArrayList<Integer>();
		}
		
		int a, b;
		for(int i = 0; i < m; ++i)
		{
			a = in.nextInt() - 1;
			b = in.nextInt() - 1;
			adj[a].add(b);
			adj[b].add(a);
		}
		for(int i = 0; i < n; ++i)
		{
			if(!vis[i])
			{
				pos = new ArrayList<Integer>();
				cur = new ArrayList<Integer>();
				dfs(i);
				Collections.sort(cur);
				Collections.reverse(cur);
				Collections.sort(pos);
				for(int j = 0; j < pos.size(); ++j)
				{
					ans[pos.get(j)] = cur.get(j);
				}
			}
		}
		
		for(int i = 0 ; i < n; ++i)
		{
			out.print(ans[i] + " ");
		}

		out.close();
	}
	
	static void dfs(int v)
	{
		vis[v] = true;
		pos.add(v);
		cur.add(p[v]);
		for(Integer ver:adj[v])
		{
			if(!vis[ver])
				dfs(ver);
		}
	}
	


	
	
	
	
	static class InputReader {
	    public BufferedReader reader;
	    public StringTokenizer tokenizer;

	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream), 32768);
	        tokenizer = null;
	    }

	    public String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	            try {
	                tokenizer = new StringTokenizer(reader.readLine());
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return tokenizer.nextToken();
	    }

	    public int nextInt() {
	        return Integer.parseInt(next());
	    }
	    
	    public long nextLong()
	    {
	    	return Long.parseLong(next());
	    }

	}


}

