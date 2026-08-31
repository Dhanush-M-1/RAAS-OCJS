import java.util.*;
public class Bet
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		int a[]=new int [5];
		int ans=0;
		for(int i=0;i<5;i++)
		{
			a[i]=sc.nextInt();
			ans=ans+a[i];
		}
		if(ans%5==0 && ans!=0)
		{
			System.out.println(+(ans/5));
		}
		else
			{
			System.out.println("-1");
		}
	}
}