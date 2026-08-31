import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ZgukistringZ
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		String as = sc.next();
		String bs = sc.next();
		String cs = sc.next();
		
		char[] a = as.toCharArray();
		char[] b = bs.toCharArray();
		char[] c = cs.toCharArray();
		
		int[] al = new int[26];
		int[] bl = new int[26];
		int[] cl = new int[26];
		
		for (int i = 0; i < a.length; i++)
			al[a[i]-'a']++;
		for (int i = 0; i < b.length; i++)
			bl[b[i]-'a']++;
		for (int i = 0; i < c.length; i++)
			cl[c[i]-'a']++;
		
		int numb = 1123456;
		for (int i = 0; i < 26; i++)
			if(bl[i] != 0)
				numb = Math.min(numb, al[i]/bl[i]);

		int max = 0;
		int mxb = 0;
		int mxc = 0;
		for (int i = 0; i <= numb; i++)
		{
			int maxc = 1123456;
			for (int j = 0; j < 26; j++)
				if(cl[j] != 0)
					maxc = Math.min(maxc, (al[j] - bl[j]*i)/cl[j]);
			maxc = Math.max(0, maxc);
			if(maxc + i > max)
			{
				mxc = maxc;
				mxb = i;
				max = maxc + i;
			}
		}
		PrintWriter pw = new PrintWriter(System.out);
		for (int i = 0; i < mxc; i++)
			pw.print(cs);
		for (int i = 0; i < mxb; i++)
			pw.print(bs);
		for (int i = 0; i < 26; i++)
		{
			int rem = al[i]-(mxc*cl[i])-(mxb*bl[i]);
			while(rem -- > 0)
				pw.print((char)(i + 'a'));
		}
		pw.println();
		pw.flush();
		pw.close();
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

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
