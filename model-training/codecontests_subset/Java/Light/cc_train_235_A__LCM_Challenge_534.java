/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{   int i,j;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		long n=Long.parseLong(br.readLine());
		long ans=1;
		if(n%2==1)
		    ans=n*(n-1)*(n-2);
		else    
		    ans=Math.max(n*(n-1)*(n-2)/2,(n-1)*(n-2)*(n-3));
		if(n%3!=0)
		    ans=Math.max(ans,n*(n-1)*(n-3));
		if(n==1)
	        ans=1;
	    if(n==2)    
	        ans=2;
		out.println(ans);
		out.close();
	}
}