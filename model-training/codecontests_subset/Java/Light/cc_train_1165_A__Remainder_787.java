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
	 
	 int n=sc.nextInt(),x=sc.nextInt(),y=sc.nextInt();
	 String s=sc.next();
	 
	 int changes=0;
	 for(int i=n-1;i>=n-y-1;i--){
	  if(s.charAt(i)=='1' && i>n-y-1)changes++;
	  else if(s.charAt(i)=='0' && i==n-y-1) changes++;
	 }
	 for(int i=n-y-2;i>=n-x;i--)
	  if(s.charAt(i)=='1') changes++;
	  
	 System.out.println(changes); 
	}
}