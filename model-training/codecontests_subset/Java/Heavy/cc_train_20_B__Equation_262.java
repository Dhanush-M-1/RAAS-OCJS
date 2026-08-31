import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CodeForce
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);

		long A = input.nextLong();
		long B = input.nextLong();
		long C = input.nextLong();
		if (A != 0)
		{
			long D = B * B - 4 * A * C;
			if (D > 0)
			{
				double x1 = ((double) (-B - Math.sqrt(D))) / (2 * A);
				double x2 = ((double) (-B + Math.sqrt(D))) / (2 * A);
				if (x1 > x2)
				{
					double temp = x1;
					x1 = x2;
					x2 = temp;
				}
				String s1 = Double.toString(x1);
				String s2 = Double.toString(x2);
				s1 = s1.concat("00000");
				s2 = s2.concat("00000");
				System.out.println(2);
				System.out.println(s1);
				System.out.println(s2);
			} else if (D == 0)
			{
				double x = ((double) -B) / (2 * A);
				String s = Double.toString(x);
				s = s.concat("00000");
				System.out.println(1);
				System.out.println(s);
			} else
			{
				System.out.println(0);
			}
		} else
		{
			if (B != 0)
			{
				double x = ((double) -C) / (B);
				String s = Double.toString(x);
				s = s.concat("00000");
				System.out.println(1);
				System.out.println(s);
			} else
			{
				if (C == 0)
				{
					System.out.println(-1);
				} else
				{
					System.out.println(0);
				}
			}
		}
	}
}