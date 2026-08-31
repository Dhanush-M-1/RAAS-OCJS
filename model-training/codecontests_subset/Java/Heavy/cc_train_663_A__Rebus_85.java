import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private NotMyScanner in;
    private PrintWriter out;
//    private Timer timer = new Timer();

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    int lmin, lmax, rmin, rmax;

    boolean check(int x) {
        return lmin <= x && x <= lmax && rmin <= x && x <= rmax;
    }

    private void solve() throws IOException {
        String l = in.nextLine();
        String[] a = l.split(" ");
        int n = Integer.valueOf(a[a.length - 1]);
        ArrayList<Integer> pos = new ArrayList<>(), neg = new ArrayList<>();
        pos.add(0);
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i].equals("+")) {
                if (a[i + 1].equals("?")) {
                    pos.add(i + 1);
                }
            } else if (a[i].equals("-")) {
                if (a[i + 1].equals("?")) {
                    neg.add(i + 1);
                }
            }
        }
        lmin = pos.size();
        lmax = pos.size() * n;

        rmin = n + neg.size();
        rmax = n + n * neg.size();

        System.err.println(lmin + " " + lmax);
        System.err.println(rmin + " " + rmax);

        int res = -1;
        if (check(lmin)) {
            res = lmin;
        }
        if (check(lmax)) {
            res = lmax;
        }
        if (check(rmin)) {
            res = rmin;
        }
        if (check(rmax)) {
            res = rmax;
        }
        if (res == -1) {
            out.println("Impossible");
        } else {
            out.println("Possible");
            System.err.println(res);
            int need = res;
            for (int i = 0; i < pos.size(); i++) {
                int cur = Math.min(need - (pos.size() - 1 - i), n);
                a[pos.get(i)] = "" + cur;
                need -= cur;
            }
            need = res - n;
            for (int i = 0; i < neg.size(); i++) {
                int cur = Math.min(need - (neg.size() - 1 - i), n);
                a[neg.get(i)] = "" + cur;
                need -= cur;
            }
            for (String s : a) {
                out.print(s + " ");
            }
            out.println();
        }
    }

/*
    int ds = 12 * 31 * 24 * 60;
    int[] tree = new int[2 * ds];

    int getSum() {
        return tree[1];
    }

    void inc(int pos, int v) {
        pos += ds;
        while (pos > 0) {
            tree[pos] += v;
            pos /= 2;
        }
    }

    private void solve() throws IOException {
        int n = in.nextInt();
        while (n-- > 0) {
            String[] d = in.nextLine().split(" |\\.|:");
            int day = (Integer.valueOf(d[2]) - 1) * 31 + Integer.valueOf(d[1]) - 1;
            int hour = day * 24 + Integer.valueOf(d[3]);
            int min = hour * 60 + Integer.valueOf(d[4]);
            out.println(min);
            inc(min, Integer.valueOf(d[0]));
            out.println(Math.min(0, getSum()));
        }
    }*/

    private void run() throws IOException {
//        in = new NotMyScanner("B-small-attempt0.in");
        in = new NotMyScanner();
//        out = new PrintWriter(new FileOutputStream("res"), false);
        out = new PrintWriter(System.out, false);
        solve();
        out.close();
    }
}

class NotMyScanner {
    private final BufferedReader br;
    private StringTokenizer st;
    private String last;

    public NotMyScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public NotMyScanner(String path) throws IOException {
        br = new BufferedReader(new FileReader(path));
    }

    public NotMyScanner(String path, String decoder) throws IOException {
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
        } catch (Exception e) {
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