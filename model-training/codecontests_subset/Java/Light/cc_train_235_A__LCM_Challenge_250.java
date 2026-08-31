import java.io.*;
import java.util.*;

public class File {
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		long lcm=0;
		if(n==1)
		{
		   lcm=1; 
		}
		else if(n==2)
		{
		    lcm=2;
		}
		else if(n%2!=0)
		{
		    lcm=(long)(n*(n-1)*(n-2));
		}
		else
		{
		   if(n%3==0)
		   {
		       lcm=(n-1)*(n-2)*(n-3);
		   }
		   else
		   {
		      lcm=n*(n-1)*(n-3); 
		   } 
		}
		System.out.println(lcm);
	}
}