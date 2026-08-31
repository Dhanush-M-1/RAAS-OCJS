/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

public class GFG {
	public static void main (String[] args) {
	   try{
	     
	       
	         Scanner sc = new Scanner(System.in);
	         int n = sc.nextInt();
	         int k = sc.nextInt();
	         int a[] = new int[n];
	         for(int i=0;i<n;i++) {
	             a[i] = sc.nextInt();
	         }
	         
	         int max = 0;
	         int answer = 0;
	         for(int i=0;i<n-1;i++) {
	             int diff = a[i] - a[i+1];
	             if(diff>0) {
	                 if(diff>max) {
	                     max = diff;
	                     answer = diff - k;
	                 }
	             }
	         }
	         if(answer > 0) {
	             System.out.print(answer);
	         }
	         else{
	             System.out.print(0);
	         }
	     
	      
	       
	       
	   }
	   catch(Exception e) {
	       
	   }
	   
	}
}