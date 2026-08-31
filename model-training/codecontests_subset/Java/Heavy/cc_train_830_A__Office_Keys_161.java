
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class A {
	
	static int N, K, P;
	static final long INF = (long) 1e15;
	static Integer[] a, b;
	static long[][] memo;
	
	static long solve(int i, int j) {
		if(i == N)
			return 0;
		if(j == K)
			return INF;
		
		if(memo[i][j] != -1)
			return memo[i][j];
		
		long take = Math.max(Math.abs(a[i] - b[j]) + Math.abs(b[j] - P), solve(i + 1, j + 1));
		long leave = solve(i, j + 1);
		
		return memo[i][j] = Math.min(take, leave);
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		N = sc.nextInt();
		K = sc.nextInt();
		P = sc.nextInt();
		
		a = new Integer[N];
		b = new Integer[K];
		
		for 
		(int i = 0; i < N; i++)
			a[i] = sc.nextInt();
		for (int i = 0; i < K; i++)
			b[i] = sc.nextInt();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		memo = new long[N + 1][K + 1];
		
		for (int i = 0; i <= N; i++)
			Arrays.fill(memo[i], -1);
		
		out.println(solve(0, 0));
		
		
		out.flush();
	}	

	


	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while(st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
	}

}