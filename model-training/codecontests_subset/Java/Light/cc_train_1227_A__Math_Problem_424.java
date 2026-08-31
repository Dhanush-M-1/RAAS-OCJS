/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
    static class Pair{
        int fi;
        int sec;
        Pair(int fi , int sec){
            this.fi = fi;
            this.sec = sec;
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- != 0){
		 int n = sc.nextInt();
		 Pair a[] = new Pair [n];
		 for(int i = 0 ; i < n ; i++){
		     a[i] = new Pair(sc.nextInt() , sc.nextInt());
		 }
		 int min = Integer.MAX_VALUE;
		 for(int i = 0 ; i < n ; i++){
		     if(min > a[i].sec){
		        min = a[i].sec;
		     }
		 }
		 int max = Integer.MIN_VALUE;
		 for(int i = 0 ; i < n ; i++){
		    if(max < a[i].fi){
		        max = a[i].fi;
		     }
		 }
		 if(n == 1){
		  System.out.println(0);   
		 }else{
		    if((max - min) < 0){
		        System.out.println(0);
		    }else{
		        System.out.println(Math.abs(max - min));
		    }
		 }
		}
	}
}
