import java.util.Arrays;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.io.InputStream;
import java.util.Comparator;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    InputStream is;

    int __t__ = 1;
    int __f__ = 0;
    int __FILE_DEBUG_FLAG__ = __f__;
    String __DEBUG_FILE_NAME__ = "src/main/java/E1";

    FastScanner in;
    PrintWriter out;

    class State {
        final int k;
        final int v;

        public State(int k, int v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public String toString() {
            return "State{" +
                    "k=" + k +
                    ", v=" + v +
                    '}';
        }
    }

    public void solve() {
        int T = in.nextInt();
        for (int _t = 0; _t < T; _t++) {
            int N = in.nextInt();
            int[] K = new int[N];
            int[] L = new int[N];
            int[] R = new int[N];

            int b = 0;
            for (int i = 0; i < N; i++) {
                K[i] = in.nextInt();
                L[i] = in.nextInt();
                R[i] = in.nextInt();
                if (L[i] <= R[i]) b++;
            }
            State[] st1 = new State[b];
            State[] st2 = new State[N-b];
            int c1 = 0, c2 = 0;
            for (int i = 0; i < N; i++) {
                if (L[i] <= R[i]) {
                    st1[c1++] = new State(N - K[i], R[i] - L[i]);
                } else {
                    st2[c2++] = new State(K[i], L[i] - R[i]);
                }
            }
            Arrays.sort(st1, Comparator.comparingInt(s -> s.k));
            Arrays.sort(st2, Comparator.comparingInt(s -> s.k));

            long res = 0;
            for (int i = 0; i < N; i++) {
                res += Math.min(L[i], R[i]);
            }
            res += calc(st1);
            res += calc(st2);
            System.out.println(res);
        }
        /*
        int n = in.nextInt();
        char[] s = in.next().toCharArray();

        int bits = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') bits++;
        }
        int[][] y = new int[3][n];
        for (int i = 0; i < 3; i++) {
            int x = bits + i - 1;
            if (x <= 0) continue;

            y[i][n-1] = 1 % x;
            for (int j = n - 1; j >= 1; j--) {
                y[i][j-1] = (y[i][j] * 2) % x;
            }
        }

        int[] sum = new int[3];
        for (int i = 0; i < 3; i++) {
            int x = bits + i - 1;
            for (int j = 0; j < n; j++) {
                if (s[i] == '1') {
                    sum[i] = (sum[i] + y[i][j]) % x;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int b;
            if (s[i] == '0') {
                b = 2;
            } else {
                b = 0;
            }
            if (bits + b - 1 == 0) {
                System.out.println("0");
                continue;
            }
            int t = bits + b - 1;
            int cur = b == 2 ? ((sum[b] + y[b][i]) % t) : ((sum[b] - y[b][i] + t) % t);
            System.out.println(cur);
            int res = 1;
            while (cur != 0) {
                cur %= Long.bitCount(cur);
                res++;
            }
            System.out.println(res);

            char p = s[i];
            s[i] = s[i] == '1' ? '0' : '1';
            long x = Long.valueOf(String.valueOf(s), 2);
            List<Long> l = new ArrayList<>();
            l.add(x);
            while (x != 0) {
                x %= Long.bitCount(x);
                l.add(x);
            }
            System.out.println(i + ": " + l);
            s[i] = p;
        }

         */
    }

    private long calc(State[] st) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < st.length; i++) {
            if (st[i].k > pq.size()) {
                pq.add(st[i].v);
            } else if (!pq.isEmpty() && st[i].v > pq.peek()) {
                pq.poll();
                pq.add(st[i].v);
            }
        }
        long res = 0;
        while (!pq.isEmpty()) res += pq.poll();
        return res;
    }

    public void run() {
        if (__FILE_DEBUG_FLAG__ == __t__) {
            try {
                is = new FileInputStream(__DEBUG_FILE_NAME__);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("FILE_INPUT!");
        } else {
            is = System.in;
        }
        in = new FastScanner(is);
        out = new PrintWriter(System.out);

        solve();
    }

    public static void main(final String[] args) {
        new Main().run();
    }
}


class FastScanner {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public FastScanner(InputStream stream) {
        this.stream = stream;
        // stream = new FileInputStream(new File("dec.in"));
    }

    int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public boolean isEndline(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = nextInt();

        return array;
    }

    public int[][] nextIntMap(int n, int m) {
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = nextIntArray(m);
        }
        return map;
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++)
            array[i] = nextLong();

        return array;
    }

    public long[][] nextLongMap(int n, int m) {
        long[][] map = new long[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = nextLongArray(m);
        }
        return map;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public double[] nextDoubleArray(int n) {
        double[] array = new double[n];
        for (int i = 0; i < n; i++)
            array[i] = nextDouble();

        return array;
    }

    public double[][] nextDoubleMap(int n, int m) {
        double[][] map = new double[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = nextDoubleArray(m);
        }
        return map;
    }

    public String next() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public String[] nextStringArray(int n) {
        String[] array = new String[n];
        for (int i = 0; i < n; i++)
            array[i] = next();

        return array;
    }

    public String nextLine() {
        int c = read();
        while (isEndline(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndline(c));
        return res.toString();
    }

    public int[][] nextPackedIntArrays(int packN, int size) {
        int[][] res = new int[packN][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < packN; j++) {
                res[j][i] = nextInt();
            }
        }
        return res;
    }
}
