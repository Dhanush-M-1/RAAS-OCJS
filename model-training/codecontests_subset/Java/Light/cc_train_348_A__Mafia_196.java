import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;



public class Main {
	public static class FastReader {
			BufferedReader br;
			StringTokenizer root;
			
	 
			public FastReader() {
				br = new BufferedReader(new InputStreamReader(System.in));
			}
	 
			String next() {
				while (root == null || !root.hasMoreTokens()) {
					try {
						root = new StringTokenizer(br.readLine());
					} catch (Exception addd) {
						addd.printStackTrace();
					}
				}
				return root.nextToken();
			}
	 
			int nextInt() {
				return Integer.parseInt(next());
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
				} catch (Exception addd) {
					addd.printStackTrace();
				}
				return str;
			}
		}
	 
	public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
	public static FastReader sc = new FastReader();
 
	static long mod = (long) (1e9+7),MAX=(long)(1e6+10);
	static List<Integer>[] edges;

	
	public static void main(String[] args) throws IOException{
	
	  int n = sc.nextInt();
	  long sum = 0;
	  long max = 0;
	  for(int i=0;i<n;++i) {
		  int x = sc.nextInt();
		  sum+=x;
		  max = Math.max(max, x);
	  }
	  long ans = Math.max(max, (sum+n-2)/(n-1));
	  out.print(ans);
		out.close();
	}
	

}
			