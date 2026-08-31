/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int t=Integer.parseInt(bf.readLine());
	while(t-->0)
	{
	    int n=Integer.parseInt(bf.readLine());
	    int cmin=Integer.MAX_VALUE;
	  //  int c=0;
	    int dmax=Integer.MIN_VALUE;
	  //  int d=0;
	    for(int i=0;i<n;i++)
	    {
	        String s[]=bf.readLine().split(" ");
	        int a=Integer.parseInt(s[0]);
	        int b=Integer.parseInt(s[1]);
	        if(b<cmin)
	        {
	            cmin=b;
	           // c=b;
	        }
	        if(a>dmax)
	        {
	            dmax=a;
	           // d=b;
	        }
	        
	        
	        
	    }
	   // System.out.println(dmax+" "+cmin);
	    
	    System.out.println(Math.max((dmax-cmin),0));
	}
		
	}
}
