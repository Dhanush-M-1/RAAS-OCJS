import java.util.*;
import java.io.*;
public class a 
{
	public static void main(String[] arg) throws IOException
	{
		new a();
	}
	public a() throws IOException
	{
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String a = in.next();
		String b = in.next();
		String c = in.next();
		int[] freqa = new int[26];
		int[] freqb = new int[26];
		int[] freqc = new int[26];
		for(int i = 0; i < a.length(); i++)
		{
			freqa[a.charAt(i)-'a']++;
		}
		for(int i = 0; i < b.length(); i++)
		{
			freqb[b.charAt(i)-'a']++;
		}
		for(int i = 0; i < c.length(); i++)
		{
			freqc[c.charAt(i)-'a']++;
		}
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int op1 = Integer.MAX_VALUE;
			int op2 = Integer.MAX_VALUE;
			for(int i = 0; i < 26; i++)
			{
				if(freqb[i] > 0) op1 = Math.min(op1, freqa[i]/freqb[i]);
				if(freqc[i] > 0) op2 = Math.min(op2, freqa[i]/freqc[i]);
			}
			if(op1 == 0 && op2 == 0)
			{
				for(int i = 0; i < 26; i++)
				{
					while(freqa[i] > 0)
					{
						sb.append((char)(i+'a'));
						freqa[i]--;
					}
				}
				break;
			}
			else if(op1 >= op2)
			{
				sb.append(b);
				for(int i = 0; i < 26; i++)
				{
					freqa[i] -= freqb[i];
				}
			}
			else if(op2 >= op1)
			{
				sb.append(c);
				for(int i = 0; i < 26; i++)
				{
					freqa[i] -= freqc[i];
				}
			}
			
		}
		out.println(sb);
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
