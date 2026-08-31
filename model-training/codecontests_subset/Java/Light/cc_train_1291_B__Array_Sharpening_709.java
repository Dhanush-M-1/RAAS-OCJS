/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		 Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i =1;i<=t;i++){
		    
		    	int n = sc.nextInt();
		    	int []arr = new int[n];
		    	
		    	for(int j=0;j<n;j++)
		    	arr[j] = sc.nextInt();
		    	
		    	int right = 0;
		    	
		    	for(int j =0;j<n;j++){
		    	    if(arr[j]>=j){
		    	        right = j;
		    	    }else{
		    	        break;
		    	    }
		    	}
		    	
		    	int left = n-1;
		    	for(int j =n-1;j>=0;j--){
		    	    if(arr[j]>=(n-1)-j){
		    	        left = j;
		    	    }else{
		    	        break;
		    	    }
		    	}
		    	
		    	if(left<=right){
		    	    System.out.println("Yes");
		    	}else{
		    	    System.out.println("No");
		    	}
		    	
		    
		    
		    
		}
	}
}
