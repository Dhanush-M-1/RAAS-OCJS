import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AddOne
{
	public static final int MOD = 1000000007;
	public static int[][] dp = new int[10][200001];

	public static void main(String[] args) throws IOException
	{
		FastScanner scanner = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = scanner.nextInt();
		int max = -1;
		
		int[][] cases = new int[t][2];
		
		while (t-- > 0)
		{
			int n = scanner.nextInt();
			int m = scanner.nextInt();
			
			cases[t][0] = n;
			cases[t][1] = m;
			
			
			max = Math.max(max, m);
		}
		
		for (int i = 0; i < 10; i++)
			dp[i] = solve(max + 1, i);
		
		for (int i = cases.length - 1 ; i >= 0; i--)
		{
			int res = 0;
			for (char c : (cases[i][0] + "").toCharArray())
				res = add(res + 1 , dp[c - '0'][cases[i][1]]);
			
			out.println(res);
		}

		out.close();
	}

	private static int add(int a, int b)
	{
		if (a + b < MOD)
			return a + b;
		
		return a + b - MOD;
	}

	private static int[] solve(int m, int digit)
	{
		int[] res = new int[m];
		int d[] = new int[10];
		d[digit] = 1; 
		
		for (int i = 1; i < m; i++)
		{
			int n9 = d[9];

			for (int j = 9; j > 0; j--)
				d[j] = d[j - 1];

			d[0] = n9;
			d[1] = add(d[1] , n9);
			res[i] = add(res[i - 1], n9);
			
		}
		
		return res;
	}
	
	

	static class FastScanner
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next()
		{
			while (!st.hasMoreTokens())
				try
				{
					st = new StringTokenizer(br.readLine());
				} catch (IOException e)
				{
				}
			return st.nextToken();
		}

		int nextInt()
		{
			return Integer.parseInt(next());
		}

		long nextLong()
		{
			return Long.parseLong(next());
		}
	}
}