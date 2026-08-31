import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static MyScanner   in;
    static PrintWriter out;
//    static Timer timer = new Timer();

    static class SegmentTree {
        private int[] tree;
        private int ds;
        private int max;

        SegmentTree(int n, int max) {
            ds = n;
            tree = new int[2 * n];
            this.max = max;
        }

        public void inc(int pos, int cnt) {
            pos += ds;
            tree[pos] = Math.min(tree[pos] + cnt, max);
            pos /= 2;
            while (pos > 0) {
                tree[pos] = tree[2 * pos] + tree[2 * pos + 1];
                pos /= 2;
            }
        }

        public int get(int l, int r) {
            l += ds;
            r += ds;
            int res = 0;
            while (l <= r) {
                if (l % 2 != 0) res += tree[l++];
                if (r % 2 == 0) res += tree[r--];

                l /= 2;
                r /= 2;
            }
            return res;
        }
    }

    private static void solveA() throws IOException {
        int n = in.nextInt(), k = in.nextInt(), a = in.nextInt(), b = in.nextInt(), q = in.nextInt();

        SegmentTree sta = new SegmentTree(1 + n, a);
        SegmentTree stb = new SegmentTree(1 + n, b);

        while (q-- > 0) {
            int type = in.nextInt();
            switch (type) {
                case 1:
                    int d = in.nextInt(), cnt = in.nextInt();
                    sta.inc(d, cnt);
                    stb.inc(d, cnt);
                    break;

                case 2:
                    int day = in.nextInt();
                    out.println(stb.get(1, day - 1) + sta.get(day + k, n));
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        in = new MyScanner();
        out = new PrintWriter(System.out, false);
        solveA();
        out.close();
    }
}

class MyScanner {

    private final BufferedReader  br;
    private       StringTokenizer st;
    private       String          last;

    public MyScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public MyScanner(String path) throws IOException {
        br = new BufferedReader(new FileReader(path));
    }

    public MyScanner(String path, String decoder) throws IOException {
        br = new BufferedReader(new InputStreamReader(new FileInputStream(path), decoder));
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreElements())
            st = new StringTokenizer(br.readLine());
        last = null;
        return st.nextToken();
    }

    String nextLine() throws IOException {
        st = null;
        return (last == null) ? br.readLine() : last;
    }

    boolean hasNext() {
        if (st != null && st.hasMoreElements())
            return true;

        try {
            while (st == null || !st.hasMoreElements()) {
                last = br.readLine();
                st = new StringTokenizer(last);
            }
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }

    String[] nextStrings(int n) throws IOException {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = next();
        return arr;
    }

    String[] nextLines(int n) throws IOException {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextLine();
        return arr;
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    int[] nextInts(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextInt();
        return arr;
    }

    Integer[] nextIntegers(int n) throws IOException {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextInt();
        return arr;
    }

    int[][] next2Ints(int n, int m) throws IOException {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = nextInt();
        return arr;
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    long[] nextLongs(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextLong();
        return arr;
    }

    long[][] next2Longs(int n, int m) throws IOException {
        long[][] arr = new long[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                arr[i][j] = nextLong();
        return arr;
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next().replace(',', '.'));
    }

    double[] nextDoubles(int size) throws IOException {
        double[] arr = new double[size];
        for (int i = 0; i < size; i++)
            arr[i] = nextDouble();
        return arr;
    }

    boolean nextBool() throws IOException {
        String s = next();
        if (s.equalsIgnoreCase("true") || s.equals("1"))
            return true;

        if (s.equalsIgnoreCase("false") || s.equals("0"))
            return false;

        throw new IOException("Boolean expected, String found!");
    }
}