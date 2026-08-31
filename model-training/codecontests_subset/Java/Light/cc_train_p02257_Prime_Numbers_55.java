import java.util.Scanner;
class Main
{
	static boolean isPrime( int x )
	{
		if( x == 2 )return true;
		if( x<2 || x%2==0 )return false;
		for( int i = 3 ; i*i <= x ; i++ )
			if( x%i==0 )return false;
		return true;
	}
	public static void main( String[] args )
	{
		Scanner sc = new java.util.Scanner( System.in );
		
		int n = sc.nextInt(), counter=0;
		for( ; n != 0 ; n-- )
			if( isPrime(sc.nextInt()) )counter++;
		
		System.out.println( counter );
	}
}