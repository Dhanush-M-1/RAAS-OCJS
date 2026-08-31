import java.io.*;
import java.math.*;
import java.util.*;
 
public class A {
	
	public static void main(String[] agrs) {
		FastScanner sc = new FastScanner();
		int yo = sc.nextInt();
		while(yo-->0) {
			int n = sc.nextInt();
			long[] a = new long[n];
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextLong();
			}
			boolean is = false;
			for(int i = 2; i < n; i++) {
				if(a[i] >= a[0] + a[1]) {
					System.out.println(1 + " " + 2 + " " + (i+1));
					is = true;
					break;
				}
				
			}
			
			if(!is) {
				System.out.println(-1);
			}
		}
	} 
	
	
	
	



	static int mod = 1000000007;
	static long pow(int a, int b) {
		if(b == 0) {
			return 1;
		}
		if(b == 1) {
			return a;
		}
		if(b%2 == 0) {
			long ans = pow(a,b/2);
			return ans*ans;
		}
		else {
			long ans = pow(a,(b-1)/2);
			return a * ans * ans;
		}
		
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
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
 
}