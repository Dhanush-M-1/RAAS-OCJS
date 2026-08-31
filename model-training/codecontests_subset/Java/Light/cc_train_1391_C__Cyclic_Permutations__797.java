/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    long n = sc.nextLong();
	    long p=n;
	    long mod = (long)1e9+7;//Math.pow(10,9)+7;
	    for(int i=(int)n-1;i>=1;i--){
	        p*=(long)i;
	        p%=mod;
	    }
	    //Total Permutations - Unimodal Permutations  =  n! - 2^(n-1)
	    int q=1;
	    for(int i=1;i<(int)n;i++){
	        q*=2;
	        q%=mod;
	    }
	    
	    long c = p-q;
	    if(c<0)
	      c+=mod;
	         System.out.println(c);
	       
	        
	    
	}
}