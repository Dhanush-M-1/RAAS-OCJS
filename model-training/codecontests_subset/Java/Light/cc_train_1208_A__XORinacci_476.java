
//package codeforces;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Arrays;

public class Flo {
 
    public static void main(String[] args) {
 
       long ar[]=new long[4];
     Scanner in = new Scanner(System.in);
     int t;
     t=in.nextInt();
    for (int j = 0; j<t; j++) {
    long a,b,n,temp;
    a=in.nextLong();
    b=in.nextLong();
    n=in.nextLong();
  
    
     if(n==1)
     {
         System.out.println(""+b);
     }
     else if(n==0)
     {
         System.out.println(""+a);
     }
     else if(a==b)
     {
         System.out.println(""+a);
     }
     else
     {
         
     
         for (int k = 1; k <=3; k++) {
        
//        for (int i = 0; i <s.length(); i++) {
//            con=con+(s.charAt(i)^p.charAt(i));
//        }
//        
         // temp=Flo.myXOR(a, b);
         temp=(a | b)-(a&b);
         ar[k-1]=temp;
          a=b;
          b=temp;
       
       //  System.out.println(""+temp);   
         }
        if((n-1)%3==0) 
        {
         System.out.println(""+ar[2]);   
        }
        else if((n-1)%3==1)
        {
            System.out.println(""+ar[0]);   
        }
         else
        {
            System.out.println(""+ar[1]);
        }
           
         
         
         
     }
 
      }
   
    }
}
