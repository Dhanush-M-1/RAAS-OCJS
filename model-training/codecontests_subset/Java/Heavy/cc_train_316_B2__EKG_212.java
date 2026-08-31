import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B implements Runnable {

    public void solve() throws IOException {
        int n = in.nextInt();
        int x = in.nextInt() - 1;
        int[] a = new int[n];
        int[] b = new int[n];
        Arrays.fill( b, -1 );
        for ( int i = 0; i < n; i ++ ) {
            a[i] = in.nextInt() - 1;
            if ( a[i] >= 0 ) {
                b[a[i]] = i;
            }
        }
        ArrayList < Integer > parts = new ArrayList<Integer>();
        int toAdd = -1;
        for ( int i = 0; i < n; i ++ ) {
            if ( a[i] >= 0 ) {
                continue;
            }
            int len = 1;
            boolean found = false;
            if ( i == x ) {
                toAdd = 1;
                found = true;
            }
            for ( int cur = i; b[cur] >= 0; cur = b[cur], len ++ ) {
//                out.println( cur + " " + b[cur] );
                if ( b[cur] == x ) {
                    toAdd = len + 1;
                    found = true;
                }
            }
            if ( !found ) {
                parts.add( len );
            }
        }
        boolean[] can = new boolean[n + 1];
        can[0] = true;
        for ( int p : parts ) {
            for ( int i = can.length - 1; i >= p; i -- ) {
                can[i] |= can[i - p];
            }
//            out.println( p );
        }
//        out.println( toAdd );
//        out.println();
        for ( int i = 0; i < can.length; i ++ ) {
            if ( can[i] ) {
                out.println( i + toAdd );
            }
        }
    }

    public Scanner in;

    public PrintWriter out;

    B() throws IOException {
        in = new Scanner(System.in);
        // in = new StreamTokenizer( new InputStreamReader( System.in ) );
        out = new PrintWriter(System.out);
    }

//    int nextInt() throws IOException {
//        in.nextToken();
//        return ( int ) in.nval;
//    }

    void check(boolean f, String msg) {
        if (!f) {
            out.close();
            throw new RuntimeException(msg);
        }
    }

    void close() throws IOException {
        out.close();
    }

    public void run() {
        try {
            solve();
            close();
        } catch (Exception e) {
            e.printStackTrace(out);
            out.flush();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        new Thread(new B()).start();
    }
}