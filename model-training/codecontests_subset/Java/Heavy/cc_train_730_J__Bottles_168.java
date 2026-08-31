import java.util.*;
import java.math.*;
public class main{
	
	public static void main(String args[])
	{
		int a[]=new int[101];
		int b[]=new int[101];
		int d[]=new int[10010];
		int v[]=new int[10010];
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		int sum=0;
		for(int i=0;i<n;i++)
		{
			a[i]=cin.nextInt();
			sum+=a[i];
		}
		for(int i=1;i<=sum;i++)d[i]=1000000007;
		for(int i=0;i<n;i++)b[i]=cin.nextInt();
		for(int i=0;i<n;i++)
		{
			for(int j=sum;j>=0;j--)
			{
				if(d[Math.min(j+b[i],sum)]>d[j]+1)
				{
					d[Math.min(j+b[i],sum)]=d[j]+1;
					v[Math.min(j+b[i],sum)]=v[j]+a[i];
				}
				else if(d[Math.min(j+b[i],sum)]==d[j]+1&&v[Math.min(j+b[i],sum)]<v[j]+a[i])
				{
					v[Math.min(j+b[i],sum)]=v[j]+a[i];
				}
			}
		}
		System.out.print(d[sum]+" "+(sum-v[sum]));
	}
}