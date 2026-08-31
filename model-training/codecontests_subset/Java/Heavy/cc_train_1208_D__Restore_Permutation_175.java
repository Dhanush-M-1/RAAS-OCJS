import java.io.*;
import java.nio.CharBuffer;
import java.util.NoSuchElementException;

public class P1208D {

    public static void main(String[] args) {
        SimpleScanner scanner = new SimpleScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        int n = scanner.nextInt();
        long[] s = new long[n];
        for (int i = 0; i < n; ++i)
            s[i] = scanner.nextLong();
        long[] bit = new long[n + 1];
        for (int i = 1; i <= n; ++i)
            bitUpdate(bit, i, i);
        int[] x = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            int l = 1;
            int r = n + 1;
            while (l < r) {
                int mid = (l + r) / 2;
                long sum = bitQuery(bit, mid - 1);
                if (sum <= s[i])
                    l = mid + 1;
                else
                    r = mid;
            }
            x[i] = l - 1;
            bitUpdate(bit, x[i], -x[i]);
        }
        for (int i = 0; i < n; ++i)
            writer.print(x[i] + " ");
        writer.println();

        writer.close();
    }

    private static long bitQuery(long[] bit, int x) {
        long sum = 0;
        for (; x >= 0; x = (x & (x + 1)) - 1)
            sum += bit[x];
        return sum;
    }

    private static void bitUpdate(long[] bit, int x, int val) {
        for (; x < bit.length; x = x | (x + 1))
            bit[x] += val;
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
