import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Scanner;

public class C {

    static void solve() throws IOException {
        int n = nextInt();
        int[] a = new int[n];
        double r = Integer.MIN_VALUE;
        double l = Integer.MAX_VALUE;
        for ( int i = 0; i < n; i ++ ) {
            a[i] = nextInt();
            r = Math.max( r, a[i] );
            l = Math.min( l, a[i] );
        }
        double p1;
        double p2;
        do {
            double m1 = ( l * 2 + r ) / 3;
            double m2 = ( l + r * 2 ) / 3;
            p1 = poor( a, m1 );
            p2 = poor( a, m2 );
            if ( p1 < p2 ) {
                r = m2;
            } else {
                l = m1;
            }
        } while ( r - l > 1e-7 || Math.abs( p1 - p2 ) > 1e-7 );
        out.println( poor( a, ( l + r ) / 2 ) );
    }

    private static double poor( int[] a, double x ) {
        double maxp = 0.0;
        double maxm = 0.0;
        double lastp = 0.0;
        double longp = 0.0;
        double lastm = 0.0;
        double longm = 0.0;
        boolean plus = true;
        for ( int aa : a ) {
            double v = aa - x;
            if ( plus ) {
                if ( v > 0 ) {
                    lastp += v;
                    longp += v;
                    maxp = Math.max( maxp, longp );
                } else {
                    if ( longm > lastp ) {
                        longm -= lastp;
                    } else {
                        longm = 0;
                    }
                    longm -= v;
                    lastm = -v;
                    maxm = Math.max( maxm, longm );
                    plus = false;
                }
            } else {
                if ( v > 0 ) {
                    if ( longp > lastm ) {
                        longp -= lastm;
                    } else {
                        longp = 0;
                    }
                    longp += v;
                    lastp = v;
                    maxp = Math.max( maxp, longp );
                    plus = true;
                } else {
                    lastm -= v;
                    longm -= v;
                    maxm = Math.max( maxm, longm );
                }
            }
        }
        double r = Math.max( maxm, maxp );

//        double ans = 0.0;
//        for ( int i = 0; i < a.length; i ++ ) {
//            double s = 0.0;
//            for ( int j = i; j < a.length; j ++ ) {
//                s += a[j] - x;
//                ans = Math.max( ans, Math.abs( s ) );
//            }
//        }
//        if ( Math.abs( ans - r ) > 1e-6 ) {
//            out.println( Arrays.toString( a ) + " " + x + " " + ans + " vs " + r );
//            out.flush();
//            throw new RuntimeException();
//        }
        return r;
    }

    static StreamTokenizer in;
    static PrintWriter out;

    static int nextInt() throws IOException {
        in.nextToken();
        return ( int ) in.nval;
    }

    public static void main( String[] args ) throws IOException {
        in = new StreamTokenizer( new InputStreamReader( System.in ) );
        out = new PrintWriter( System.out );
        solve();
        out.close();
    }
}