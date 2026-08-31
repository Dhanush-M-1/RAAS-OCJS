/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.lang.*;

public class GFG {
    static Scanner sc=new Scanner(System.in);
	public static void main (String[] args) {
	    int size=sc.nextInt();
	    long target=sc.nextLong();
	    long[] a=new long[size];
	    input(a);
	    sort(a);
	    long result=solve(a,target);
	    System.out.println(result);
	}
	static long solve(long[] a,long target){
	    long result=Math.abs(a[a.length/2]-target);
	    long temp=1;//a dummy value to enter the loop
	    for(int i=a.length/2+1;i<a.length;i++){
	        temp=target-a[i];
	        if(temp<0)break;
	        result+=temp;
	    }
	    for(int i=a.length/2-1;i>=0;i--){
	        temp=target-a[i];
	        if(temp>0)break;
	        result-=temp;
	    }
	    return result;
	}
	static void input(long[] a){
	    for(int i=0;i<a.length;i++)a[i]=sc.nextLong();	
	}
	static void sort(long[] a){
	    Arrays.sort(a);
	}
}