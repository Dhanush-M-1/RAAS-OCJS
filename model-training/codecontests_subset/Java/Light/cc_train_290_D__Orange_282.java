import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class D implements Runnable {

    public void solve() throws IOException {
        char[] c = in.nextLine().toLowerCase().toCharArray();
        int n = in.nextInt();
        for ( int i = 0; i < c.length; i ++ ) {
            if ( c[i] < ( char ) ( n + 'a' ) ) {
                c[i] += 'A' - 'a';
            }
        }
        out.println( new String( c ) );
    }

    public Scanner in;

    public PrintWriter out;

    D() throws IOException {
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
        new Thread(new D()).start();
    }
}