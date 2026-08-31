import java.util.*;
public class Main {

  public static void main(String[] args) { 
      int MOD = 1000000007;
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] dp = new int[n+1];
      int m = sc.nextInt();
      for(int i = 0; i < m; i++)
        dp[sc.nextInt()] = -1;
      dp[0] = 1;
      if(dp[1] != -1)
        dp[1] = 1;
      for(int i = 2; i < dp.length; i++) {
        if(dp[i] == -1) continue;
        int prevPrev = dp[i-2] == -1 ? 0 : dp[i-2];
        int prev = dp[i-1] == -1 ? 0 : dp[i-1];
        dp[i] = (prevPrev + prev) % MOD;
      }

      System.out.println(dp[n]);
  }
}