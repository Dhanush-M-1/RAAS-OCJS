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
		int t=1,i,n,m,k,p,h;
		String s="",st;
		long x=0,l,r,d,j;
		t=in.nextInt();
		for(i=0;i<t;i++)
		{
     		l=in.nextLong();
     		r=in.nextLong();
     		d=in.nextLong();
     		for(j=d;j<l;j+=d)
     		{
     		     break;
     		}
     		if(j<l)
     		     System.out.println(j);
     		else
     		     System.out.println((r/d+1)*d);
		}
	}
}