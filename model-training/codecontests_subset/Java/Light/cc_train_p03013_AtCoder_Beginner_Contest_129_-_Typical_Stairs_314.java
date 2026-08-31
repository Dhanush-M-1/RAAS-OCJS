

import java.util.Scanner;

public class Main {
public static void main(String args[])
{
	Scanner scan=new Scanner(System.in);
	int n=scan.nextInt();
	int m=scan.nextInt();
	int ar[]=new int[m];
	int dp[]=new int[n+1];
	for(int i=0;i<m;i++)
	{
		dp[scan.nextInt()]=-1;
	}
	dp[0]=(dp[0]==0)?1:-1;
	dp[1]=(dp[1]==0)?1:-1;
	for(int i=2;i<=n;i++)
	{
		if(dp[i]==-1)continue;
		int x=(dp[i-1]==-1)?0:dp[i-1];
		int y=(dp[i-2]==-1)?0:dp[i-2];
		dp[i]=(x+y)%1000000007;
	}
	System.out.println(dp[n]);
}
}
