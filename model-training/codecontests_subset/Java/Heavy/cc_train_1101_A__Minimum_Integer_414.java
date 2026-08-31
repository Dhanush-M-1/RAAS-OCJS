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
	  String []s=bf.readLine().split(" ");
	  int l=Integer.parseInt(s[0]);
	  int r=Integer.parseInt(s[1]);
	  int d=Integer.parseInt(s[2]);
	  
	  int p=(l/d)*d;
	  int q=(r/d)*d;
	  if(p!=l && p>0)
	  {
	      System.out.println(Math.min(p,d));
	  }
	  else if(p==l && p-d>0)
	  {
	      System.out.println(Math.min(p-d,d));
	  }
	  else
	  {
	      System.out.println(q+d);
	  }
	}
	
	}
}