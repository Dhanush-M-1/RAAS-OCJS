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
 * @author Artem Gilmudinov
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Reader in = new Reader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, Reader in, PrintWriter out) {
            int n = in.ni();
            int m = in.ni();
            boolean[] used = new boolean[m];
            for (int i = 0; i < n; i++) {
                int x = in.ni();
                for (int j = 0; j < x; j++) {
                    used[in.ni() - 1] = true;
                }
            }
            for (int i = 0; i < m; i++) {
                if (!used[i]) {
                    out.println("NO");
                    return;
                }
            }
            out.println("YES");
        }

    }

    static class Reader {
        private BufferedReader in;
        private StringTokenizer st = new StringTokenizer("");
        private String delim = " ";

        public Reader(InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(rl());
            }
            return st.nextToken(delim);
        }

        public String rl() {
            try {
                return in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int ni() {
            return Integer.parseInt(next());
        }

    }
}

