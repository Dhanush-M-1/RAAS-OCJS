import java.io.*;
import java.util.*;

public class a {
	public static void main(String[] args) throws IOException {
		FastScanner stdin = new FastScanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = stdin.nextInt();
		
		for (int z = 1; z <= t; z++) {
			int n = stdin.nextInt();
			int m = stdin.nextInt();
			
			boolean[] a = new boolean[1001];
			for (int i = 0; i < n; i++)
				a[stdin.nextInt()-1] = true;
			
			int ans = -1;
			for (int i = 0; i < m; i++) {
				int in = stdin.nextInt()-1;
				if (a[in])
					ans = in;
			}
			
			if (ans!=-1)
				out.println("YES\n1 " + (ans+1));
			else
				out.println("NO");
		}
		
		out.flush();
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
	   
	    public long nextLong() throws IOException {
	        return Long.parseLong(next());
	    }
	    
	    public double nextDouble() throws IOException {
	        return Double.parseDouble(next());
	    }
	 }
}
