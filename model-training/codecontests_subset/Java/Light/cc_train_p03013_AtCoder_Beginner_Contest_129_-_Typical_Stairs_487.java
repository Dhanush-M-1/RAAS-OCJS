import java.util.*;

public class Main {

  public static void main (String[] args) {

    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] a = new int[N+1];

    for (int i = 0; i < M; i++) {
      int m = sc.nextInt();
      a[m] = 1;
    }

    sc.close();

    long[] dp = new long[N+1];
    
    long mod = 1000000007;

    dp[N] = 1;

    for (int i = N-1; 0 <= i ; i--) {
      if (a[i] == 1){
        dp[i] = 0;
      } else {
        if (i == N - 1){
          dp[i] = dp[N];
        } else if (N < i+2){
          dp[i] = (dp[i+1] + dp[N]) % mod;
        }else {
          dp[i] = (dp[i+1] + dp[i+2]) % mod;
        }
      }
    }

    System.out.println(dp[0]);
    
  }

}