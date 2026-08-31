import java.io.*;
import java.math.*;
import java.util.*;
public class Main {

	public static void main(String[] args) { //Boolean markers+DP
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int M = input.nextInt();
		boolean[] bad = new boolean[N+1];
		long mod = (long)(1e9+7);
		long[] dp = new long[N+1];
		for (int i = 0; i < M; i++) {
			int x = input.nextInt();
			bad[x]=true;
		}
		if (N==1) System.out.println(1);
		else {
			if (!bad[1]) dp[1]=1;
			if (!bad[2]) dp[2]=dp[1]+1;
			for (int step = 3; step<=N; step++) {
				if (!bad[step]) {
					dp[step]=dp[step-1]+dp[step-2];
					dp[step]%=mod;
				} 
			}
			System.out.println(dp[N]);
		}	
	}	
}