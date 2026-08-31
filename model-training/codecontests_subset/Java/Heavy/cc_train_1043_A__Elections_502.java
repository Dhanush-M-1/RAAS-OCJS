/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Arrays;
import java.math.BigInteger;
 
/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
     public static void main (String[] args) throws java.lang.Exception
     {
     	Scanner in =new Scanner(System.in);
		int l,p,n,h,k,r;
		String s="",st="";
		long x,y,z;
		int t=1,i,m,j;
	     for(i=0;i<t;i++)
		{
		     p=0;h=0;
		     n=in.nextInt();
		     int a[]=new int[n];
		     for(j=0;j<n;j++)
		     {
		          a[j]=in.nextInt();
		          p+=a[j];
		     }
		     Arrays.sort(a);
		     for(j=a[n-1];;j++)
		     {
		         h=0;
		          for(k=0;k<n;k++)
		               h+=(j-a[k]);
		          if(p<h)
		          {
		               System.out.println(j);
		               break;
		          }
		     }
		}
     }
}