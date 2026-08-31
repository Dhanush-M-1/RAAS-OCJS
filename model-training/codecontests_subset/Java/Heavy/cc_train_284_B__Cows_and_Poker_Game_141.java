/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    String s=sc.next();
	    int a=0;
	    int in=0;
	    for(int i=0;i<n;i++)
	    if(s.charAt(i)=='A'){
	        a++;
	    }else if(s.charAt(i)=='I'){
	        in++;
	    }
	    if(in==0){
	    System.out.println(a);
	    }else if(in==1){
	        System.out.println(1);
	    }else if(in>1){
	        System.out.println(0);
	    }
		// your code goes here
	}
}
