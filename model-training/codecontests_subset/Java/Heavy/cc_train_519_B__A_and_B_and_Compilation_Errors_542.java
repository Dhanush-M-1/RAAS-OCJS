/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String input[]=br.readLine().split(" ");
		String input1[]=br.readLine().split(" ");
		String input2[]=br.readLine().split(" ");
		
		int a[]=new int[n];
		int b[]=new int[n-1];
		int c[]=new int[n-2];
		
		for(int i=0;i<n;i++)
		{
		    a[i]=Integer.parseInt(input[i]);
		    if(i<n-1) b[i]=Integer.parseInt(input1[i]);
		    if(i<n-2) c[i]=Integer.parseInt(input2[i]);
		}
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		/*for(int i=0;i<n;i++) System.out.print(a[i]+" ");
		System.out.println();
		for(int i=0;i<n-1;i++) System.out.print(b[i]+" ");
		System.out.println();
		for(int i=0;i<n-2;i++) System.out.print(c[i]+" ");
		System.out.println();*/
		int i=0;
		for(i=0;i<n-1;i++)
		    if(a[i] != b[i])
		    {
		        System.out.println(a[i]);
		        break;
		    }
	    if(i==n-1)
	        System.out.println(a[i]);
	    for(i=0;i<n-2;i++)
	        if(b[i] != c[i])
	        {
	            System.out.println(b[i]);
	            break;
	        }
	    if(i==n-2)
	        System.out.println(b[i]);
    }
}
