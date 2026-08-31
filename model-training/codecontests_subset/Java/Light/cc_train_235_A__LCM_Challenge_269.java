import java .io.*; 
import java.util.*;
import java.lang.*;
import java.util.Arrays; 
import java.util.HashMap;
public class RATHOD 
{ 
    public static void main (String[] args) 
    { 
    Scanner sc=new Scanner(System.in);
       long n,sol;
       n=sc.nextLong();
       if(n<=2)
       {
        sol=n;
       }
       else if(n%2==0)
       {
        if(n%3==0) 
         sol=(n-1)*(n-2)*(n-3);   
        else
        sol=(n-1)*(n)*(n-3);   
       }
       else
       {
         sol=n*(n-1)*(n-2);    
       }
       System.out.println(sol);
    } 
}