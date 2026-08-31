import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        
        int N = 2 * r.nextInt();
        a = new int[3];
        for(int i = 0; i < 3; i++)
            a[i] = r.nextInt();
        
        dp = new int[4][N + 1];
        for(int[] i : dp)
            Arrays.fill(i, -1);
        int ways = go(0, N);
        
        System.out.println(ways);
    }
    static int[] a;
    static int[] v = {1, 2, 4};
    static int[][] dp;
    private static int go(int i, int rem) {
        if(i == 3){
            return rem == 0 ? 1 : 0;
        }else{
            if(dp[i][rem] != -1)return dp[i][rem];
            
            int ways = 0;
            for(int t = 0; t <= a[i]; t++)
                if(rem - t * v[i] >= 0)ways += go(i + 1, rem - t * v[i]);
            
            return dp[i][rem] = ways;
        }
    }
}
