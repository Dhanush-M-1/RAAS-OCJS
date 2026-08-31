/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
	Scanner ob=new Scanner(System.in);
	int a=ob.nextInt();// your code goes here
	int b=ob.nextInt();
	int c=ob.nextInt();
	double k=(double)(a*c)/(double)b;
	double i=(Math.ceil(k));
		int j=(int)i;
	int m=j-c;
	
		System.out.println(m);
	}
}