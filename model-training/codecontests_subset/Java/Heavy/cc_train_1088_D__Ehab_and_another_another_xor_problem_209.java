import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author NMouad21
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DEhabAndAnotherAnotherXorProblem solver = new DEhabAndAnotherAnotherXorProblem();
        solver.solve(1, in, out);
        out.close();
    }

    static class DEhabAndAnotherAnotherXorProblem {
        private Scanner IN = new Scanner(System.in);

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            boolean[] same = new boolean[30];
            int lastCmp = ask(0, 0);

            int a = 0, b = 0;
            for (int i = 29; i >= 0; --i) {
                int cmp = ask(a | 1 << i, b | 1 << i);
                if (cmp == lastCmp) {
                    same[i] = true;
                } else {
                    if (cmp < 0) {
                        a |= 1 << i;
                    } else {
                        b |= 1 << i;
                    }
                    lastCmp = ask(a, b);
                }
            }

            for (int i = 29; i >= 0; --i) {
                if (same[i]) {
                    int cmp = ask(a | 1 << i, b);
                    if (cmp < 0) {
                        a |= 1 << i;
                        b |= 1 << i;
                    }
                }
            }

            System.out.println("! " + a + " " + b);
            System.out.flush();
        }

        private final int ask(int c, int d) {
            System.out.println("? " + c + " " + d);
            System.out.flush();
            int ret = IN.nextInt();
            if (ret == -2) {
                throw new IllegalStateException("Shouldn't happen :)!");
            }
            return ret;
        }

    }

    static class InputReader {
        private InputStream stream;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

    }
}

