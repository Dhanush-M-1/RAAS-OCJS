import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {

	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt();
		Bottle[] bots = new Bottle[n];
		int soda = 0;
		for(int i = 0; i < n; ++i)
		{
			bots[i] = new Bottle(sc.nextInt());
			soda += bots[i].a;
		}
		for(int i = 0; i < n; ++i)
			bots[i].b = sc.nextInt();
		Arrays.sort(bots);
		int k = 0, vol = 0;
		while(vol < soda)
			vol += bots[k++].b;
		int[][][] dp = new int[n + 1][k + 1][soda + 1];
		for(int[] x: dp[n])
			Arrays.fill(x, INF);
		dp[n][0][0] = 0;
		for(int idx = n - 1; idx >= 0; --idx)
			for(int remK = 0; remK <= k; ++remK)
				for(int curSoda = 0; curSoda <= soda; ++curSoda)
				{
					int ret = dp[idx + 1][remK][curSoda] + bots[idx].a;
					if(remK > 0)
						ret = Math.min(ret, dp[idx + 1][remK - 1][Math.max(curSoda - bots[idx].b, 0)]);
					dp[idx][remK][curSoda] = ret;
				}		
		out.println(k + " " + dp[0][k][soda]);
		out.flush();
		out.close();
	}
	
	static class Bottle implements Comparable<Bottle>
	{
		int a, b;
		
		Bottle(int x) { a = x; }
		
		public int compareTo(Bottle x) { return x.b - b; }
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

		public double nextDouble() throws IOException { return Double.parseDouble(next()); }

		public boolean ready() throws IOException {return br.ready();} 
	}
} 