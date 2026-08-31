/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
public class S {
	public static void main (String[] args) {
		Scanner in=new Scanner(System.in);
	    int n=in.nextInt();
	    int k=in.nextInt();
	    int a[]=new int[n];
	    for(int i=0;i<n;i++)a[i]=in.nextInt();
	    for(int i=0;i<n;i++)
	    {
	        if(k-(i+1)<=0)
	        {
	            System.out.print(a[k-1]);
	            break;
	        }
	        k-=(i+1);
	    }
	}
}