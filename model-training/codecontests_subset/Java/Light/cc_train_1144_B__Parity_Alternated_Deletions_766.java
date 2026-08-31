import java.util.*;
public class R550b
{
	static boolean getParity(int n) 
	{ 
		if(n%2==0)
			return false;
		else
			return true;
		
	} 
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),i,j=0,k=0;
		int ar[]=new int[n];
		long sum=0;
		for(i=0;i<n;i++)
		{
			ar[i]=sc.nextInt();
		}
		int a[]=new int[n];
		int b[]=new int[n];
		for(i=0;i<n;i++)
		{
			if(getParity(ar[i])==true)
				a[j++]=ar[i];
			else
				b[k++]=ar[i];
		}
		Arrays.sort(a);
		Arrays.sort(b);
		if(j!=k)
		{
			if(j>k)
			{
				j=k+1;
			}
			else
			{
				k=j+1;
			}
		}
		for(i=0;i<n-j;i++)
			sum+=a[i];
		for(i=0;i<n-k;i++)
			sum+=b[i];
		System.out.println(sum);
	}
}