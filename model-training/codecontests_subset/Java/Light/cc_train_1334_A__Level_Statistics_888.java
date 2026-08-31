/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
	
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int t=Integer.parseInt(bf.readLine());
	while(t-->0)
	{
	    int n=Integer.parseInt(bf.readLine());
	    int a[]=new int[n];
	    int b[]=new int[n];
	    for(int i=0;i<n;i++)
	    {
	        String s1[]=bf.readLine().split(" ");
	        a[i]=Integer.parseInt(s1[0]);
	        b[i]=Integer.parseInt(s1[1]);
	    }
	    if(n==1)
	    {
	        if(a[0]>=b[0])
	        System.out.println("YES");
	        else
	        System.out.println("NO");
	        
	    }
	    else
	    {
	    boolean sang=check(a,b,n);
	    if(sang)
	    System.out.println("YES");
	    else
	    System.out.println("NO");
	    }
	}
	
	}
public static boolean check(int a[],int b[],int n)
{
    for(int i=0;i<n-1;i++)
    {
        if(a[i+1]>=a[i] && b[i+1]>=b[i] && (a[i+1]-a[i]>=b[i+1]-b[i]) && a[i]>=b[i])
        {
            continue;
        }
        else
        {
            return false;
        }
    }
    return true;
}
	
}