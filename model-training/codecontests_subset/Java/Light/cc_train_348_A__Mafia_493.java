import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class C{
	public static void main( String[] args ){
		Scanner scanner = new Scanner( System.in );
		int n = scanner.nextInt( );
		int[] a = IntStream.generate( scanner::nextInt ).limit( n ).toArray( );
		int mx = Arrays.stream( a ).max( ).getAsInt( );
		long ans = 0;
		while( mx > 0 ){
			for( int i = 0; i < n; ++i ) a[i] -= mx;
			ans += mx;
			for( int i = 0; i < n && mx > 0; ++i ) mx += a[i];
			if( mx > 0 ){
				for( int i = 0; i < n; ++i ){
					a[i] = mx / ( n - i );
					mx -= mx / ( n - i );
				}
				mx = a[n - 1];
			}
		}
		System.out.println( ans );
	}
}