import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        boolean[] a = new boolean[n + 1];
        
        for(int i = 0; i < m; i++) {
            int s = sc.nextInt();
            
            a[s] = true;
        }
        
        int mod = (int)1e9+7;
        
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        dp[1] = a[1] ? 0 : 1;
        
        for(int i = 2; i <= n; i++){
            if(!a[i]){
                dp[i] = (dp[i - 2] + dp[i - 1]) % mod;
            }
        }
        
        System.out.println(dp[n]);
        
    }
}
