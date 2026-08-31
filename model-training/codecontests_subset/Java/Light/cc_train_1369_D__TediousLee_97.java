import java.util.*;
import java.io.*;
import java.lang.Math;
import java.util.Random;


public class Solution{



	public static void main(String[] args) throws Exception{

		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);

		long mod = 1000000007;
		int max = 2000000;
		

			
		long[] dp = new long[max+1];
		dp[1] = 0L;
		dp[2] = 0L;

		
		for(int i=3;i<=max;i++){
			dp[i] = (dp[i-1] + 2*dp[i-2] + ((i%3==0)?4:0))%mod;
		}

		int t = fs.nextInt();

		while(t-->0){
			out.println(dp[fs.nextInt()]);
		}

		out.close();

		

		
		


	}

	
	

	static class FastScanner{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		public String next(){
			while(!st.hasMoreElements()){
				try{
					st = new StringTokenizer(br.readLine());
				} catch(IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public int nextInt(){
			return Integer.parseInt(next());
		}

		public int[] readArray(int n){
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i] = nextInt();
			return a;
		}

		public long nextLong(){
			return Long.parseLong(next());
		}
	}
}