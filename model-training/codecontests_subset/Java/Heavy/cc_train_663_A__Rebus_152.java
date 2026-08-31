import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class A {

	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int n = (st.countTokens() - 1) / 2, val[] = new int[n];
		char[] sign = new char[n];
		Arrays.fill(val, 1);
		
		sign[0] = '+';
		for(int i = 1; i < n; ++i)
		{
			st.nextToken();
			sign[i] = st.nextToken().charAt(0);
		}
		st.nextToken(); st.nextToken();
		int sum = Integer.parseInt(st.nextToken()), cur = calc(n, val, sign);
		boolean possible = saturate(n, val, sign, sum - cur, sum);
		if(possible)
		{
			out.printf("Possible\n%d", val[0]);
			for(int i = 1; i < n; ++i)
				out.printf(" %c %d", sign[i], val[i]);
			out.printf(" %c %d\n", '=', sum);
		}
		else
			out.println("Impossible");
		out.flush();
		out.close();
	}
	
	static int calc(int n, int[] val, char[] sign)
	{
		int ret = 0;
		for(int i = 0; i < n; ++i)
			if(sign[i] == '+')
				ret += val[i];
			else
				ret -= val[i];
		return ret;
	}
	
	static boolean saturate(int n, int[] val, char[] sign, int rem, int max)
	{
		for(int i = 0; rem != 0 && i < n; ++i)
		{
			int diff = 0;
			if(rem > 0 && sign[i] == '+')
				diff = Math.min(rem, max - val[i]);
			if(rem < 0 && sign[i] == '-')
				diff = Math.max(rem, val[i] - max);
			val[i] += Math.abs(diff);
			rem -= diff;
		}
		return rem == 0;
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

		public boolean ready() throws IOException {return br.ready();}


	}
}