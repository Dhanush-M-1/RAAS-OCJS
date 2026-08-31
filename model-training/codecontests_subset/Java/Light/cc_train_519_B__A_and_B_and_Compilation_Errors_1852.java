import java.util.*;
public class Solution 
{
	public static void main (String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[] a=new int[n];int[] b=new int[n-1];int[] c=new int[n-2];
		for (int i=0;i<n;i++)
		{
			a[i]=in.nextInt();
		}
		for (int i=0;i<n-1;i++)
		{
			b[i]=in.nextInt();
		}
		for (int i=0;i<n-2;i++)
		{
			c[i]=in.nextInt();
		}
		Arrays.sort(a);Arrays.sort(b);Arrays.sort(c);
		System.out.println(diff(a, b));
		System.out.println(diff(b, c));
	}
	static int diff(int a[],int b[])
	{
		for (int i=0;i<b.length;i++)
		{
			if (a[i]!=b[i])
			{
				return a[i];
			}
		}
		return a[a.length-1];
	}

}