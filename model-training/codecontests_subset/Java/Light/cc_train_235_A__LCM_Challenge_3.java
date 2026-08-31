
import java.util.Scanner;

public class LCM_Challenge
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long max = 0;
		for(int i = Math.max(1, n-190);i<=n;i++)
			for(int j = i;j<=n;j++)
				for(int k = j;k<=n;k++)
					max = Math.max(max, lcm(i,lcm(j,k)));
		System.out.println(max);
		
	}
	
	static long lcm(long a,long b)
	{
		return a * b / gcd(a,b);
	}
	
	static long gcd(long a , long b)		//O(log10)
	{
		if(b==0) return a;
		return gcd(b,a%b);
	}
}
