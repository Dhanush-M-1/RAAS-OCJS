/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

 public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner s=new Scanner(System.in);
		int c1=0;
		int c2=0;
		int q=0;
		int n=s.nextInt();
		while(n-->0)
		{
		   q=s.nextInt();
		   if(q==100)
		   c1++;
		   else
		   c2++;
		}
     if(n==1)
        {
            System.out.println("NO");
        }
        else
        {
        if(c1%2!=0)
           System.out.println("NO");
        else
        {
            if(c2%2!=0 && c1==0)
              System.out.println("NO");
            else
                System.out.println("YES");
        }
        }
      
	

	}
}