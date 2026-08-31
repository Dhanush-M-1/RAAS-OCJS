import java.io.*;
import java.util.*;

public class Main { 
	
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		outer:	
		while(t-- >0) {
			int n=sc.nextInt();
			int a[]=sc.readArray(n);
			int start=0,end=n-1;
			for(int i=0 ; i<n ; i++) {
				if(a[i]<i) break;
				start=i;
			}
			for(int i=n-1 ; i>=0 ; i--) {
				if(a[i]<(n-i-1)) break;
				end=i;
			}
			if(end<=start) out.println("Yes");
			else out.println("No");
		}
		out.flush();
		out.close();
	}
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int [] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		long [] longArray(int n) {
			long[] a=new long[n];
			for(int i=0 ; i<n ; i++) a[i]=nextLong();
			return a;
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
} 

