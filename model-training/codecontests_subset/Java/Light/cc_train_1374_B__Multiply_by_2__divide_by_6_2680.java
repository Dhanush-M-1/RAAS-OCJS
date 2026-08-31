/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public final class Ideone
{
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-- > 0)
		{
			int n=sc.nextInt();
			int x=0;
			    int y=0;
			    while(n%3==0)
			    {
			        n/=3;
			        x++;
			    }
			    while(n%2==0)
			    {
			        n=n>>1;
			        y++;
			    }
			 int c=0;
			c=(x>y)?1:-1;
			
			if(x==y)
			c=0;
			if(n>1)
			c=-1;
			if(c==-1)
			{
			    System.out.println("-1");
			    continue;
			}
			else if(c==0)
			{
			    System.out.println(x);
			}
			else
			{
			    System.out.println(2*x-y);
			    
			}
			
		}
	}
}