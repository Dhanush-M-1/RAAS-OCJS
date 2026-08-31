import java.util.*; 
public class Equation {
public static void main(String args[])
{
	Scanner scan = new Scanner(System.in); 
	
	// Values for Quadratic
	double a; 
	double b;
	double c; 
	
	a = scan.nextDouble();
	b = scan.nextDouble();
	c = scan.nextDouble(); 

	getRoots(a,b,c); 
}	



private static void getRoots(double a, double b, double c)
{	
	int numOfRoots = 0;
	double root1 = 0;
	double root2 = 0; 
// a is equal to 0
if(a == 0)
{
	if(b == 0 && c == 0)
	{
		System.out.println("-1");
	}
	
	else if(b == 0 && c != 0)
	{
		System.out.println("-0");
	}
	
	else
	{
		root1 = (-1 * (double)(c) / (double)(b));
		System.out.printf("1\n%5f",root1);
	}
	
}

	
// a is not equal to 0
else
{
	
	double quadratic =  Math.pow(b, 2) - (4 * a * c); 
	if(quadratic >= 0)
	{
		root1 = ((-1)*b) - Math.sqrt(quadratic);
		root1 /= (2 * a); 
		root2 = ((-1)*b) + Math.sqrt(quadratic);
		root2 /= (2 * a);
		if(root1 == root2)
		{
			System.out.printf("1\n%5f", root1);
		}
		
		else
		{
			if(root1 < root2)
			System.out.printf("2\n%5f\n%5f",root1,root2 );
			else
				System.out.printf("2\n%5f\n%5f",root2,root1);
		}
	}
	else
	{
		System.out.println("0s");
	}
}
}
}
