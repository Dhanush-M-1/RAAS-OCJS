import java.util.*;
public class Error
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int sum1=0,sum2=0,ans1=0,sum3=0,ans2=0;
		for(int i=0;i<n;i++)
		{
			int a=sc.nextInt();
			sum1+=a;
		}
		for(int i=0;i<n-1;i++)
		{
			int a=sc.nextInt();
			sum2+=a;
		}
		ans1=sum1-sum2;
		for(int i=0;i<n-2;i++)
		{
			int a=sc.nextInt();
			sum3+=a;
		}
		ans2=sum2-sum3;
		System.out.println(ans1);
		System.out.println(ans2);
		
	}
}