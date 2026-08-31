
import java.io.*;

import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int[] arr = new int[n];
	    int sum = 0;
	    for(int i = 0; i < arr.length;i++) {
	    	arr[i] = sc.nextInt();
	    	sum+=arr[i];
	    }
	    int times = 2;
	    while(times-- > 0) { 
	    	n--;
	    	int newsum = 0;
	    	for(int i = 0; i < n;i++) {
	    		int f = sc.nextInt();
	    		newsum+=f;
	    		sum-=f;
	    	}
	    	System.out.println(sum);
	    	sum=newsum;
	    }
	   
	    
	    
		

	}
	public static String reverse(String a) {
		char[] b = a.toCharArray();
		String c = "";
		for(int i = b.length-1; i >= 0 ;i--) {
			c+=b[i];
		}
		return c;
	}
	public static int min(int a, int b,int c) {
		if(a <b && a <c) {
			return a;
		}
		if(b <a && b <c) {
			return b;
		}
		return c;
	}
}
