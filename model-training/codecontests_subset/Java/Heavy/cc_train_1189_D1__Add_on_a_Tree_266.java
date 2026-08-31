
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.Stack;
import java.util.regex.Pattern;





public class ROUGH {

	
	public static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		//it reads the data about the specified point and divide the data about it ,it is quite fast
		//than using direct 

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception r) {
					r.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());//converts string to integer
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (Exception r) {
				r.printStackTrace();
			}
			return str;
		}
	}
	
	public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
	static long mod = (long)(1e9+7);
	static long N = (long) 1e18;
	public static void main(String[] args) {
		 FastReader sc = new FastReader();
		 int n = sc.nextInt();
			List<Integer>[] edge = new ArrayList[n+1];
			for(int i=0;i<edge.length;++i) edge[i] = new ArrayList<>();
			for(int i=1;i<n;++i) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				edge[u].add(v);
				edge[v].add(u);
			}
			
			boolean found = true;
			for(int i=1;i<=n && found;++i) {
				if(edge[i].size() == 2) 
				 found = false;
				
			}
			if(found) out.println("YES");
			else out.println("NO");
		
		out.close();
		 
	}
	
}
