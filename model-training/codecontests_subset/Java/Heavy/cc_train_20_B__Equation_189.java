import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble(), b = sc.nextDouble(), c = sc.nextDouble(), k;
		double d, x1, x2;
		if (a==0 && b==0)
		{
			if (c==0) System.out.print("-1");
			else System.out.print("0"); 
		} else
		if (a==0)
		{
			System.out.println("1");
			x1 = - c / b;
			System.out.printf("%.8f",x1);
		} else
		{
			d = b*b - 4*a*c;
			if (d<0) System.out.print("0");
			if (d==0)
			{
				System.out.println("1");
				x1 = - b / (2.*a);
				System.out.printf("%.8f",x1);
			}
			if (d>0)
			{
				System.out.println("2");
				x1 = (- b + Math.sqrt(d)) / (2.*a);
				x2 = (- b - Math.sqrt(d)) / (2.*a);
				if (x1<x2) {double sw; sw=x1; x1=x2; x2=sw;}
				System.out.printf("%.8f",x2);
				System.out.println();
				System.out.printf("%.8f",x1);
			}
		}
	}
}