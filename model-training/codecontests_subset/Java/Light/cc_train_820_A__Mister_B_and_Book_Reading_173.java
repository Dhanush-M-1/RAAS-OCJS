import java.io.*;
import java.util.StringTokenizer;

/**
 * _820A
 * O(c) time
 * θ(1) space
 *
 * @author artyom
 */
public class _820A implements Runnable {
    private BufferedReader in;
    private StringTokenizer tok;

    private int solve() throws IOException {
        int c = nextInt(), v = nextInt(), v1 = nextInt(), a = nextInt(), l = nextInt(), d = v, i = 1;
        while (d < c) {
            v = Math.min(v + a, v1);
            d += v - l;
            i++;
        }
        return i;
    }

    //--------------------------------------------------------------
    public static void main(String[] args) {
        new _820A().run();
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            tok = null;
            PrintStream out = System.out;
            out.print(solve());
            in.close();
        } catch (IOException e) {
            System.exit(0);
        }
    }

    private String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
}