
import java.util.Scanner;

public class Main{
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char []c = sc.next().toCharArray();
		
		int k = Integer.parseInt(sc.next());
		
		int n = c.length;
		long dp[][] = new long [n+1][k+1];
		
		//Arrayfill(n,k,dp);
		
		dp[0][0] = 1;
		
		for(int i = 0 ; i < n ;i++) {
			for(int j = 0 ; j <= k ; j++) {
				if(dp[i][j] == 0) {
					continue;
				}
				
				if(j == k) {
					dp[i+1][j] += dp[i][j];
				}
				else if(i == n-1) {
					dp[i+1][j+1] += dp[i][j] * (int)(c[n-i-1] -'0'-1);
				}
				else {
					dp[i+1][j+1] += dp[i][j] * 9;
					dp[i+1][j] += dp[i][j]; 
				}
			}
		}
		
		//DEBUG(n,k,dp);
		long ans = dp[n][k];
		
		long [][][]dp1 = new long [n+1][k+1][2];
		
		dp1[1][1][0] = 1;

		
		for(int i = 1; i < n ; i++) {
			for(int j = 1 ; j <= k ; j++) {
				for(int l = 0 ; l <= 1 ; l++) {
					if(dp1[i][j][l] == 0) {
						continue;
					}
					int p = (int)(c[i] - '0');
					if(j == k) {
						dp1[i+1][j][l] += dp1[i][j][l];
					}
					else if(l == 0) {
						if(p == 0) {
							dp1[i+1][j][0] += dp1[i][j][0];
						}
						else {
						dp1[i+1][j+1][1] += dp1[i][j][0] * (p-1);
						dp1[i+1][j][1] += dp1[i][j][0];
						dp1[i+1][j+1][0] += dp1[i][j][0];
						}
					}
					else {
						dp1[i+1][j+1][1] += dp1[i][j][1] * 9; 
						dp1[i+1][j][1] += dp1[i][j][1];
					}
				}
			}
		}
		
		//System.out.println(dp1[n][k][0] +" "+ dp1[n][k][1]);
		//debug1(n,k,dp1);
		ans += dp1[n][k][0] + dp1[n][k][1];
		System.out.println(ans);
	}
}