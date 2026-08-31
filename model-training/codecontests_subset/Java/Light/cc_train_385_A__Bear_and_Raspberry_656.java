import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner ob=new Scanner(System.in);
		int n=ob.nextInt();
		int a[]=new int[n];
		int c=ob.nextInt();
		for(int i=0;i<n;i++)
		{
		    a[i]=ob.nextInt();
		}
		int x=0,min=0;
		for(int i=0;i<n-1;i++)
		{
		    if(a[i]-a[i+1]>min)
		    {
		        x=i+1;
		        min=a[i]-a[i+1];
		    }
		}
		int ans=0;
		if(x==0)
		ans=0;
		else
		{
		    if(a[x-1]-a[x]>c)
		    ans=a[x-1]-a[x]-c;
		    else 
		    ans=0;
		}
		System.out.println(ans);
	}
}