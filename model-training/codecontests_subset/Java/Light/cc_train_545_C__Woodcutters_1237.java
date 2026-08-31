import java.io.*;
import java.util.*;
public final class cf_woodcutter
{
	static Scanner sc=new Scanner(System.in);
	static PrintWriter out=new PrintWriter(System.out);
	
	public static void main(String args[]) throws Exception
	{
		int n=sc.nextInt();
		long[] a=new long[n+2];
		long[] h=new long[n+1];
		a[0]=Long.MIN_VALUE;
		a[a.length-1]=Long.MAX_VALUE;
		for(int i=1;i<=n;i++)
		{
			a[i]=sc.nextLong();
			h[i]=sc.nextLong();
		}
		int ans=0;
		for(int i=1;i<=n;i++)
		{
			if(a[i]-h[i]>a[i-1])
			{
				ans++;
				continue;
			}
			if(a[i]+h[i]<a[i+1])
			{
				ans++;
				a[i]=a[i]+h[i];
			}
		}
		out.println(ans);
		out.close();
	}
}