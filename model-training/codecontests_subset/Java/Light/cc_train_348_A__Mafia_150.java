import java.util.Scanner;
import java.util.stream.IntStream;

public class C{
	static int[] a;

	public static void main( String[] args ){
		Scanner scanner = new Scanner( System.in );
		int n = scanner.nextInt( );
		a = IntStream.generate( scanner::nextInt ).limit( n ).toArray( );
		int l = 1, r = 2_000_000_000;
		while( l < r ){
			int mid = l + ( r - l >> 1 );
			if( !can( mid ) ) l = mid + 1;
			else r = mid;
		}
		System.out.println( l );
	}

	static boolean can( int t ){
		int n = a.length;
		long sum = (long) n * t;
		for( int i : a ){
			if( i > t ) return false;
			sum -= i;
		}
		return sum >= t;
	}
}