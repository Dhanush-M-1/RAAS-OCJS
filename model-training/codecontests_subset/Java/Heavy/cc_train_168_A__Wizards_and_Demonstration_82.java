import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {

    public static void main( final String[] args ) throws Exception {
        final BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        final String[] parts = br.readLine().split( " " );
        final int n = Integer.parseInt( parts[0] );
        final int x = Integer.parseInt( parts[1] );
        final int y = Integer.parseInt( parts[2] );
        System.out.println( solve( n, x, y ) );
    }

    public static int solve( final int n, final int x, final int y ) {
        final int n_ = y * n;
        int r_ = n_ / 100;
        if ( n_ % 100 > 0 ) ++r_;
        return r_ <= x ? 0 : r_ - x;
    }

}
