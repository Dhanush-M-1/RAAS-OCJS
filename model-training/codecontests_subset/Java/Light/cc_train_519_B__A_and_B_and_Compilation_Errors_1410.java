/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
public class GFG {
	public static void main (String[] args) {
		Scanner s  = new Scanner(System.in);
		int t = 2;
		 int n = s.nextInt();
		 int sum=0;
		 int arr[] = new int[n];
		  
		   for(int i =0 ;i<n ;i++) {
		       arr[i]=s.nextInt();
		       sum=sum+arr[i];
		   }
		
		 n--;
		while(t-->0) {
		   int brr[] = new int[n];
		   int sumk =0;
		   for(int i =0 ;i<n ;i++) {
		       arr[i]=s.nextInt();
		       sumk=sumk+arr[i];
		   }
		 int k=sum-sumk;
		 sum=sumk;
		 System.out.println(k);
		 n--;
		   
		    
		    
		    
		    
		}
	}
}