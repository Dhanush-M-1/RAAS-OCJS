import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Vadim
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int ap = 0, bp = 0;
            int a = 0, b = 0;
            out.println("? " + ap + " " + bp);
            out.flush();
            int r = in.ni();
            for (int i = 29; i >= 0; i--) {
                int ab = 0, bb = 0;
                if (r != 0) { //a <> b
                    out.println("? " + (ap | (1 << i)) + " " + (bp | (1 << i)));
                    out.flush();
                    int ans = in.ni();
                    if (ans != r) {//1 0
                        ab = (r == 1) ? 1 : 0;
                        bb = (r == 1) ? 0 : 1;
                        ap |= (ab << i);
                        bp |= (bb << i);
                        out.println("? " + ap + " " + bp);
                        out.flush();
                        r = in.ni();
                    } else {
                        out.println("? " + (ap | (1 << i)) + " " + bp);
                        out.flush();
                        ans = in.ni();
                        if (ans == -1) { // 1 1
                            ap |= (1 << i);
                            bp |= (1 << i);
                        }
                    }
                } else {
                    out.println("? " + (ap | (1 << i)) + " " + bp);
                    out.flush();
                    int ans = in.ni();
                    if (ans == -1) { // 1 1
                        ap |= (1 << i);
                        bp |= (1 << i);
                    }
                }
            }
            out.println("! " + ap + " " + bp);
            out.flush();

        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String ns() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String rl = in.readLine();
                    if (rl == null) {
                        return null;
                    }
                    st = new StringTokenizer(rl);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int ni() {
            return Integer.parseInt(ns());
        }

    }
}

