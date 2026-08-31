
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] A = new int[M];
		for(int i = 0 ; i < M ; i++){
			A[i] = sc.nextInt();
		}
		sc.close();

		long INF = 1000000007;
		long[] dp = new long[N+1];

		dp[0] = 1;
		dp[1] = 1;

		for(int i = 0 ; i < M ;i++){
			dp[A[i]] = -1;
		}

		for(int j =2 ; j <= N ; j++){
			if(dp[j] != -1 && dp[j-1]!=-1 && dp[j-2] != -1){
				dp[j] = (dp[j-1] + dp[j-2])%INF;
			}
			else if(dp[j] != -1 && dp[j-1] == -1){
				dp[j] = (dp[j-2]);
			}
			else if(dp[j] != -1 && dp[j-2] == -1){
				dp[j] = (dp[j-1]);
			}
			//System.out.println(dp[j]);

		}
			if(dp[N] == -1){
				System.out.println("0");
			}
			else{
				System.out.println(dp[N]%INF);
			}

	}
}
