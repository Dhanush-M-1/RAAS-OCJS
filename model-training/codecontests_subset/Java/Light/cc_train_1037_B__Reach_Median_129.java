/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
public class GFG {
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int s=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
	     a[i]=sc.nextInt();
	     Arrays.sort(a);
	     int m=((n+1)/2)-1;
	    long v=Math.abs(a[m]-s);
	    if(n>1){
	    for(int i=m+1;i<n;i++)
	       if(a[i]<s)
	        v+=(Math.abs(s-a[i]));
	        for(int i=0;i<m;i++)
	       if(a[i]>s)
	        v+=(Math.abs(s-a[i]));}
	      System.out.println(v);
    
	}
}