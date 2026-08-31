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
        

    	Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
         int arr[]=new int[n];
         int x=1000000,f=0,max=0;
         for(int i=0;i<n;i++){
          arr[i]=sc.nextInt();
            if(f==0){
                if(arr[i]>500000){
               x=arr[i];
               f=1;
          }else{
            max=arr[i];
            }
          }

        
         }
         int r=Math.max(max-1,1000000-x);
         System.out.println(r);


           

          

        
    

        
        
   


         
         
         

   

           
}

}