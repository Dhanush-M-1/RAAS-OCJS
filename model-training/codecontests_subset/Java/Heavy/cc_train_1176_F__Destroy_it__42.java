import java.io.*;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class P1176F {

    public static void main(String[] args) {
        SimpleScanner scanner = new SimpleScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int n = scanner.nextInt();
        long[][] f = new long[2][10];
        Arrays.fill(f[0], 0xF000000000000000L);
        f[0][0] = 0;
        int cur = 0;
        for (int i = 0; i < n; ++i) {
            int m = scanner.nextInt();
            long[] max1 = new long[3];
            long max2 = 0, max3 = 0;
            for (int j = 0; j < m; ++j) {
                int c = scanner.nextInt();
                int d = scanner.nextInt();
                switch (c) {
                    case 1:
                        if (d >= max1[0]) {
                            max1[2] = max1[1];
                            max1[1] = max1[0];
                            max1[0] = d;
                        } else if (d >= max1[1]) {
                            max1[2] = max1[1];
                            max1[1] = d;
                        } else if (d >= max1[2]) {
                            max1[2] = d;
                        }
                        break;
                    case 2:
                        max2 = Math.max(max2, d);
                        break;
                    default:
                        max3 = Math.max(max3, d);
                        break;
                }
            }
            long[][] g = new long[4][2];
            //g[0]
            g[0][0] = g[0][1] = 0;
            //g[1]
            g[1][0] = Math.max(max1[0], Math.max(max2, max3));
            g[1][1] = g[1][0] * 2;
            //g[2]
            g[2][0] = g[2][1] = 0xF000000000000000L;
            if (max1[0] > 0 && max1[1] > 0) {
                g[2][0] = max1[0] + max1[1];
                g[2][1] = max1[0] * 2 + max1[1];
            }
            if (max1[0] > 0 && max2 > 0) {
                g[2][0] = Math.max(g[2][0], max1[0] + max2);
                g[2][1] = Math.max(g[2][1], Math.max(max1[0], max2) * 2 + Math.min(max1[0], max2));
            }
            //g[3]
            g[3][0] = g[3][1] = 0xF000000000000000L;
            if (max1[0] > 0 && max1[1] > 0 && max1[2] > 0) {
                g[3][0] = max1[0] + max1[1] + max1[2];
                g[3][1] = max1[0] * 2 + max1[1] + max1[2];
            }
            cur ^= 1;
            System.arraycopy(f[cur ^ 1], 0, f[cur], 0, 10);
            for (int j = 0; j <= 9; ++j) {
                for (int k = 1; k <= Math.min(3, j); ++k) {
                    f[cur][j] = Math.max(f[cur][j], f[cur ^ 1][j - k] + g[k][0]);
                }
            }
            f[cur][0] = Math.max(f[cur][0], f[cur ^ 1][7] + g[3][1]);
            f[cur][0] = Math.max(f[cur][0], f[cur ^ 1][8] + g[2][1]);
            f[cur][0] = Math.max(f[cur][0], f[cur ^ 1][9] + g[1][1]);
            f[cur][1] = Math.max(f[cur][1], f[cur ^ 1][8] + g[3][1]);
            f[cur][1] = Math.max(f[cur][1], f[cur ^ 1][9] + g[2][1]);
            f[cur][2] = Math.max(f[cur][2], f[cur ^ 1][9] + g[3][1]);
        }
        long ans = 0;
        for (long v : f[cur])
            ans = Math.max(ans, v);
        writer.println(ans);

        writer.close();
    }

    private static class SimpleScanner {

        private static final int BUFFER_SIZE = 10240;

        private Readable in;
        private CharBuffer buffer;
        private boolean eof;

        SimpleScanner(InputStream in) {
            this.in = new BufferedReader(new InputStreamReader(in));
            buffer = CharBuffer.allocate(BUFFER_SIZE);
            buffer.limit(0);
            eof = false;
        }


        private char read() {
            if (!buffer.hasRemaining()) {
                buffer.clear();
                int n;
                try {
                    n = in.read(buffer);
                } catch (IOException e) {
                    n = -1;
                }
                if (n <= 0) {
                    eof = true;
                    return '\0';
                }
                buffer.flip();
            }
            return buffer.get();
        }

        void checkEof() {
            if (eof)
                throw new NoSuchElementException();
        }

        char nextChar() {
            checkEof();
            char b = read();
            checkEof();
            return b;
        }

        String next() {
            char b;
            do {
                b = read();
                checkEof();
            } while (Character.isWhitespace(b));
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(b);
                b = read();
            } while (!eof && !Character.isWhitespace(b));
            return sb.toString();
        }

        int nextInt() {
            return Integer.valueOf(next());
        }

        long nextLong() {
            return Long.valueOf(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
