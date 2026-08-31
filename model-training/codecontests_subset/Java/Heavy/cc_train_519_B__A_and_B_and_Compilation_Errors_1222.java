

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

public class Codechef
{      
    
    
    public static void main (String[] args) throws java.lang.Exception
    {   
      Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
       int sum1=0,sum2=0,sum3=0;
        for(int i=0;i<n;i++){
           sum1=sum1+sc.nextInt();
        }
  
        for(int i=0;i<n-1;i++){
           sum2=sum2+sc.nextInt();
        }
  
        for(int i=0;i<n-2;i++){
          sum3=sum3+sc.nextInt();
        }
      System.out.println(sum1-sum2);
      System.out.println(sum2-sum3);

        
  

 
































}
           

}

