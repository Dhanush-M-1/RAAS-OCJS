import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int k = sc.nextInt();

        int digits = n.length();
        int[] digit = new int[digits];

        for(int i = 0 ; i < digits ; i++){
            digit[i] = Integer.valueOf(n.substring(i, i+1));
        }

        //桁DP
        //(nを下回っているなら0, 未確定なら1), 0以外がちょうどk個, この桁数目まで
        long[][][] dp = new long[2][k+1][digits];
        dp[0][0][0] = 1;
        dp[0][1][0] = digit[0] - 1;
        dp[1][0][0] = 0;
        dp[1][1][0] = 1;


        for(int i = 1 ; i < digits ; i++){
            for(int j = 0 ; j <= k ; j++){
                dp[0][j][i] += dp[0][j][i-1];
                if(j > 0){
                    dp[0][j][i] += dp[0][j-1][i-1]*9;
                }
                if(digit[i] == 0){
                    dp[1][j][i] += dp[1][j][i-1];
                }else{
                    dp[0][j][i] += dp[1][j][i-1];
                    if(j > 0) {
                        dp[0][j][i] += dp[1][j-1][i-1]*(digit[i]-1);
                        dp[1][j][i] += dp[1][j-1][i-1];
                    }
                }
            }
        }

        System.out.println(dp[0][k][digits-1] + dp[1][k][digits-1]);
    }
}