/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
    public static int lower_bound(long ar[],long k)
{
    int s=0;
    int e=ar.length;
    while (s<e)
    {
        int mid = s+e>>1;
        if (ar[mid] <k)
        {
            s=mid+1;
        }
        else
        {
            e=mid;
        }
    }
   
    return s;
}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    long a[]=new long[n];
		    long pre[]=new long[n];
		    long sum=0;
		    for(int i=0;i<n;i++) {
		    a[i]=sc.nextLong();
		    sum+=a[i];
		    }
		    pre[0]=a[0];
		    long max=Long.MIN_VALUE;
		    for(int i=1;i<n;i++) {
		    pre[i]=pre[i-1]+a[i];
		    
		    }
		    for (int i = 1; i < n; i++) {
                pre[i] = Math.max(pre[i], pre[i - 1]);
            }
		    
		    while(m-->0) {
		        long x=sc.nextLong();
		    if(sum<=0 && pre[n-1]<x)
		    System.out.print("-1"+" ");
		    else {
		        long d=(sum > 0) ? Math.max((x - pre[n - 1] + sum - 1), 0) / sum : 0;
		        long ans=d*n;
		        int ind=lower_bound(pre,x-d*sum);
		        ans+=ind;
		        System.out.print(ans+" ");
		    }
		    
		    }
		    System.out.println();
		    
		}
	}
}
