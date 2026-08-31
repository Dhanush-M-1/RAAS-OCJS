//package codeforces;

import java.util.Scanner;

public class FadiAndLCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner sc=new Scanner(System.in);
       
       long n=sc.nextLong();
       long ans=0;
       
       for( long i=1;i*i<=n;i++) {
    	   if(lcm(i,n/i)==n && n%i==0) {
    		  
    		   ans=i;
    	   }
    	   
       }
      
       

       System.out.println(ans+" "+n/ans);
       
  
	}
	
	 static long lcm(long a,long b) {
		 return a/gcd(a,b)*b;
	 }
	 static long gcd(long a, long b)
	    {
	        if (a == 0)
	            return b;
	        return gcd(b % a, a);
	    }

}
