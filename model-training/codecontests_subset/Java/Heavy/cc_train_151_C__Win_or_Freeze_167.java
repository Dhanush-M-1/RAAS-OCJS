import java.io.BufferedReader;
import java.io.InputStreamReader;

public class con107_C {

    public static void main( final String[] args ) throws Exception {
        final BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        final long l = Long.parseLong( br.readLine() );

        for ( long p1 = 2; p1 * p1 <= l; ++p1 ) {
            if ( l % p1 == 0 ) {
                final long p = l / p1;
                for ( long p2 = 2; p2 * p2 <= p; ++p2 ) {
                    if ( p % p2 == 0 ) {
                        System.out.println( "1" );
                        System.out.println( p1 * p2 );
                        return;
                    }
                }
                System.out.println( "2" );
                //System.out.println( p1 );
                return;
            }
        }
        System.out.println( "1" );
        System.out.println( 0 );
    }

}
