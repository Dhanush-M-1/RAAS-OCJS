import java.util.*;
import java.io.*;
 
public class Solution{
	static PrintWriter out=new PrintWriter(System.out);
	public static void main (String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] input=br.readLine().trim().split(" ");
		
		int numTestCases=Integer.parseInt(input[0]);
		
		int[] dp=new int[3*1000000];
		dp[3]=1;
		int mod=1000000000+7;
		for(int i=4;i<dp.length;i++){
		    int ans=(int)((2L*dp[i-2])%mod);
		    ans=(int)((0L+ans+dp[i-1])%mod);
		    if(i%3==0){
		        ans++;
		        ans%=mod;
		    }
		    dp[i]=ans;
		}
		while(numTestCases-->0) {
			input=br.readLine().trim().split(" ");
			int n=Integer.parseInt(input[0]);
			int ans=(int)((4L*dp[n])%mod);
			out.println(ans);
		}
		out.flush();
		out.close();
	}
}