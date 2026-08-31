import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		long x=1000000007;

		int N=sc.nextInt();

		long[] dp=new long[N+1];
		for(int i=0;i<N+1;i++) dp[i]=0L;
		dp[0]=1L;

		int M=sc.nextInt();
		for(int i=0;i<M;i++) dp[sc.nextInt()]=-1L;

		for(int i=0;i<N;i++) {
			if(dp[i]==-1) continue;
			if(dp[i+1]!=-1) dp[i+1]=(dp[i+1]+dp[i])%x;
			if(i+2<=N  && dp[i+2]!=-1) dp[i+2]=(dp[i+2]+dp[i])%x;
			
		}

		System.out.println(dp[N]%x);

		sc.close();
	}

}
