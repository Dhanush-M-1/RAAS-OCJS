import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/* http://codeforces.com/problemset/problem/519/B */

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] x = new int[n];
		int[] y = new int[n-1];

		for(int i=0;i<n;i++) {
			x[i] = in.nextInt();
		}
		
		for(int i=0;i<n-1;i++) {
			y[i] = in.nextInt();
		}

		TreeMap<Integer, Integer> comp1 = new TreeMap<Integer, Integer>();
		TreeMap<Integer, Integer> comp2 = new TreeMap<Integer, Integer>();

		for(int i=0;i<n-2;i++)
		{
			int cur = in.nextInt();
			if(!comp1.containsKey(cur))
			{
				comp1.put(cur, 1);
				comp2.put(cur, 1);
			}
			else
			{
				comp1.put(cur, comp1.get(cur)+1);
				comp2.put(cur, comp2.get(cur)+1);
			}
		}

		int primero  = -1;
		int segundo = -1;

		for(int i=0;i<n-1;i++)
		{
			if(comp1.get(y[i])==null)
			{
				segundo = y[i];
				break;
			}
			comp1.put(y[i],comp1.get(y[i])-1);
			if(comp1.get(y[i]) == -1)
			{
				segundo = y[i];
				break;
			}
		}
		
		if(!comp2.containsKey(segundo))
			comp2.put(segundo, 1);
		else
			comp2.put(segundo, comp2.get(segundo)+1);
		
		
		for(int i=0;i<n;i++)
		{
			if(comp2.get(x[i])==null)
			{
				primero = x[i];
				break;
			}
			comp2.put(x[i] ,  comp2.get(x[i])-1   );
			if(comp2.get(x[i]) == -1)
			{
				primero = x[i];
				break;
			}
		}
		System.out.println(primero);
		System.out.println(segundo);
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