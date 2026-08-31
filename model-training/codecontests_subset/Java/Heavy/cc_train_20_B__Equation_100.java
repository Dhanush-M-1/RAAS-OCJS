import java.io.*;
import java.util.*;

public class p20b
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		double A = sc.nextDouble();
		double B = sc.nextDouble();
		double C = sc.nextDouble();
		if(A==0 && B==0 & C==0) System.out.println("-1");
		else if(A==0 && B==0) System.out.println("0");
		else if(A==0) System.out.printf("1\n%.9f",-C/B);
		else
		{
			double D = B*B-4*A*C;
			if(D<0) System.out.println("0");
			else if(D==0) System.out.printf("1\n%.9f", -B/(2*A));
			else
			{
				double N = (-B-Math.sqrt(D))/(2*A);
				double P = (-B+Math.sqrt(D))/(2*A);
				System.out.printf("2\n%.9f\n%.9f",Math.min(N,P),Math.max(P, N));
			}
		}
	}
}