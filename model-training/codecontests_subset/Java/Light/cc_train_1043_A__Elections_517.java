import java.io.*;
import java.util.*;
public class Election
{
	public static void main(String[] d)
	{
		int n,a[],i,sum=0,max=0;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		a=new int[n];
		for(i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
			sum+=a[i];
			if(max<a[i])
				max=a[i];
		}
		int K=(((2*sum)/n)+1);
		System.out.println(Integer.max(K,max));
	}
}