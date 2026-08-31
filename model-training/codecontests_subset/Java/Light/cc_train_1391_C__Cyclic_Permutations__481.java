import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		long dp[] = new long[10000000];
		dp[0] = 1;
		for (int i = 1; i <= a; i++)
		{
			dp[i] = (long) (((dp[i - 1]) * i) % (Math.pow(10, 9) + 7));
		}
	 long ans=(long) (dp[a]% (Math.pow(10, 9) + 7));
	 long all=1;
	 for (int i = 1; i <= a-1; i++)
	{
		all*=2;
		all%=(Math.pow(10,9)+7);
	}
	 long yes=(long) ((ans-(all)+(Math.pow(10,9)+7))%(Math.pow(10,9)+7));
		System.out.println(yes);
	}
}