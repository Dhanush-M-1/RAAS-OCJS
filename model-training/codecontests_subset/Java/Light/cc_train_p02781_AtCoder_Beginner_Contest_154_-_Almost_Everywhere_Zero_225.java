import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
	static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	public static long mod = (long) (1e9+7);
	public static long[][][] dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader sc = new FastReader();
		char[] s = sc.next().toCharArray();
		int n = s.length;
		int k = sc.nextInt();
		dp = new long[2][k+1][n+1];
		out.print(rec(0,0,1,k,s));
	    out.close();
	  }

	private static long rec(int i, int cnt, int last, int k, char[] s) {
		if(i == s.length) return cnt == k ? 1L : 0L;
		if(cnt > k) return 0L;
		if(dp[last][cnt][i] != 0) return dp[last][cnt][i];
		long ans = 0L;
		for(int dig=0;dig<=9;++dig) {
			if(last!=0 && dig > s[i]-'0') break;
			ans+=rec(i+1,cnt + (dig!=0 ? 1:0), (last!=0 && dig == (s[i]-'0'))?1:0,k,s);
		}
		return dp[last][cnt][i] = ans;
	}
	  
	}