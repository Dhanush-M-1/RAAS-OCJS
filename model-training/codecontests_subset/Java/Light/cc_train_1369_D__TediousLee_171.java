import java.util.*;
import java.io.*;
public class tediouslee{
   public static void main(String[] main) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      PrintWriter out = new PrintWriter(System.out);
      long[] dp = new long[2000001];
      int mod = 1000000007;
      dp[3] = 4;
      dp[4] = 4;
      int max = 5;
      int t = Integer.parseInt(st.nextToken());
      for(int trial = 1; trial <= t; trial++){
         st = new StringTokenizer(br.readLine());
         int n = Integer.parseInt(st.nextToken());
         if(n >= max){
         	for(; max <= n; max++){
         		dp[max] = (dp[max-1] + 2*dp[max - 2])%mod;
         		if(max % 3 == 0)
         			dp[max] = (dp[max] + 4)%mod;
         	}
         }
         out.println(dp[n]);
      }
      out.close();
   }
}