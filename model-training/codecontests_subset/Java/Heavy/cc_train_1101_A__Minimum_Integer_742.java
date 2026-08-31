/**
 *   Author: Ridam Nagar
 *   Date: 27 February 2019
 *   Time: 01:17:36
**/
/* 
package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{     

    public static void main (String[] args) throws java.lang.Exception
    {
    	Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         for(int j=0;j<n;j++){
         	int l=sc.nextInt();
         	int r=sc.nextInt();
         	int d=sc.nextInt();
            int x=0;
            int k=1;
            int f=0;
            if(d<l || d>r){
            	System.out.println(d);
            	f=1;
            }else{
            	int a=(r/d)*d +d;
            	System.out.println(a);
            }
           
          
          


         
         }
        
           
}

}