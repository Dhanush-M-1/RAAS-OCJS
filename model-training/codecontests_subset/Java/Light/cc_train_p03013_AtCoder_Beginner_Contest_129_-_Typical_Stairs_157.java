import java.util.*;

public class Main{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    String[] S = sc.nextLine().split(" ");
    int N = Integer.parseInt(S[0]);
    int M = Integer.parseInt(S[1]);
    int p = 1000000007;
    boolean[] check = new boolean[N+1];
    
    for(int i = 0; i < M; i++){
      int n = Integer.parseInt(sc.nextLine());
      check[n] = true;
    }
    
    long[] dp = new long[N+1];
    dp[0] = 1;
    for(int i = 0; i < N; i++){
      if(check[i]){
        dp[i] = 0;
      }else if(i == N-1){
        dp[i+1] = (dp[i+1] + dp[i]) % p;
      }else{
        dp[i+1] = (dp[i+1] + dp[i]) % p;
        dp[i+2] = (dp[i+2] + dp[i]) % p;
      }
    }
    
    System.out.println(dp[N]);
  }
}