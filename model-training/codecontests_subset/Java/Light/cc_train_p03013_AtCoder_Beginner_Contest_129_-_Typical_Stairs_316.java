import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        boolean[] isSafe = new boolean[N+1];
        Arrays.fill(isSafe, true);
        
        for (int i = 1; i < M+1; i++) {
            int tmp = sc.nextInt();
            isSafe[tmp] = false;
        }
         long[] dp = new long[N+1]; 
         Arrays.fill(dp, 0);
         dp[0] = 1;
         dp[1] = 1;
         if(!isSafe[1]) dp[1] = 0;
         for(int i=2; i<N+1; i++) {
             if(!isSafe[i]) continue;
             dp[i] = (dp[i-1]+dp[i-2])%1000000007;
         }
       System.out.println(dp[N]);
    }
}