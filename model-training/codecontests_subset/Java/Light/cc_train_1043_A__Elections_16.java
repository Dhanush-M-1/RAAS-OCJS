import java.util.*;
public class Force
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int []arr=new int[n];
		int sum=0;
		int max=-1;
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
			sum+=arr[i];
			if(max==-1 || arr[i]>max)
			{
				max=arr[i];
			}
		}
		int flag=1;
		while(flag==1)
		{
			int sum1=0;
			for(int i=0;i<n;i++)
			{
				sum1+=(max-arr[i]);
			}
			if(sum1>sum)
			{
				flag=0;
			}
			else
			{
				max++;
			}
		}
		System.out.println(max);
	}
}