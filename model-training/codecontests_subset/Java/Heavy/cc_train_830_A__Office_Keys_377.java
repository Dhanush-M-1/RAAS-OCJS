import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {
	
	static int N, K, O;
	static int[][] memo;
	static int[] a, b;
	
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		N = sc.nextInt(); K = sc.nextInt(); O = sc.nextInt();
		a = new int[N]; for(int i = 0; i < N; i++) a[i] = sc.nextInt();
		b = new int[K]; for(int i = 0; i < K; i++) b[i] = sc.nextInt();
		Arrays.sort(a); Arrays.sort(b);
		memo = new int[N][K]; for(int[] a : memo) Arrays.fill(a, -1);
		out.println(dp(0, 0));
		out.flush();
		out.close();
	}
	
	static int dp(int i, int j)
	{
		if(i == N) return 0;
		if(j == K) return Integer.MAX_VALUE;
		if(memo[i][j] != -1) return memo[i][j];
		int take = Math.max(dp(i + 1, j + 1), Math.abs(a[i] - b[j]) + Math.abs(b[j] - O));
		int leave = dp(i, j + 1);
		return memo[i][j] = Math.min(take, leave);
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream system) {br = new BufferedReader(new InputStreamReader(system));}
		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public String nextLine()throws IOException{return br.readLine();}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public double nextDouble() throws IOException {return Double.parseDouble(next());}
		public char nextChar()throws IOException{return next().charAt(0);}
		public Long nextLong()throws IOException{return Long.parseLong(next());}
		public boolean ready() throws IOException{return br.ready();}
		public void waitForInput(){for(long i = 0; i < 3e9; i++);}
	}
}