import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.InputMismatchException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Denis
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, FastReader in, PrintWriter out) {

            String x = in.next();
            String[] split = x.split("\\s++");
            String n1 = split[0];
            String n2 = split[1];
            out.println(n1 + " " + n2);
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                x = in.next();
                split = x.split("\\s++");
                String na1 = split[0];
                String na2 = split[1];
                if (na1.equals(n1)) {
                    out.println(n2 + " " + na2);
                    n1 = na2;
                } else if (na1.equals(n2)) {
                    out.println(n1 + " " + na2);
                    n2 = na2;
                } else if (na2.equals(n1)) {
                    out.println(n2 + " " + na1);
                    n1 = na1;
                } else {
                    out.println(n1 + " " + na1);
                    n2 = na1;
                }
            }
        }

    }

    static class FastReader {
        BufferedReader in;
        StringTokenizer tok;

        public FastReader(InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
            tok = new StringTokenizer("");
        }

        public String next() {
            String newLine = tryReadNextLine();
            if (newLine == null)
                throw new InputMismatchException();
            return newLine;
        }

        private String tryReadNextLine() {
            try {
                return in.readLine();
            } catch (Exception e) {
                throw new InputMismatchException();
            }
        }

        public String nextToken() {
            while (!tok.hasMoreTokens()) {
                tok = new StringTokenizer(next());
            }
            return tok.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

    }
}

