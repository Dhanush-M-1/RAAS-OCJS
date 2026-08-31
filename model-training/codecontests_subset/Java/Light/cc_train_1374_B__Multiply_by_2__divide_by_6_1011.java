/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codeforces
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
	    int T=sc.nextInt();
	    
	    while(T-->0){
	        long n=sc.nextLong();
	        int count=0,streak=0;
	        while(n!=1||n<1){
	        if(n%6==0){
	            streak=0;
	            n/=6;
	        }
	        else{
	            n*=2;
	            streak++;
	        }
	        if(streak>1){
	            break;
	        }
	        count++;
	        }
	        if(n==1){
	            System.out.println(count);
	        }
	        else{
	            System.out.println(-1);
	        }
	    }
	}
}
