import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		double a = sc.nextInt();
		double b = sc.nextInt();
		double c = sc.nextInt();
		if (a==0)
		{
			if (b==0)
			{
				if (c==0)
				{
					System.out.print("-1");
				}
				else
				{
					System.out.print("0");
				}
			}
			else
			{
				System.out.println("1");
				System.out.printf("%.5f", -c*1.0/b);
			}
		}
		else
		{
			double delta = (b*b-4*a*c)*1.0;
			if (delta<0)
			{
				System.out.print("0");
			}
			else if (delta==0)
			{
				System.out.println("1");
				System.out.printf("%.5f", -b*1.0/(2*a));
			}
			else
			{
				System.out.println(2);
				if ((-b-Math.sqrt(delta))/(2*a) < (-b+Math.sqrt(delta))/(2*a))
				{
				    System.out.printf("%.5f\n", (-b-Math.sqrt(delta))/(2*a));
				    System.out.printf("%.5f", (-b+Math.sqrt(delta))/(2*a));
				}
				else
				{
				    System.out.printf("%.5f\n", (-b+Math.sqrt(delta))/(2*a));
				    System.out.printf("%.5f", (-b-Math.sqrt(delta))/(2*a));
				}
			}
		}
	}
}