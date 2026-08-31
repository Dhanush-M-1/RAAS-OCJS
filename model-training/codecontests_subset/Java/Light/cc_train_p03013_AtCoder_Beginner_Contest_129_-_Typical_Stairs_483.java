import java.util.*;
import static java.lang.System.*;

class Main {
  public static final int MOD = 1000000007;
  public static final int INF = 1000000000;
  public static void main(String[] args) {
    Scanner sc = new Scanner(in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    boolean a[] = new boolean[N+10];
    for(int i=0; i<M; i++){
      int x = sc.nextInt();
      a[x] = true;
    }
    long dp[] = new long[N+10];
    dp[0] = 1;
    if(a[1] == true) dp[1] = 0;
    else dp[1] = 1;
    for(int i=2; i<=N; i++){
      if(a[i] == true) dp[i] = 0;
      else{
        dp[i] = dp[i-1] + dp[i-2];
        dp[i] %= MOD;
      }
    }
    out.println(dp[N]);
  }

  public static int gcd(int a, int b){
    if(b == 0) return a;
    return gcd(b, a%b);
  }
}