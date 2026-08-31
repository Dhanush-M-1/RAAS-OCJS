import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class A {

	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		char[][] t = new char[3][];
		int[][] f = new int[3][26];
		for(int i = 0; i < 3; ++i)
		{
			t[i] = sc.next().toCharArray();
			f[i] = freqArray(t[i]);
		}

		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int c1 = countMax(f[0], freqArray(t[1]));
			int c2 = countMax(f[0], freqArray(t[2]));
			if(c1 + c2 == 0)
				break;
			
			if(c1 > c2)
				add(sb, f[0], t[1]);
			else
				add(sb, f[0], t[2]);
		}
		for(int i = 0; i < 26; ++i)
			while(f[0][i]-->0)
				sb.append((char) (i + 'a'));
		out.println(sb);
		out.flush();
		out.close();
	}

	static int[] freqArray(char[] s)
	{
		int[] f = new int[26];
		for(char c: s)
			f[c-'a']++;
		return f;
	}

	static void add(StringBuilder sb, int[] f, char[] t)
	{

		for(char c: t)
		{
			f[c-'a']--;
			sb.append(c);
		}
	}

	static int countMax(int[] x, int[] y)
	{
		int max = Integer.MAX_VALUE;
		for(int i = 0; i < 26; ++i)
			if(y[i] != 0)
				max = Math.min(x[i] / y[i], max);
		return max;
	}

	static int compare(int[] x, int[] y)
	{
		int cmp = 0;
		for(int i = 0; i < 26; ++i)
			if(x[i] > y[i])
				if(cmp == 1) { cmp = 0; break; }
				else cmp = -1;
			else if(x[i] < y[i])
				if(cmp == -1) { cmp = 0; break; }
				else cmp = 1;
		return cmp;
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public Scanner(FileReader r){	br = new BufferedReader(r);}

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