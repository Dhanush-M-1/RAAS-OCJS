import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    private static final JIn in = new JIn(32);
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();
        int a = 0, b = 1, c = n-1;
        if (arr[a] + arr[b] <= arr[c]) out.println((a+1) + " " + (b+1) + " " + (c+1));
        else out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        int t = in.nextInt();

        while (t-- > 0) solve();

        in.close();
        out.close();
    }

    public static class JIn {
        private final int BUFFER_SIZE;
        private final int LINE_LEN;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public JIn(int LINE_LEN) {
            BUFFER_SIZE = 65536;
            this.LINE_LEN = LINE_LEN;
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public JIn(int LINE_LEN, String fileName) throws IOException {
            BUFFER_SIZE = 65536;
            this.LINE_LEN = LINE_LEN;
            din = new DataInputStream(new FileInputStream(fileName));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String nextLine() throws IOException {
            byte[] buf = new byte[LINE_LEN];
            int count = 0;
            byte c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[count++] = c;
            }
            return new String(buf, 0, count);
        }

        public char nextChar() throws IOException {
            byte b = read();
            while (b <= ' ') b = read();
            return (char) b;
        }

        public int nextInt() throws IOException {
            int r = 0;

            byte c = read();
            while (c <= ' ') c = read();

            boolean neg = (c == '-');
            if (neg) c = read();

            do {
                r = r * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            return neg ? -r : r;
        }

        public long nextLong() throws IOException {
            long r = 0;

            byte c = read();
            while (c <= ' ') c = read();

            boolean neg = (c == '-');
            if (neg) c = read();

            do {
                r = r * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            return neg ? -r : r;
        }

        public double nextDouble() throws IOException {
            double r = 0, div = 1;

            byte c = read();
            while (c <= ' ') c = read();

            boolean neg = (c == '-');
            if (neg) c = read();

            do {
                r = r * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
                while ((c = read()) >= '0' && c <= '9')
                    r += (c - '0') / (div *= 10);

            return neg ? -r : r;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        public byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            din.close();
        }
    }
}
