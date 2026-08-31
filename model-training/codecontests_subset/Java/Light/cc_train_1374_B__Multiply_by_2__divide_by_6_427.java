/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public final class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0){
		    int two = 0;
		    int three = 0;
		    long n =s.nextLong();
		    boolean flag = false;
		    while (n % 2 == 0) { 
            two++; 
            n /= 2; 
            } 
            while (n % 3 == 0) { 
            three++; 
            n /= 3; 
            } 
        
		if(n>1){
		    System.out.println(-1);
		}
		    else{
		        if(three<two){
		            System.out.println(-1);
		        }
		        else
		        System.out.println((three-two)+three);
		    }
	    }
	}
}
