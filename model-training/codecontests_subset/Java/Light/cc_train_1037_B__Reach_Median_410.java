//package contese_476;
import java.util.*;
public class q1 
{
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	long s=sc.nextInt();
	long[] a=new long[n];
	for(int i=0;i<n;i++)
	{
		a[i]=sc.nextLong();
	}
	Arrays.sort(a);
	long count=0;
	if(a[n/2]==s)
	{
		count=0;
	}
	else if(a[n/2]<s)
	{
		int i=n/2;
		while(i<=n-1)
		{
			if(a[i]>=s)
				break;
			count+=(s-a[i]);
			//a[i]=s;
			i++;
		}
	}
	else
	{
		int i=n/2;
		while(i>=0)
		{
			
			if(a[i]<=s)
				break;
			count+=(a[i]-s);
			i--;
		}
	}
	System.out.println(count);
}

}
