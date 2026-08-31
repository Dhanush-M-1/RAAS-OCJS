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
		while(t--!=0)
		{
		    long a=sc.nextLong();
		    long b=sc.nextLong();
		    long x=sc.nextLong();
		    long c=a^b;
		    long res=x%3;
		    if(res==0)
		        System.out.println(a);
		    else if(res==1)
		        System.out.println(b);
		    else
		        System.out.println(c);
		}
	}
}
