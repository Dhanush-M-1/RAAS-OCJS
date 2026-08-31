import java.util.*;
import java.io.*;
import static java.lang.Math.*;

class Main {

    public static void main( final String[] args ) {

		final Scanner stdin = new Scanner( System.in );

		while ( true ) {

			final int n = stdin.nextInt();
			if ( n == 0 ) break;

			int[][] vals = new int[ 2 ][ 12 ];
			for ( int i = 0; i < 12; i++ ) {
				vals[ 0 ][ i ] = stdin.nextInt();
				vals[ 1 ][ i ] = stdin.nextInt();
			}
			int sum = 0;
			boolean success = false;
			for ( int i = 0; i < 12; i++ ) {
				sum += vals[ 0 ][ i ] - vals[ 1 ][ i ];
				if ( sum >= n ) {
					System.out.println( i + 1 );
					success = true;
					break;
				}
			}
			if ( !success ) {
				System.out.println( "NA" );
			}
		}	
    }    
}