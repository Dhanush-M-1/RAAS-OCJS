import java.io.*;
import java.lang.Math;
import java.util.Scanner;

public class E
{
	public static Scanner in;
	public static PrintStream out;
	
	public static void test()
	{
		long x1 = in.nextLong();
		long y1 = in.nextLong();
		
		long x2 = in.nextLong();
		long y2 = in.nextLong();
		
		long a = in.nextLong();
		long b = in.nextLong();
		
		long d = a*a+b*b;
		
		if (d==0)
		{
			if ( (x1==x2)&&(y1==y2) || (x1==y2)&&(x2==-y1) || (x1==-y2)&&(x2==y1) || (x1==-x2)&&(y1==-y2) )
			{
				out.println("YES");
			}
			else
			{
				out.println("NO");
			}
		
			return;
		}
		
		long x = x2-x1;
		long y = y2-y1;
		
		long k1 = a*x+b*y;
		long k2 = a*y-b*x;
		
		if (  (k1 % d == 0)&&(k2 % d == 0))
		{
			out.println("YES");
			return;
		}
		
		 x = x2-y1;
		 y = y2+x1;
		
		 k1 = a*x+b*y;
		 k2 = a*y-b*x;
		
		if (  (k1 % d == 0)&&(k2 % d == 0))
		{
			out.println("YES");
			return;
		}
		
		 x = x2+y1;
		 y = y2-x1;
		
		 k1 = a*x+b*y;
		 k2 = a*y-b*x;
		
		if (  (k1 % d == 0)&&(k2 % d == 0))
		{
			out.println("YES");
			return;
		}
		
		x = x1+x2;
		 y = y1+y2;
		
		 k1 = a*x+b*y;
		 k2 = a*y-b*x;
		
		if (  (k1 % d == 0)&&(k2 % d == 0))
		{
			out.println("YES");
			return;
		}
		
		else
		{
			out.println("NO");
		}
		
	}
       
	public static void main(String args[])
	{
		try
		{
			//in = new Scanner(new File("in.txt"));
			//out = new PrintStream(new File("out.txt"));
			in = new Scanner(System.in);
			out = System.out;
		}
		catch (Exception e)
		{
			return;
		}
	   
		//int t = in.nextInt();
		//for (int i=0; i<t; i++)
		{
			test();
		}
	}
}

