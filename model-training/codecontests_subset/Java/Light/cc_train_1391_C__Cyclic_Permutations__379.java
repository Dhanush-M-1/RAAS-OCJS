// Submitted By Subhash Yadav
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



import java.util.*;





public class E {
	static long p=1000000007;
	static long dp[];
	  static long modFact(int n) 
{ 
dp[0]=dp[1]=1;
for(int i=2;i<=n;i++) {
	dp[i]=(i%p*dp[i-1]%p)%p;
}
return dp[n]%p;
}
	  static long power( int y) 
	    { 
		  long res=1;
	       for(int i=1;i<=y;i++) res=(res*2)%p;
	       return res;
	    } 
	
	public static void main(String [] args) {
		FastScanner sc=new FastScanner();
		int n=sc.nextInt();
		
	dp=new long[n+1];
		 long a1=modFact(n);
		 long a2=power(n-1);
	//System.out.println(a1+" "+ a2);
		System.out.println((a1 -a2+p)%p);
		
		
		
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