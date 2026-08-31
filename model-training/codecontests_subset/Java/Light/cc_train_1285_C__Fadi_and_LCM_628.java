/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
    
   public class simple3 {
    	    static long gcd(long a, long b) 
                { 
                  if (b == 0) 
                    return a; 
                  return gcd(b, a % b);  
                } 
    	public static void main(String[] args) {
    		Scanner in = new Scanner(System.in);
    		long n = in.nextLong();
    		long a = 0;
    		long b = 0;
    		long a1 = 0;
    		long b1 = 0;
    		long min = Long.MAX_VALUE;
    		
    		for(int i=1; i<=Math.sqrt(n);i++)
    		{
    		    if(n%i==0)
    		    {
    		       a = i;
    		       b = n/i;
    		       long max = Math.max(a,b);
    		       long x = gcd(a,b);
    		       if(a*b==x*n && max < min)
    		       {
    		            a1 = a;
    		            b1 = b;
    		       }
    		    }
    		}
    		System.out.println(a1 + " " + b1);
    }
}
