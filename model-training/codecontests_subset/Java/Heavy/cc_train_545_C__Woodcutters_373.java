
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
	public static void main(String[] args) {
		 FastReader sc = new FastReader();
		int n = sc.nextInt();
		long[] a = new long[n+1];
		int[] h =  new int[n];
		for(int i=0;i<n;++i) {
			a[i] = sc.nextLong();
		    h[i] = sc.nextInt();
		}
		a[n] = Long.MAX_VALUE;
		int ans = 1;
		long l = a[0]-h[0],r = a[0];
			
 		for(int i=1;i<n;++i) {
 			long li = a[i]-h[i];
 			long ri = a[i]+h[i];
 			if(li>r) {
 				++ans;
 				r =  a[i];
 			}else if(ri<a[i+1] && a[i]>r){
 				++ans;
 				r =  ri;
 			}else r = a[i];
 			
 		}
 		
 		
		out.println(ans);
		 out.close();
		 
	}
	
	
}		
