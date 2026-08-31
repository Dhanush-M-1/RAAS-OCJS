
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String numStr = sc.next();
		int K = sc.nextInt();
		
		int len = numStr.length();
		
		//dp[i][j][k] 上からi桁まで見て、そこまでで非零をj回使い、
		//k = 0 : そこまでNと一致している場合 k = 1 : そこまででk以下が確定しているとき
		int dp[][][] = new int[len + 1][K + 1][2];
		dp[0][0][0] = 1;
		
		for(int i = 0; i < len; i++) {
			int tmpNum = numStr.charAt(i) - '0';
			for(int j = 0; j <= K; j++) {
				for(int k = 0; k <= 1; k++) {
					for(int l = 0; l <= 9; l++) {
						int nextI = i + 1;
						int nextJ = j;
						if(l > 0) {
							nextJ++;
							if(nextJ > K) {
								continue;
							}
						}
						int nextK = k;
						if(k == 0) {
							if(l > tmpNum) {
								continue;
							}
							if(l < tmpNum) {
								nextK = 1;
							}
						}
						
						dp[nextI][nextJ][nextK] += dp[i][j][k];
					}
				}
			}
		}
		
		//debug
		/*
		for(int i = 0; i <= K; i++) {
			for(int j = 0; j <= len; j++) {
				System.out.print(dp[j][i][0]+" ");
			}
			System.out.println();
		}
		for(int i = 0; i <= K; i++) {
			for(int j = 0; j <= len; j++) {
				System.out.print(dp[j][i][1]+" ");
			}
			System.out.println();
		}
		*/
		System.out.println(dp[len][K][0] + dp[len][K][1]);
	}
}
