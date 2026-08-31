/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) 
	{
		// your code goes here
		
			Scanner sc=new Scanner(System.in);
		
		int n,sum=0;
		
		n=sc.nextInt();
		int a[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
		    a[i]=sc.nextInt();
		    sum=sum+a[i];
		}
		Arrays.sort(a); 
		int r=(sum*2)/n;
		
		int temp=r+1;
		
		if(temp<a[n-1])
		{
		    System.out.println(a[n-1]);
		}
		else
		{
		    System.out.println(temp);
		}
	}
}
