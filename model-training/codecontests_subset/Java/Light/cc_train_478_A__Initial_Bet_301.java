import java.util.*;
public class Initial_Bet
{
	public static void main(String[] args)
	{
		int sum=0;
		Scanner s=new Scanner(System.in); 
		int[] a=new int[5];
		for(int i=0;i<5;i++)
		{
			a[i]=s.nextInt();
		}
		for(int i=0;i<5;i++)
		{
			sum=sum+a[i];
		}
		if(sum==0)
		{
			System.out.print("-1");
		}
		else if(sum%5==0)
		{
			System.out.print(sum/5);
		}
		else
		{
			System.out.print("-1");
		}
	}
}