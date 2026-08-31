import java.util.*;

public class B {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    
    int[] A = new int[n+1];
    for(int i = 1; i <= n; i++) {
      A[i] = sc.nextInt();
    }
    
    sc.close();
    
    Arrays.sort(A, 1, n+1);
    
    int ss = n/k;
    int ls = ss+1;
    
    int L = n%k;
    int S = k-L;
    
    int[][] dp = new int[L+1][S+1];
    
    for(int l = 0; l <= L; l++) {
      for(int s = 0; s <= S; s++) {
        dp[l][s] = Integer.MAX_VALUE;
      }
    }
    dp[0][0] = 0;
    
    for(int l = 0; l <= L; l++) {
      for(int s = 0; s <= S; s++) {
        if(l > 0) {
          dp[l][s] = Math.min(dp[l][s], dp[l-1][s]
            + A[l*ls+s*ss]
            - A[(l-1)*ls+s*ss+1]);
        }
        if(s > 0) {
          dp[l][s] = Math.min(dp[l][s], dp[l][s-1]
            + A[l*ls+s*ss]
            - A[l*ls+(s-1)*ss+1]);
        }
      }
    }
    
    System.out.println("" + dp[L][S]);
  }

}
