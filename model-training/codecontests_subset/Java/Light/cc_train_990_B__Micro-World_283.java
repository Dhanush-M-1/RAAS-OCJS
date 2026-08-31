import java.util.*;
import java.io.*;
public class MicroWorld
{
	public static void main(String[] d)
	{
		int N,i,count=0,K,b=0,sum=0;
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		int a[]=new int[1000001]; 
		for(i=0;i<N;i++)
		{
			b=sc.nextInt();
			a[b]++;
		}
		b=0;
		for(i=1;i<=1000000;i++)
		{
			if(a[i]>=1)
			{
				if(b!=0 && i<=(b+K))
				{
					a[b]=0;
				}
				b=i;
			}
			
		}
		for(i=1;i<=1000000;i++)
		{
			sum+=a[i];
		}
		System.out.println(sum);
	}
}