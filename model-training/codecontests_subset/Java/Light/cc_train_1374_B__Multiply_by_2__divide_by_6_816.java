import java.util.*;
public class Solution{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int ans=qb(n);
			System.out.println(ans);
		}
	}
	public static int qb(int n)
	{
		int a=0;
		int b=0;
		while(n%2==0)
		{
			n=n/2;
			a++;
		}
		while(n%3==0)
		{
			n=n/3;
			b++;
		}
		if(a<=b && n==1)
		{
			return (b-a)+b;
		}
		else
		{
			return -1;
		}
	}
}
