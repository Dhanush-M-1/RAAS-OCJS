import java.util.*;
import java.io.*;

public class CodeForces
{
	public static void main(String[] args)throws IOException
	{
		Scanner sc=new Scanner(System.in);
		//Scanner sc=new Scanner(new File("ip.txt"));
		
		int n,i,p=0,q=0,s=0,even=0,odd=0;

		n=sc.nextInt();

		int a[]=new int[n];

		for(i=0;i<n;i++)
			a[i]=sc.nextInt();

		for(i=0;i<n;i++)
		{
			if(a[i]%2==0)
				even++;
			else
				odd++;
		}

		if(even==odd||Math.abs(even-odd)==1)
		{
			System.out.println(0);
			System.exit(0);
		}

		int x[]=new int[even];
		int y[]=new int[odd];

		for(i=0;i<n;i++)
		{
			if(a[i]%2==0)
				x[p++]=a[i];
			else
				y[q++]=a[i];
		}

		if(even>odd)
		{
			Arrays.sort(x);
			for(i=0;i<even-odd-1;i++)
				s+=x[i];
		}
		else
		{
			Arrays.sort(y);
			for(i=0;i<odd-even-1;i++)
				s+=y[i];
		}

		System.out.println(s);
	}
}