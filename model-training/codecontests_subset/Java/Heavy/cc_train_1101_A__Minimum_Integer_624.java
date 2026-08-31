import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner("out");
		int q = sc.nextInt();
		while(q-->0)
		{
			int l = sc.nextInt() , r = sc.nextInt() , d= sc.nextInt();
			if(d<l || d>r)
			{
				System.out.println(d);
			}
			else
			{
				if(r%d==0)
				{
					System.out.println(r+d);
				}
				else
				{
					System.out.println(r+(d-r%d));
				}
			}
		}
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public Scanner(String file) throws FileNotFoundException { br = new BufferedReader(new FileReader(file));}
		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens())st = new StringTokenizer(br.readLine());
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
			if(x.charAt(0) == '-'){neg = true;start++;}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else{sb.append(x.charAt(i));if(dec)f *= 10;}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		public int[] nexIntArray() throws Throwable
		{
			st = new StringTokenizer(br.readLine());
			int[] a = new int[st.countTokens()];
			for(int i = 0; i < a.length;i++)a[i]=nextInt();
			return a;
		}
		public boolean ready() throws IOException {return br.ready();}
	}

}
