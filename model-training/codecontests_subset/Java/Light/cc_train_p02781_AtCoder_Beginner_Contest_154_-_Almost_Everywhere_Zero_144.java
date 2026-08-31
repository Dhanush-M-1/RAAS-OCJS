import java.util.*;
import static java.lang.Math.*;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		// 入力
		String s = sc.next();
		int K = sc.nextInt();
		
		// 計算
		long result = 0;
		int len = s.length();
		int[][][] dp = new int[len+1][4][2];
		dp[0][0][0] = 1;
		for(int i = 1; i < len+1; i++){
		    int n = s.charAt(i-1) - '0';
		    for(int j = 0; j < 4; j++){
		        dp[i][j][1] += dp[i-1][j][1];
		        if(n == 0){
		            dp[i][j][0] += dp[i-1][j][0];
		        }else{
		            dp[i][j][1] += dp[i-1][j][0];
		        }
		        if(j < K){
		            dp[i][j+1][1] += dp[i-1][j][1]*9;
		            if(n > 0){
		                dp[i][j+1][1] += dp[i-1][j][0]*(n-1);
		                dp[i][j+1][0] += dp[i-1][j][0];
		            }
		        }
		    }
		}
		result = dp[len][K][0] + dp[len][K][1];
		
		// 出力
		System.out.println(result);
	}
}
