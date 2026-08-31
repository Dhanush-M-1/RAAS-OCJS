/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
	 Scanner sc=new Scanner(System.in);
	 int n=sc.nextInt();
	 
	 int max=0,sum=0;
	 
	 for(int i=0;i<n;i++){
	  int x=sc.nextInt();	
	  max=Math.max(max,x);
	  sum+=x;
	 }
	 int temp=(2*sum)/n+1;
	 System.out.println(Math.max(max,temp));
	}
}