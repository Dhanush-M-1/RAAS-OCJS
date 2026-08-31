

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Solution{

	

	public static void main (String[] args) throws java.lang.Exception{
	    Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int[] a=new int[n];
		int[] b=new int[n-1];
		int[] c=new int[n-2];
		for(int i=0; i<n; i++)  a[i]=scan.nextInt();
		for(int j=0; j<n-1; j++)  b[j]=scan.nextInt();
		for(int k=0; k<n-2; k++)  c[k]=scan.nextInt();
		
		Arrays.sort(a);
		Arrays.sort(b);
		Arrays.sort(c);
		
		    System.out.println(finderror(a,b));
		    System.out.print(finderror(b,c));
		
	}
	
	public static int finderror(int[] a,int[] b){
	    for(int x=0;x<b.length;x++){
	        if(a[x]!=b[x])
	            return a[x];
	    }
	    return a[a.length-1];
	    
	    
	}
	
	
	
	
	
	
}