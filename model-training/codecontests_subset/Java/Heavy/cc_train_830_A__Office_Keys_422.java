import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
	
	static long memo[][];
	static int n, k, p;
	static int [] people, keys;
	static final long INF = (long) 1e10;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		n = sc.nextInt();
		k = sc.nextInt();
		p = sc.nextInt();
		
		people = new int[n];
		keys = new int[k];
		
		for(int i = 0; i < n; ++i) people[i] = sc.nextInt();
		for(int i = 0; i < k; ++i) keys[i] = sc.nextInt();
		
		
		Arrays.sort(people);
		Arrays.sort(keys);
		
		memo = new long[n + 1][k + 1];
		
		for(int i = 0; i <= n; ++i) Arrays.fill(memo[i], -1);
		
		out.println(solve(0, 0));
		
		out.flush();
		out.close();
	}
	
	private static long solve(int pe, int key) {
		if(pe == n) return 0;
		if(memo[pe][key] != -1) return memo[pe][key];
		
		long take;
		take = Math.max(Math.abs(people[pe] - keys[key]) + (Math.abs(keys[key] - p)),
				solve(pe + 1, key + 1));
		
		if(k - key > n - pe)
			take = Math.min(take, solve(pe, key + 1));
		
		return memo[pe][key] = take;
	}

	static class Scanner{
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

		public double nextDouble() throws IOException { return Double.parseDouble(next()); }

		public boolean ready() throws IOException {return br.ready();}
	}
}