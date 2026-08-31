
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());//int型
        int m = Integer.parseInt(sc.next());
        int[] a = new int[m];
        int[] dp = new int[n+1]; // i段目に行く場合の数

        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(sc.next());
        }
        sc.close();

        boolean[] check = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            check[a[i]] = true;
        }

        // 0段目には1通り
        // 1段目には1通り
        dp[0] = 1;
        if(!check[1]) dp[1] = 1;
        else dp[1] = 0;
        for (int i = 0; i <= n-2; i++) {
            if(!check[i+2]) dp[i+2] = (dp[i+1] + dp[i]) % 1000000007;
            else dp[i+2] = 0;
        }
/*
        for (int i = 0; i < n+1; i++) {
            System.out.println(dp[i]);
        }
*/
        System.out.println(dp[n]);
    }
}
