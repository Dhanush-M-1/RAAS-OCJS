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
		int t,i,j=0,n,m,k=0,l,p=0,h;
		String s,st;
		long sum=0;
		n=in.nextInt();
		int a[]=new int[n];
		for(i=0;i<n;i++)
		{
		     a[i]=in.nextInt();
		     if(a[i]%2==0)
		     k++;
		     else p++;
		}
		Arrays.sort(a);
		     if(k<p)
		     {
		          for(i=n-1;i>=0;i--)
		          {
     		          if(a[i]%2==0)
     		               a[i]=0;
     		          else if(a[i]%2!=0 && k+1>0)
     		          {     a[i]=0;k--;}
     		          sum+=a[i];
		          }
		     }
		     else if(p<k)
		     {
		          for(i=n-1;i>=0;i--)
		          {
     		          if(a[i]%2!=0)
     		               a[i]=0;
     		          else if(a[i]%2==0 && p+1>0)
     		          {    a[i]=0;p--;}
     		          sum+=a[i];
		          }
		     }
		     else
		          sum=0;
		     System.out.println(sum);
	}
}