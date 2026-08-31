import java.util.Scanner;
public class b20
{
	public static void main( String args [] )
	{
		double a,b,c;
		int k;
		double x1,x2;
		double D;
		
	//	System.out.println( "Enter a,b,c" );
		Scanner var = new Scanner (System.in);
		a = var.nextInt();
		b = var.nextInt();
		c = var.nextInt();
	
		if ( a==0 && b!=0 )
		{
			k=1;
			x1=-c/b;
			System.out.println( +k );
			System.out.println( +x1 );	
			
		}	
		else if ( a!=0 && b==0 )  // Ax*x+B*x+c=0
		{
			k=1;
			if ( -c/a<0 )
			{
				System.out.println( "0" );
				
			}
			else
			{
				if ( -c/a!=0 )
				{
					k=2;
					x1=Math.sqrt( (-c)/a );
					System.out.println( +k );
					System.out.println( +(-x1) );
					System.out.println( +x1 );
				}
				else
				{	
					k=1;
					x1=Math.sqrt( (-c)/a );
					System.out.println( +k );
					
					System.out.println( +x1 );
				}					
			}
		}
		else if ( a==0 && b==0 && c==0 )
		{
			k=-1;
			
			System.out.println( +k );
			
		}
		else if ( a==0 && b==0 && c!=0 )
		{
			k=0;
			System.out.println( +k );
		}	
		else if ( a!=0 && b!=0 )
		{
			D=b*b-4*a*c;
			
			if ( D<0 )
			{	
				k=0;
				
				System.out.println( +k );
				
			}
			else if ( D>0 )
			{
				k=2;
				x1=(-b+Math.sqrt(D))/(2*a);
				x2=(-b-Math.sqrt(D))/(2*a);
				
				System.out.println( +k );
				if ( x1>x2 )
				{
					System.out.println( +x2 );
					System.out.println( +x1 );
				}
				else if ( x1<x2)
				{
					System.out.println( +x1 );
					System.out.println( +x2 );	
				}
				
			}
			else
			{
				k=1;
				System.out.println( +k );
	
				x1=(-b+Math.sqrt(D))/(2*a);
				System.out.println( +x1 );
			}

		}
		
	}
}
