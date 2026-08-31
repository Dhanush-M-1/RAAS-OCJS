import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Denis Nedelyaev
 */
public class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB(in, out);
        solver.solve(1);
        out.close();
    }

    static class TaskB {
        private final FastScanner in;
        private final PrintWriter out;

        public TaskB(FastScanner in, PrintWriter out) {
            this.in = in;
            this.out = out;
        }

        public void solve(int testNumber) throws IOException {
            String eq = in.readLine();
            String[] elements = eq.split(" ");
            int n = Integer.parseInt(elements[elements.length - 1]);
            int q = (elements.length - 1) / 2;
            int[] min = new int[q];
            int[] max = new int[q];
            min[q - 1] = n;
            max[q - 1] = n;
            for (int i = q - 2; i >= 0; i--) {
                int sign = elements[2 * i + 1].equals("+") ? +1 : -1;
                if (sign > 0) {
                    min[i] = min[i + 1] - n;
                    max[i] = max[i + 1] - 1;
                } else {
                    min[i] = min[i + 1] + 1;
                    max[i] = max[i + 1] + n;
                }
            }
            if (max[0] < 1 || min[0] > n) {
                out.println("Impossible");
                return;
            }

            out.println("Possible");

            int c = Math.max(1, min[0]);
            out.print(c);
            out.print(' ');
            for (int i = 1; i < q; i++) {
                int sign = elements[2 * i - 1].equals("+") ? +1 : -1;

                int x;
                if (sign > 0) {
                    x = Math.min(n, max[i] - c);
                    c += x;
                } else {
                    x = Math.min(n, c - min[i]);
                    c -= x;
                }
                if (x < 1 || x > n) {
                    throw new AssertionError();
                }
                if (c < min[i] || c > max[i]) {
                    throw new AssertionError();
                }

                out.print(elements[2 * i - 1]);
                out.print(' ');
                out.print(x);
                out.print(' ');
            }
            out.print("= ");
            out.println(n);
        }

    }

    static class FastScanner {
        private final BufferedReader br;
        private String line;
        private int pos;

        public FastScanner(String s) throws IOException {
            this(new StringReader(s));
        }

        public FastScanner(InputStream is) throws IOException {
            this(new InputStreamReader(is, "UTF-8"));
        }

        public FastScanner(Reader reader) throws IOException {
            this(new BufferedReader(reader));
        }

        public FastScanner(BufferedReader reader) throws IOException {
            br = reader;
            line = br.readLine();
            pos = 0;
        }

        public String readLine() throws IOException {
            String prevLine = line.substring(pos);
            line = br.readLine();
            pos = 0;
            return prevLine;
        }

    }
}

