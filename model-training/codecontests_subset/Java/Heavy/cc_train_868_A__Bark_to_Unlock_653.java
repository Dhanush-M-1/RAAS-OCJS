import java.io.*;
import java.util.StringTokenizer;

/**
 * 868A
 * θ(n) time
 * θ(n) space
 *
 * @author artyom
 */
public class _868A implements Runnable {
    private BufferedReader in;
    private StringTokenizer tok;

    private Object solve() throws IOException {
        CharSequence s = nextToken();
        boolean[] b = new boolean[2];
        for (int i = 0, n = nextInt(); i < n; i++) {
            CharSequence t = nextToken();
            if (s.charAt(0) == t.charAt(0) && s.charAt(1) == t.charAt(1)) {
                return "YES";
            }
            if (s.charAt(1) == t.charAt(0)) {
                b[1] = true;
            }
            if (s.charAt(0) == t.charAt(1)) {
                b[0] = true;
            }
        }
        return b[0] && b[1] ? "YES" : "NO";
    }

    //--------------------------------------------------------------
    public static void main(String[] args) {
        new _868A().run();
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            tok = null;
            System.out.print(solve());
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