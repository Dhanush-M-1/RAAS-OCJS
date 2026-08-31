//package geeks;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Coding1
{
	public static void main (String[] args)
	{
		Scanner s= new Scanner(System.in);
		int n=s.nextInt();
		 int x=s.nextInt();
		 int y=s.nextInt();
		 double a=(y*n)/100.0;
		 long c=(long) Math.ceil(a);
		 //System.out.println(a);
		 if(a<=x)
			 System.out.println("0");
		 else
			 System.out.println(c-x);
	}
}