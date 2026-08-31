import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.BufferedOutputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Kattio in = new Kattio(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, Kattio in, PrintWriter out) {
            int r1 = in.nextInt();
            int r2 = in.nextInt();
            int c1 = in.nextInt();
            int c2 = in.nextInt();
            int d1 = in.nextInt();
            int d2 = in.nextInt();

            int a = (2 * d1 - c2 - r2 + d2) >> 1;
            int b = (r1 - a);
            int c = (c1 - a);
            int d = (d1 - a);

            if (a <= 0 || b <= 0 || c <= 0 || d <= 0 || a >= 10 || b >= 10 || c >= 10 || d >= 10) {
                out.println(-1);
            } else if (r1 != a + b || r2 != c + d || c1 != a + c || c2 != b + d || d1 != a + d || d2 != c + b) {
                out.println(-1);
            } else if (a != b && a != c && a != d && b != c && b != d && c != d) {
                out.println(a + " " + b);
                out.println(c + " " + d);
            } else {
                out.println(-1);
            }
        }

    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private String line;
        private StringTokenizer st;
        private String token;

        public Kattio(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public Kattio(InputStream i, OutputStream o) {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        private String peekToken() {
            if (token == null)
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        line = r.readLine();
                        if (line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException e) {
                }
            return token;
        }

        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }

    }
}

