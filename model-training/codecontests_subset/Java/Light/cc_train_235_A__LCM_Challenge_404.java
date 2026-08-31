/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
 public class Codechef
{
    
    public static long LCM(long A, long B, long C){
        
        long temp = A*B/GCD(A,B);
        
        return temp*C/GCD(temp,C);
        
    }
    
    public static long GCD(long A, long B){
        
        long a = Math.max(A,B);
        long b = Math.min(A,B);
        
        while(true){
            
            if(a%b==0)
             return b;
            
            long temp = a;
            a = b;
            b = temp%b;
        }
        
    }
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		
		long n = scan.nextLong();
		if(n<3)
		 System.out.println(n);
		else if(n%2!=0)
		 System.out.println(LCM(n,n-1,n-2));
		else{
		    
		    if(GCD(n,n-3)==1)
		      System.out.println(LCM(n,n-1,n-3));
		    else
		      System.out.println(LCM(n-1,n-2,n-3));
		} 
	}
}
