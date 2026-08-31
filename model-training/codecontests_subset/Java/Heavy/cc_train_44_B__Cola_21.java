import java.io.*;
import java.util.StringTokenizer;

/**
 * _44B
 * O(b*c) time
 * θ(1) space
 *
 * @author artyom
 */
public class _44B implements Runnable {
    private BufferedReader in;
    private StringTokenizer tok;

    private int solve() throws IOException {
        int n = nextInt(), a = nextInt() / 2, b = nextInt(), c = nextInt(), count = 0;
        for (int i = 0; i <= b; i++) {
            for (int j = 0; j <= c; j++) {
                int l = i + 2 * j;
                if (l > n) {
                    break;
                }
                if (n - l <= a) {
                    count++;
                }
            }
        }
        return count;
    }

    //--------------------------------------------------------------
    public static void main(String[] args) {
        new _44B().run();
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

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
}