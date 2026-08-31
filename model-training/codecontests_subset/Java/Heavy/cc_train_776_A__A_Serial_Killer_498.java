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
 * @author Mayur Kulkarni <mayurkulkarni012@gmail.com>
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        BladeReader in = new BladeReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, BladeReader in, PrintWriter out) {
            String n1 = in.nextString();
            String n2 = in.nextString();
            int size = in.nextInt();
            for (int i = 0; i < size; i++) {
                out.println(n1 + " " + n2);
                String t1 = in.nextString();
                String t2 = in.nextString();
                if (t1.equals(n1)) {
                    n1 = t2;
                    continue;
                } else if (t2.equals(n2)) {
                    n2 = t1;
                    continue;
                }
                if (n1.equals(t2)) {
                    n1 = t1;
                    continue;
                } else if (n2.equals(t1)) {

                    n2 = t2;
                    continue;
                }
            }
            out.println(n1 + " " + n2);
        }

    }

    static class BladeReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public BladeReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextString() {
            return next();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

