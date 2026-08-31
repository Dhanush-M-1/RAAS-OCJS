import java.util.Scanner;
class Main
{
	static void sort( int A[] )
	{
		int counter = 0;
		for( int i = 0 ; i < A.length ; i++ )
		{
			int min = i;
			for( int j = i ; j < A.length ; j++ )
				if( A[j] < A[min] )min = j;
			if( min!=i )
			{
				int work = A[i];
				A[i] = A[min];
				A[min] = work;
				counter++;
			}
		}
		for( int i = 0 ; i < A.length ; i++ )
			if( i==A.length-1 )
				System.out.printf( "%d\n%d\n", A[i], counter );
			else
				System.out.print( A[i]+" " );
	}
	public static void main( String[] args )
	{
		Scanner sc = new java.util.Scanner( System.in );
		
		int n = sc.nextInt();
		int A[] = new int[n];
		for( int i = 0 ; i < n ; i++ )A[i]=sc.nextInt();
		
		sort( A );
	}
}