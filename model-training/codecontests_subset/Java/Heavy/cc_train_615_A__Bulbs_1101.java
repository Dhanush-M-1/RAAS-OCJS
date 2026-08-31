//package template;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		InputStream inputStream = System.in;//new FileInputStream("input.txt");
		OutputStream outputStream = System.out;//new FileOutputStream("output.txt");
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		//////////////////////////////////////////////////////////////////////////////
		TaskC solver = new TaskC();
		solver.solve(in, out);
		//////////////////////////////////////////////////////////////////////////////
		out.close();
	}

	static class TaskC
	{
		int n,m,tmp;
		Set<Integer> onBulbs = new HashSet<Integer>();
		
		void solve(InputReader in, PrintWriter out)
		{
			n = in.nextInt();
			m = in.nextInt();
			for(int i=0; i<n; i++)
			{
				tmp = in.nextInt();
				for(int j=0; j<tmp; j++)
				{
					onBulbs.add(in.nextInt());
				}
			}
			if(onBulbs.size()<m)
				out.println("NO");
			else
				out.println("YES");
		    
		}
	}

	static class InputReader
	{
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream)
		{
			reader = new  BufferedReader(new InputStreamReader(stream));
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
					e.printStackTrace();
				}
			}
			return tokenizer.nextToken();
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
			String str = "";
			try
			{
				str = reader.readLine();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			return str;
		}
	}

	

}
