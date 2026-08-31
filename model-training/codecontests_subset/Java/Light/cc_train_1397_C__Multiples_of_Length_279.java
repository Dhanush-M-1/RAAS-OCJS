/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.lang.*;

public class GFG {
	public static void main (String[] args) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	long a[]=new long[n+1];
	for(int j=1;j<=n;j++)
	    a[j]=sc.nextLong();
	System.out.println("1"+" "+n);
	for(int j=1;j<=n;j++)
	    System.out.print((long)n*-1*a[j]+ " ");
	System.out.println();
	if(n>1)
	System.out.println("2"+" "+n);
	else System.out.println("1"+" "+n);
	if(n>1)
	{for(int j=2;j<=n;j++)
	    System.out.print((long)(n-1)*a[j]+ " ");}
	else System.out.println("0");
	System.out.println();
	System.out.println("1"+" "+"1");
	    System.out.print((long)(n-1)*a[1]);
	}
}