import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner scan  = new Scanner(System.in);
		int t = scan.nextInt();
		while( t > 0)
		{
		    int n = scan.nextInt();
		    long in[] = new long[n];
		    for(int i = 0; i < n; i++)
		    {
		        in[i] = scan.nextLong();
		    }
		    if((in[0] + in[1]) <= in[n-1])
		    {
		        System.out.print("1 2 "+n);
		    }
		    else
		    {
		        System.out.print("-1");
		    }
            System.out.println();
		    t--;
		}
	}
}