import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner scan=new Scanner(System.in);
		int x1=scan.nextInt();
		int y1=scan.nextInt();
		int x2=scan.nextInt();
		int y2=scan.nextInt();
		int x3=scan.nextInt();
		int y3=scan.nextInt();
		long d1=(long)(x2-x1)*(x2-x1)+(long)(y2-y1)*(y2-y1);
		long d2=(long)(x3-x2)*(x3-x2)+(long)(y3-y2)*(y3-y2);
		long m1=(long)(y3-y2)*(x2-x1);
		long m2=(long)(x3-x2)*(y2-y1);
         if(d1==d2 && m1!=m2) System.out.println("Yes");
		 else  System.out.println("No" );
        
	}
}