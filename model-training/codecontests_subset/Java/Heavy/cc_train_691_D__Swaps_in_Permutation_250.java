import java.io.*;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Random;

public class FastReading implements Runnable {

    private InputReader in;
    private OutputWriter out;

    private void init() throws FileNotFoundException {
        in = new InputReader(System.in);
        out = new OutputWriter(System.out);
    }


    int readInt() {
        return in.readInt();
    }

    int[] readIntArray(int size) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = readInt();
        }
        return a;
    }

    public static void main(String[] args) {
        //new Thread(null, new _Solution(), "", 128 * (1L << 20)).start();
        new FastReading().run();
    }

    long timeBegin, timeEnd;

    void time() {
        timeEnd = System.currentTimeMillis();
        System.err.println("Time = " + (timeEnd - timeBegin));
    }

    @Override
    public void run() {
        try {
            timeBegin = System.currentTimeMillis();
            init();
            solve();
            out.close();
            time();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void solve() {
        int n = readInt();
        int m = readInt();
        int[] a = readIntArray(n);

        DSU dsu = new DSU(n);
        for (int i = 0; i < m; i++) {
            int u = readInt() - 1;
            int v = readInt() - 1;
            dsu.merge(u, v);
        }

        PriorityQueue<Integer>[] q = new PriorityQueue[n];
        for (int i = 0; i < n; i++) {
            int set = dsu.find(i);
            if (q[set] == null) {
                q[set] = new PriorityQueue<>();
            }
            q[set].add(-a[i]);
        }

        for (int i = 0; i < n; i++) {
            int set = dsu.find(i);
            a[i] = -q[set].poll();
        }

        for (int x : a) {
            out.print(x + " ");
        }
    }

    class DSU {
        int[] p;
        Random rand = new Random();

        public DSU(int size) {
            p = new int[size];
            for (int i = 0; i < size; i++) {
                p[i] = i;
            }
        }

        int find(int x) {
            return p[x] == x ? x : (p[x] = find(p[x]));
        }

        void merge(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            if (rand.nextBoolean()) {
                p[a] = b;
            } else {
                p[b] = a;
            }
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}