import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
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
        AtA solver = new AtA(in, out);
        solver.solve(1);
        out.close();
    }

    static class AtA {
        private final FastScanner in;
        private final PrintWriter out;

        public AtA(FastScanner in, PrintWriter out) {
            this.in = in;
            this.out = out;
        }

        public void solve(int testNumber) throws IOException {
            char[] a = in.next().toCharArray();
            int ans = a.length;

            int s = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 'T') {
                    if (s > 0) {
                        s--;
                        ans -= 2;
                    } else {
                        s = 0;
                    }
                } else {
                    s++;
                }
            }

            out.println(ans);
        }

    }

    static class FastScanner {
        private final static int BUFFER_SIZE = 4096;
        private final InputStream in;
        private final StringBuilder sb = new StringBuilder();
        private byte[] buffer = new byte[BUFFER_SIZE];
        private int pos = 0;
        private int size;

        public FastScanner(InputStream inputStream) throws IOException {
            in = inputStream;
            size = 0;
        }

        public String next() {
            int c = skipWhitespace();
            if (c == -1) {
                return null;
            }

            sb.setLength(0);

            do {
                sb.append((char) c);
                c = read();
            } while (c > ' ');

            return sb.toString();
        }

        private int skipWhitespace() {
            while (true) {
                int c = read();
                if (c > ' ' || c == -1) {
                    return c;
                }
            }
        }

        private int read() {
            if (pos >= size) {
                try {
                    size = in.read(buffer, 0, BUFFER_SIZE);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (size <= 0) {
                    return -1;
                }
                pos = 0;
            }
            return buffer[pos++];
        }

    }
}

