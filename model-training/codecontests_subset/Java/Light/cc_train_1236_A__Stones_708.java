/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while(t-->0)
		{int a=s.nextInt();
		int b=s.nextInt();
		int c=s.nextInt();
		int count=0;
		while(b>0)
		{while(c>=2 && b>=1)
		{count+=3;b--;c-=2;}
		while(b>=2 && a>=1)
		{count+=3;
		b-=2;a--;}
		if(a==0 || c<=1 || b==0)
		break;}
		System.out.println(count);}
	}
}