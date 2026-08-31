/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner sc=new Scanner(System.in);
        Integer n=sc.nextInt(),c=sc.nextInt(),max=0,i;
        Integer[] a=new Integer[n];
        for (i=0;i<n;i++)a[i]=sc.nextInt();
        for (i=0;i<n-1;i++)
        {
            if (a[i]-a[i+1]>max) max=a[i]-a[i+1];
        }
        if (max-c>0) System.out.println(max-c);
        else System.out.println(0);
        
	}
}
