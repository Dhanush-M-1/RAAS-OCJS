import java.util.Scanner;

public class ProblemB
{
	public static void main ( String[] args )
	{
		Scanner sc = new Scanner ( System.in );
		int n = sc.nextInt ();
		String str = sc.next ();

		new ProblemB ().run ( n , str );
	}

	public void run ( int n , String str )
	{
		int max = -1, count = 0;
		String result = "";

		for ( int i = 0; i < n - 1; i++ )
		{
			for ( int j = 0; j < n - 1; j++ )
			{
				if ( str.substring ( i , i + 2 ).equals ( str.substring ( j , j + 2 ) ) )
				{
					count++;
				}
			}

			if ( max < count )
			{
				max = count;
				result = str.substring ( i , i + 2 );
//				System.out.println ( "result = " + result + "\t\tmax = " + max );
			}

			count = 0;
		}

		System.out.println ( result );
	}

}
