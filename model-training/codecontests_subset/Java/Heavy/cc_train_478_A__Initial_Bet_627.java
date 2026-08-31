/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class InitialBet478A
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int x1, x2, x3, x4, x5, total;
		Scanner input=new Scanner(System.in);
		x1=input.nextInt();
		x2=input.nextInt();
		x3=input.nextInt();
		x4=input.nextInt();
		x5=input.nextInt();
		total= x1 + x2 + x3 + x4 + x5;
		if(x1==0 && x2==0 && x3==0 && x4==0 && x5==0)
		System.out.println("-1");
		else if(total %5 ==0)
		System.out.println(total/5);
		else
		System.out.println("-1");
	}
}