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
		int t=1,n,i,j,m=0,k,h,p=0,x=0,o,y;
		String st,s1,s2,s3;
		st=in.next();
		s1=in.next();
		n=in.nextInt();
		System.out.println(st+" "+s1);
		for(i=0;i<n;i++)
		{
		     s2=in.next();
		     s3=in.next();
		     if(s2.equals(st))
		          st=s3;
		     else s1=s3;
		     System.out.println(st+" "+s1);
		}
     }
}