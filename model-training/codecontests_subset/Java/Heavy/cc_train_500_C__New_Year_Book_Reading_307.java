import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class C {

	//IO
	static BufferedReader f;
	static PrintWriter out;
	static StringTokenizer st;
	
	final public static void main( String[] args ) throws IOException {
		f = new BufferedReader( new InputStreamReader( System.in ) );
		out = new PrintWriter( System.out );
		solve();
		f.close();
		out.close();
		System.exit( 0 );
	}
	
	static int totalDays;
	static int numBooks;
	static int[] weights;
	static int[] days;
	
	final public static void solve() throws IOException {
		numBooks = nextInt();
		totalDays = nextInt();
		
		weights = new int[ numBooks+1 ];
		for ( int i=1 ; i<=numBooks ; i++ ) {
			weights[ i ] = nextInt();
		}
		
		days = new int[ totalDays+1 ];
		for ( int i=1 ; i<=totalDays ; i++ ) {
			days[ i ] = nextInt();
		}
		
		int[] firstDayLifted = new int[ numBooks+1 ];
		for ( int i=1 ; i<=totalDays ; i++ ) {
			if ( firstDayLifted[ days[ i ] ] == 0 ) {
				firstDayLifted[ days[ i ] ] = i;
			}
			else {
				firstDayLifted[ days[ i ] ] = Math.min( firstDayLifted[ days[ i ] ] , i );
			}
		}
		for ( int i=1 ; i<firstDayLifted.length ; i++ ) {
			if ( firstDayLifted[ i ] == 0 ) {
				firstDayLifted[ i ] = 999999;
			}
		}
		
		Data[] d = new Data[ numBooks+1 ];
		d[ 0 ] = new Data( 0 , 0 );
		for ( int i=1 ; i<=numBooks ; i++ ) {
			d[ i ] = new Data( i , firstDayLifted[ i ] );
		}
		Arrays.sort( d );
		
		int[] stack = new int[ numBooks+1 ];
		for ( int i=1 ; i<=numBooks ; i++ ) {
			stack[ numBooks+1-i ] = d[ i ].bookNum;
		}
		/*for ( int i=1 ; i<=numBooks ; i++ ) {
			System.out.print( stack[ i ] + " " );
		}
		System.out.println();*/
		
		int totalWeightLifted = 0;
		for ( int i=1 ; i<=totalDays ; i++ ) {
			int bookToRead = days[ i ];
			for ( int j=1 ; j<stack.length ; j++ ) {
				if ( stack[ j ] == bookToRead ) {
					int weightLifted = 0;
					for ( int k=j+1 ; k<stack.length ; k++ ) {
						weightLifted += weights[ stack[ k ] ];
						stack[ k-1 ] = stack[ k ];
					}
					stack[ numBooks ] = bookToRead;
					//System.out.println( bookToRead + " " + weightLifted );
					totalWeightLifted += weightLifted;
					break;
				}
			}
		}
		System.out.println( totalWeightLifted );
	}
	
	static class Data implements Comparable< Data >{
		
		public int bookNum;
		public int firstDayLifted;
		
		public Data() {
			
		}
		
		public Data( int a , int b ) {
			bookNum = a;
			firstDayLifted = b;
		}

		@Override
		public int compareTo(Data o) {
			return firstDayLifted - o.firstDayLifted;
		}
	}
	
	final public static String nextToken() throws IOException {
		while ( st == null || !st.hasMoreTokens() ) {
			st = new StringTokenizer( f.readLine() );
		}
		return st.nextToken();
	}
	
	final public static int nextInt() throws IOException {
		return Integer.parseInt( nextToken() );
	}
	
	final public static long nextLong() throws IOException {
		return Long.parseLong( nextToken() );
	}
	
	final public static double nextDouble() throws IOException {
		return Double.parseDouble( nextToken() );
	}
	
	final public static boolean nextBoolean() throws IOException {
		return Boolean.parseBoolean( nextToken() );
	}
}
