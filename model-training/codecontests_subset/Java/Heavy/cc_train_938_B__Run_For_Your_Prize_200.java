/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t, me = 1, fr = 1000000, mid = 500000;
		int[] a = new int[1000000];
		
		t = sc.nextInt();
		long total = -1;
		
		for(int i=0;i<t;i++)
		{
		    a[i] = sc.nextInt();
		    if(a[i]<= mid){
		        total = Math.max(total, a[i] - me);
		    }
		    else {
		        total = Math.max(total, fr - a[i]);
		    }
		}
		System.out.println(total);
		
		
	}
}
