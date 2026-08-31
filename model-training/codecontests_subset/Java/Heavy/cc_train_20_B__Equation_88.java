import java.util.Scanner;
public class Equation
{
	public static void main(String[]args)
	{
		Scanner in=new Scanner(System.in);
		double x1=0;  double x2=0;
		double A=in.nextDouble();
		double B=in.nextDouble();
		double C=in.nextDouble();
		int counter=0;
		

		double distinct=B*B-4*A*C;
		
		//case of infinite root count
		if(A==0 && B==0 && C==0)
		{
			System.out.println(-1);
		}
		else if(A==0 && B==0)
		{
			System.out.println(0);
		}
		else if(A==0 && C==0)
		{
			x1=0;
			System.out.println(1);
			System.out.println(x1);

			
		}
		else if(A==0)
		{
			x1=-C/(B*1.0);
			System.out.println(1);
			System.out.println(x1);
		}
		
		else
		{
			if(distinct==0)
			{
				x1= -B / ( 2 * A ) ;
				System.out.println(1);
				System.out.println(x1);
			}
			
			else if(distinct>0)
			{
				x1=( -B + Math.sqrt(distinct)) / ( 2 * A ) ;
				x2=( -B - Math.sqrt(distinct)) / ( 2 * A ) ;
				System.out.println(2);
				if(x2 > x1)
				{
					System.out.println(x1);
					System.out.println(x2);
				}
				if(x1==x2)
				{
					System.out.println(1);
					System.out.println(x1);
					
				}

				if(x1>x2)
				{
					System.out.println(x2);
					System.out.println(x1);
				}
					
			}
			//case of no roots
			else
				System.out.println(0);
			
		}
	}
}