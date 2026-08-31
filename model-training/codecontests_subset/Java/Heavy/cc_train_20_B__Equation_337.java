import java.util.*;
import java.math.*;


public class Equation
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		double a, b, c, d, e, x1, x2;
		
		a = in.nextDouble();
		b = in.nextDouble();
		c = in.nextDouble();
		
		if(a == 0 && b == 0 && c == 0)
		{
			System.out.println("-1");
			System.exit(0);
		}
		
		if(a == 0)
		{
			if(b == 0)
				System.out.println("0");
			else
				System.out.printf("%d\n%.6f\n", 1, -c/b);
			System.exit(0);
		}
		
		e = (b * b) - (4 * a * c);
		
		if(e < 0)
			System.out.println("0");
		else if(e == 0)
		{
			System.out.println("1");
			x1 = -b / (2 * a);
			
			System.out.printf("%.6f\n", x1);
		}
		else
		{
			System.out.println("2");
			
			d = Math.sqrt(e);
			x1 = (-b + d) / (2 * a);
			x2 = (-b - d) / (2 * a);
			
			System.out.printf("%.6f\n%.6f\n", Math.min(x1, x2), Math.max(x1, x2));
		}
	}
}

