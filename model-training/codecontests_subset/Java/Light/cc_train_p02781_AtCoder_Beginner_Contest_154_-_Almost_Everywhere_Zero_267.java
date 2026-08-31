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
		for(int i = 0; i < len; i++){
		    int n = s.charAt(i) - '0';
		    for(int j = 0; j < 4; j++){
		        for(int d = 0; d < 10; d++){
		            int ni = i+1;
		            int nj = j;
		            if(d > 0) nj++;
		            if(nj > K) continue;
		            dp[ni][nj][1] += dp[i][j][1]; 
		            if(n == d){
		                dp[ni][nj][0] += dp[i][j][0];
		            }else if(n > d){
		                dp[ni][nj][1] += dp[i][j][0];
		            }
		        }
		    }
		}
		result = dp[len][K][0] + dp[len][K][1];
		
		// 出力
		System.out.println(result);
	}
}
