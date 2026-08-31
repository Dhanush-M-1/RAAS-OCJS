

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int m = Integer.parseInt(sc.next());
        boolean[] isBroken = new boolean[n+1];
        for(int i=0;i<m;i++){
            isBroken[Integer.parseInt(sc.next())] = true;
        }
        long dp[] = new long[n+1];
        dp[0] = 1;
        if(!isBroken[1]){
            dp[1] = 1;
        }
        for(int i=2;i<=n;i++){
            if(!isBroken[i]){
                dp[i] = (dp[i-1]+dp[i-2])%1000000007;
            }
        }
        System.out.println(dp[n]);
    }
}