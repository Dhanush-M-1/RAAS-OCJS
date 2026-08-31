/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class S
{
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		try {
		    
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		    String T[] = br.readLine().split("\\+");
		    int a[] = new int[T.length];
		    for(int i=0;i<T.length;i++)
		    {
		    	a[i] = Integer.parseInt(T[i]);
		    }
		    Arrays.sort(a);
		    for(int i=0;i<a.length;i++)
		    {
		    	if(i!=(a.length-1))
		    	System.out.print(a[i]+"+");
		    else 
		    	System.out.print(a[i]);
		    }
		    }
		    
		    
		    
		 catch(Exception e) {
		    return;
		}
	}
    
}