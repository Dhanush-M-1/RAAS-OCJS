/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	Scanner sc= new Scanner(System.in);
	int n = sc.nextInt();
		int x = sc.nextInt();
			int y = sc.nextInt();
   String s = sc.nextLine();
   s = sc.nextLine();
   int count=0;
   for(int i=n-1; i>=n-x; i--)
   {
       if(i==(n-y-1))
       {
           if(s.charAt(i)=='0')
           count++;
           else
           continue;
       }
       if(s.charAt(i)=='1')
       count++;
       
   }
   System.out.println(count);
	}
}
