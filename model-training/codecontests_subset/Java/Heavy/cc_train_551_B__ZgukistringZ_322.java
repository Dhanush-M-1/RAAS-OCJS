import java.util.*;
import java.io.*;
public class ZgukistringZ
{
	public static void main(String[] args) throws Exception
	{
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		String a = in.next();
		String b = in.next();
		String c = in.next();
		
		int[] af = convert(a);
		int[] bf = convert(b);
		int[] cf = convert(c);
		
		int max = calc(af, bf);
		int best = 0;
		int bs = 0;
		int cs = 0;
		for(int x = 0; x <= max; x++)
		{
			int current = calc(af, cf);
			
			if(x + current > best)
			{
				best = x + current;
				bs = x;
				cs = current;
			}
			
			for(int i = 0; i < af.length; i++)
			{
				af[i] -= bf[i];
			}
		}
		
		int[] freq = convert(a);
		
		StringBuilder sb = new StringBuilder();
		
		for(int y = 0; y < bs; y++)
		{
			sb.append(b);
			
			for(int i = 0; i < freq.length; i++)
			{
				freq[i] -= bf[i];
			}
		}
		
		for(int z = 0; z < cs; z++)
		{
			sb.append(c);
			
			for(int i = 0; i < freq.length; i++)
			{
				freq[i] -= cf[i];
			}
		}
		
		for(int d = 0; d < freq.length; d++)
		{
			for(int e = 0; e < freq[d]; e++)
			{
				sb.append((char)('a' + d));
			}
		}
		
		out.println(sb);
		out.close();
	}
	
	public static int calc(int[] freq, int[] str)
	{
		int ret = Integer.MAX_VALUE;
		for(int x = 0; x < str.length; x++)
		{
			if(str[x] != 0)
			{
				ret = Math.min(ret, freq[x] / str[x]);
			}
		}
		
		return ret;
	}
	
	public static int[] convert(String s)
	{
		int[] ret = new int[26];
		for(int x = 0; x < s.length(); x++)
		{
			ret[s.charAt(x) - 'a']++;
		}
		
		return ret;
	}
	
	static class FastScanner
	{
		BufferedReader br;
		StringTokenizer st;
		
		public FastScanner(InputStream input)
		{
			br = new BufferedReader(new InputStreamReader(input));
			st = new StringTokenizer("");
		}
		
		public String next() throws IOException
		{
			if(st.hasMoreTokens())
			{
				return st.nextToken();
			}
			else
			{
				st = new StringTokenizer(br.readLine());
				return next();
			}
		}
		
		public int nextInt() throws IOException
		{
			return Integer.parseInt(next());
		}
	}
}
