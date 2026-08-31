/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		while(q-->0)
		{
		    long l = sc.nextLong();
		    long r = sc.nextLong();
		    long d = sc.nextLong();
		    long num = r/d +1;
	        long result = d;
	        if(result>=l) result = num*d;
	        
	        System.out.println(result);
	        
		}
	}
}
