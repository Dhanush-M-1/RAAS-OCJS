/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger; 

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-->0){
	        long a = sc.nextLong(),b = sc.nextLong(),n= sc.nextLong();
	        long x = a^b;
	        long y = (n+1)%3;
	        if(y==1) System.out.println(a);
	        else if(y==2) System.out.println(b);
	        else if(y==0) System.out.println(x);
	        
	    }
	}
}