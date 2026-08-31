import java.io.*;
import java.util.*;

public class C {

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt(), tt = 0;
        dp = new long[10][2_000_01];
        for(int j=0;j<=2_000_00;j++){
        	for(int i=0;i<10;i++){
        		/*if(j==0){
        			dp[i][j] = 1;	
        		}
         	  	else if(i!=9){
         	  		dp[i][j] = dp[i+1][j-1]; 
         	  	}
         	  	else dp[i][j] = (dp[1][j-1] + dp[0][j-1])%mod;
         	  	*/
         	  	dp[i][j] = dfs(i,1,j);
        	}
        }	
        while(t-->0) { 
            int n = in.nextInt(), m = in.nextInt();
            long ans = 0;
            while(n>0){                
            	//out.println(n%10+" "+y);
            	ans = (ans + dp[n%10][m])%mod;
            	n/=10;
            }
            out.println(ans);
    		tt++;
    		//out.println("Case #"+tt+": "+ans);
        }
        out.flush();
	}

	static long mod = (long)1e9+7, dp[][];

	static long dfs(int n, int x, int m){
		if(dp[n][m]!=0) return dp[n][m];
		if(m>=10-n){
			return (dfs(1,x+1,m-(10-n)) + dfs(0,x+1,m-(10-n)))%mod;		
		}
		else return 1;
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens())
				try { st = new StringTokenizer(br.readLine()); }
				catch(IOException e) {}
			return st.nextToken();
		}
		
		String nextLine(){
			try{ return br.readLine(); } 
			catch(IOException e) { } return "";
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		int[] readArray(int n) {
			int a[] = new int[n];
			for(int i=0;i<n;i++) a[i] = nextInt();
			return a;
		}
	}

	static final Random random = new Random();

	static void ruffleSort(int[] a){
		int n = a.length;
		for(int i=0;i<n;i++){
			int j = random.nextInt(n), temp = a[j];
			a[j] = a[i]; a[i] = temp;
		}
		Arrays.sort(a); 	
	}
}
