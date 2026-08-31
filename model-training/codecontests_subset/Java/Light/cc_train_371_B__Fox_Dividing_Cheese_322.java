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
		int n=sc.nextInt();int m=sc.nextInt();
		int x=0,y=0,z=0;
		int p=0,q=0,r=0;
		while(n>=1&&n%2==0){
		    x++;n=n/2;
		}
		while(n>=1&&n%3==0){
		    y++;n=n/3;
		}
		while(n>=1&&n%5==0){
		    z++;n=n/5;
		}
		while(m>=1&&m%2==0){
		    p++;m=m/2;
		}
		while(m>=1&&m%3==0){
		    q++;m=m/3;
		}
		while(m>=1&&m%5==0){
		    r++;m=m/5;
		}
		if(n==m){
		    int xk=Math.abs(x-p)+Math.abs(y-q)+Math.abs(z-r);
		    System.out.println(xk);
		}
		else System.out.println(-1);
	}
}
