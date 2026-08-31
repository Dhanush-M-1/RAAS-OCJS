import java.io.*;
import java.util.*;

public class c {
	
	
	public static void main(String args[]) throws IOException {
		FastScanner in = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		int max = (int)(2e5 + 1);
		
		dp = new long[10][max];
		
		for (long[] x: dp)
			Arrays.fill(x, -1);
		
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < max; j++)
				memo(i, j);
				
		for ( ; t > 0; t--) {
			char[] line = in.next().toCharArray();
			long ans = 0;
			int m = in.nextInt();
			for (int i = 0; i < line.length; i++) {
				ans = (ans + dp[line[i] - '0'][m]) % mod;
			}
			out.println(ans);
		}
		out.close();
	}
	
	public static long[][] dp;
	public static long mod = (int)(1e9) + 7;
	
	public static long memo(int i, int j) {
		if (dp[i][j] != -1)
			return dp[i][j];
		long ans = 0;
		if (j == 0) {
			ans = 1;
		}
		else if (i == 9) {
			ans = memo(1, j - 1) + memo(0, j - 1);
		}
		else {
			ans = memo(i + 1, j - 1);
		}
		return dp[i][j] = (ans % mod);
	}
	
	
	
	static class FastScanner {
	    BufferedReader br;
	    StringTokenizer st;
		
	    public FastScanner(InputStream i) {
	        br = new BufferedReader(new InputStreamReader(i));
	        st = new StringTokenizer("");
	    }
				
	    public String next() throws IOException {
	        if(st.hasMoreTokens())
	            return st.nextToken();
	        else
	            st = new StringTokenizer(br.readLine());
	        return next();
	    }

	    public int nextInt() throws IOException {
	        return Integer.parseInt(next());
	    }
	    //#
	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }
	    public double nextDouble() throws IOException {
	        return Double.parseDouble(next());
	    }
	    //$
	}
}
