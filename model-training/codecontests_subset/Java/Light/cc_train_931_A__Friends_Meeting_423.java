/*package whatever //do not write package name here */

import java.*;
import java.util.Scanner;


public class GFG {
	public static void main (String[] args) {
	    Scanner in=new Scanner(System.in);
	    int n=in.nextInt();
	    int m=in.nextInt();
	    if(n==m+1 || m==n+1)
	    System.out.println(1);
	    else{
System.out.println(sum(Math.abs((n+m)/2)-Math.min(m,n))+sum(Math.max(m,n)-Math.abs((n+m)/2)));
	    }
	}
	public static int sum(int n){
	    return n*(n+1)/2;
	}
}