/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{ 
	public static void main (String[] args) throws Exception
	{
	      Scanner sc=new Scanner(System.in);
	 
	    
	   int t1=sc.nextInt();
	   while(t1-->0)
	   { 
	        
	       int n=sc.nextInt();
	      int m=sc.nextInt();
	      String s=sc.next();
	      //int a[]=new int[m];
	      HashMap<Integer,long []> h=new HashMap<>();
	     
	      long c[]=new long[26];
	      for(int i=0;i<n;i++)
	      {
	           c[s.charAt(i)-'a']++;
	           long q[]=new long[26];
	           for(int j=0;j<26;j++)
	           q[j]=c[j];
	           h.put(i+1,q);
	            
	           
	      }
	      long ans[]=new long [26];
	      for(int i=0;i<m;i++)
	      {
	           long d[]=h.get(sc.nextInt());
	           for(int j=0;j<26;j++)
	           {
	               //  System.out.print(d[j]+" ");
	                ans[j]+=d[j];
	           }
	          // System.out.println("&");
	      }
	      for(int i=0;i<26;i++)
	      ans[i]+=c[i];
	                  
	    for(int i=0;i<26;i++)
	    System.out.print(ans[i]+" ");
	    System.out.println();
	                 
	   }
	        
	     
	}
	   
     
}
	