import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] a = new int[m];
        
        boolean[] arr = new boolean[n+1];
        
        for(int i = 0; i < m; i++){
            a[i] = sc.nextInt();
            arr[a[i]] = true;
        } 
        
        int[] dp = new int[n+10];
        
        int mod = 1_000_000_007;
        
        dp[0] = 1;
        dp[1] = arr[1] ? 0 : 1;
        
        for(int i = 2; i <= n; i++) if(!arr[i]) dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        
        System.out.println(dp[n]);
    }
}
