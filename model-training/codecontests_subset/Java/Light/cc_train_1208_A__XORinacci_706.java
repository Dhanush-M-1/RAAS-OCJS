/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		int a=sc.nextInt();
		int b=sc.nextInt();
		int n=sc.nextInt();
	        if(n==0)
	        System.out.println(a);
	        else if(n==1)
		    System.out.println(b);
		    else{
		        if(n%3==0)
		            System.out.println(a);
		            else if(n%3==1)
		            System.out.println(b);
		            else
		            System.out.println(a^b);
		    }
		}
		
	}
}
