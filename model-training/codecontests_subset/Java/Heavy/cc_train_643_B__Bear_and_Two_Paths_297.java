import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BearAndTwoPaths
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		if(k < n+1 || n == 4)
		{
			System.out.println(-1);
			return;
		}
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		int[] route1 = new int[n];
		int[] route2 = new int[n];
		route1[0] = a;
		route1[n-1] = b;
		route1[1] = c;
		route1[n-2] = d;
		int start = 1;
		for (int i = 1; i < route1.length-1; i++)
		{
			if(route1[i] != 0)
				continue;
			if(start != a && start != b && start != c && start != d)
				route1[i] = start;
			else
			{
				i--;
			}
			start++;
		}
		
		int swap = 0;
		for (int i = 0; i < n; i++)
		{
			if(route1[i] != a && route1[i] != b && route1[i] != c && route1[i] != d)
			{
				swap = i;
				break;
			}
		}
		
		for (int i = 0; i < route1.length-1; i++)
		{
			if(route1[i] == c && route1[i+1] == d)
			{
				route1[i+1] = route1[swap];
				route1[swap] = d;
				break;
			}
			
			if(route1[i] == d && route1[i+1] == c)
			{
				route1[i+1] = route1[swap];
				route1[swap] = c;
				break;
			}
		}
		
		route2[0] = c;
		route2[n-1] = d;
		
		int ind = 0;
		for (int i = 0; i < route1.length; i++)
		{
			if(route1[i] == c)
			{
				ind = i;
				break;
			}
		}

		boolean left = false;
		for (int i = ind; i >= 0; i--)
		{
			if(route1[i] == d)
				left = true;
		}
		
		if(left)
		{
			int put = 1;
			for (int i = ind+1; i < n; i++)
			{
				route2[put++] = route1[i];
			}
			
			for (int i = ind-1;; i--)
			{
				if(route1[i] == d)
					break;
				route2[put++] = route1[i];
			}
			
			for (int i = 0;; i++)
			{
				if(route1[i] == d)
					break;
				route2[put++] = route1[i];
			}
		}
		else
		{
			int put = 1;
			for (int i = ind-1; i >= 0; i--)
			{
				route2[put++] = route1[i];
			}
			
			for (int i = ind+1;; i++)
			{
				if(route1[i] == d)
					break;
				route2[put++] = route1[i];
			}
			
			for (int i = route1.length-1;; i--)
			{
				if(route1[i] == d)
					break;
				route2[put++] = route1[i];
			}
		}
		PrintWriter pw = new PrintWriter(System.out);
		for (int i = 0; i < route1.length; i++)
		{
			pw.print(route1[i]);
			if(i != route1.length-1)
				pw.print(" ");
		}
		pw.println();
		for (int i = 0; i < route2.length; i++)
		{
			pw.print(route2[i]);
			if(i != route2.length-1)
				pw.print(" ");
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
