import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class B {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		String x = sc.next(), y = sc.next();
		int n = sc.nextInt();
		out.println(x + " " + y);
		while(n-->0)
		{
			String z = sc.next(), r = sc.next();
			if(z.equals(x))
				x = r;
			else
				y = r;
			out.println(x + " " + y);
		}
		out.close();
	}

	static class Scanner
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public Scanner(FileReader s) throws FileNotFoundException {	br = new BufferedReader(s);}

		public String next() throws IOException
		{
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException { return Double.parseDouble(next()); }

		public boolean ready() throws IOException {return br.ready();}
	}
}