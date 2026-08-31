/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class codeforces652D
{

	static final int MOD = 1000000007;

	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		InputReader in = new InputReader();
		
		long[] dp = new long[2000001];
		dp[3] = dp[4] = 4;
		for(int i=5;i<2000001;i++){
			dp[i] = (dp[i-1] + 2*dp[i-2] + ((i%3)==0?4:0))%MOD;
		}
		
		int t = in.nextInt();
		while(t-- > 0){
			int n = in.nextInt();
			System.out.println(dp[n]);
		}
		// your code goes here
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer st;
 
		public InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}
 
		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				st = new StringTokenizer(nextLine());
			}
			return st.nextToken();
		}
 
		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
 
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}


}
