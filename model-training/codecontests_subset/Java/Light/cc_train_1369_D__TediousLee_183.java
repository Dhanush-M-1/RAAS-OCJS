import java.util.Scanner;

public class Main {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		long m=1000000007;
		
		long[][] dp=new long[2000001][2];
		
		dp[3][0]=1;
		dp[3][1]=0;
		
		for(int i=4;i<2000001;i++)
		{
			dp[i][0]=(1+((dp[i-1][1]%m+dp[i-2][1]%m)%m+dp[i-2][1]%m)%m)%m;
			dp[i][1]=((Math.max(dp[i-1][0],dp[i-1][1])%m+Math.max(dp[i-2][0],dp[i-2][1])%m)%m+Math.max(dp[i-2][0],dp[i-2][1])%m)%m;
		}
		
		int t=s.nextInt();
		
		for(int i=0;i<t;i++)
		{
			int n=s.nextInt();
			
			System.out.println((4*Math.max(dp[n][0],dp[n][1])%m)%m);
			
		}
	}
	
}