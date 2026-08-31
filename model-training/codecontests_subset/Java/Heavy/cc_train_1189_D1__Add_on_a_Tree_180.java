import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	static final int MAX = 100100;
	static int n;
	static int[] deg = new int[MAX];
	
	public static void main (String[] args) throws java.lang.Exception
	{
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		
		n = in.nextInt();
		for(int i = 1; i < n; i++)
		{
			int v = in.nextInt();
			int u = in.nextInt();
			v--;
			u--;
			deg[v]++;
			deg[u]++;
		}
		
		for(int v = 0; v < n; v++)
		{
			if(deg[v] == 2)
			{
				out.println("NO");
				out.close();
				return;
			}
		}
		
		out.println("YES");
		out.close();
	}
	
	static class InputReader
	{
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		
		public InputReader(InputStream stream)
		{
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}
		
		public String next()
		{
			while(tokenizer == null || !tokenizer.hasMoreTokens())
			{
				try
				{
					tokenizer = new StringTokenizer(reader.readLine());
				}
				catch(IOException e)
				{
					throw new RuntimeException(e);
				}
			}
			
			return tokenizer.nextToken();
		}
		
		public int nextInt()
		{
			return Integer.parseInt(next());
		}
	}
}