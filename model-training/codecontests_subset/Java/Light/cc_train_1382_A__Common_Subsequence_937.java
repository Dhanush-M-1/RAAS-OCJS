/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    sc.nextLine();
	    for(int i=0;i<t;i++)
	    {
	     int n=sc.nextInt(),c=0,x=0;
	     int m=sc.nextInt();
	     int a[]=new int[n],b[]=new int[m];
	     sc.nextLine();
	     for(int j=0;j<n;j++)
	      a[j]=sc.nextInt();
	      sc.nextLine();
	      for(int j=0;j<m;j++)
	      b[j]=sc.nextInt();
	      out:for(int j=0;j<n;j++)
	      {
	        for(int k=0;k<m;k++)
	        {
	        if(a[j]==b[k])
	        {
	        c++;
	        x=a[j];
	        break out;
	        }
	        }
	      }
	      if(c==0)
	      System.out.println("NO");
	      else 
	      {
	       System.out.println("YES");
	       System.out.println("1 "+x);
	       //System.out.println(x); 
	      }
	    }
	}
}