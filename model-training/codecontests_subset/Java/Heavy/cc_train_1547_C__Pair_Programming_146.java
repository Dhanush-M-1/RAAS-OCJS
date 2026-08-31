import java.util.*;
import java.io.*;

public class C {

    int[][] dp;
    int[] a, b;
    int[] prefLineA, prefLineB;

    int[][] nxt;

    int k, m, n;

    public void prayGod() throws IOException {
        int t = nextInt();
        while (t-- > 0) {
            k = nextInt();
            n = nextInt();
            m = nextInt();

            a = nextIntArray(n);
            b = nextIntArray(m);

            prefLineA = new int[n];
            prefLineB = new int[m];

            prefLineA[0] = (a[0] == 0 ? 1 : 0);
            prefLineB[0] = (b[0] == 0 ? 1 : 0);

            for (int i = 1; i < n; i++) {
                prefLineA[i] = prefLineA[i - 1] + (a[i] == 0 ? 1 : 0);
            }

            for (int i = 1; i < m; i++) {
                prefLineB[i] = prefLineB[i - 1] + (b[i] == 0 ? 1 : 0);
            }

            dp = new int[n + 1][m + 1];
            nxt = new int[n + 1][m + 1];

            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], -1);
                Arrays.fill(nxt[i], -1);
            }

            dp[n][m] = 1;

            int possible = solve(0, 0);
            if (possible == 0)
                out.println(-1);
            else {
                ArrayList<Integer> ret = new ArrayList<>();
                int x = 0, y = 0;
                for (int i = 0; i < n + m; i++) {
                    if (nxt[x][y] == 1) {
                        ret.add(a[x++]);
                    } else if (nxt[x][y] == 2) {
                        ret.add(b[y++]);
                    } else {
                        System.exit(1);
                    }
                }
                for (int val : ret)
                    out.printf("%d ", val);
                out.println();
            }
        }
    }

    public int solve(int i, int j) {
        if (i > n || j > m)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int totalLine = k + (i - 1 >= 0 ? prefLineA[i - 1] : 0) + (j - 1 >= 0 ? prefLineB[j - 1] : 0);
        int ret = 0;
        if (i < n) {
            if (a[i] <= totalLine) {
                ret |= solve(i + 1, j);
                if (ret == 1) {
                    nxt[i][j] = 1;
                    return dp[i][j] = ret;
                }
            }

        }
        if (j < m) {
            if (b[j] <= totalLine) {
                ret |= solve(i, j + 1);
                if (ret == 1) {
                    nxt[i][j] = 2;
                    return dp[i][j] = ret;
                }
            }
        }
        return dp[i][j] = ret;
    }

    public void printVerdict(boolean verdict) {
        if (verdict)
            out.println(VERDICT_YES);
        else
            out.println(VERDICT_NO);
    }

    static final String VERDICT_YES = "YES";
    static final String VERDICT_NO = "NO";
    static final boolean RUN_TIMING = true;
    static final boolean AUTOFLUSH = false;
    static final boolean FILE_INPUT = false;
    static final boolean FILE_OUTPUT = false;

    static int iinf = 0x3f3f3f3f;
    static long inf = (long) 1e18 + 10;
    static long mod = (long) 1e9 + 7;

    static char[] inputBuffer = new char[1 << 20];
    static PushbackReader in = new PushbackReader(new BufferedReader(new InputStreamReader(System.in)), 1 << 20);
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), AUTOFLUSH);

    // int data-type
    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public int[] nextIntArray(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextInt();
        return arr;
    }

    public void sort(int[] a) {
        shuffle(a);
        Arrays.sort(a);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            out.print(arr[i] + " ");
        out.println();
    }

    // long data-type
    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public long[] nextLongArray(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextLong();
        return arr;
    }

    public static void printArray(long[] arr) {
        for (int i = 0; i < arr.length; i++)
            out.print(arr[i] + " ");
        out.println();
    }

    public void sort(long[] a) {
        shuffle(a);
        Arrays.sort(a);
    }

    // double data-type
    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public double[] nextDoubleArray(int n) throws IOException {
        double[] arr = new double[n];
        for (int i = 0; i < n; i++)
            arr[i] = nextDouble();
        return arr;
    }

    public static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++)
            out.print(arr[i] + " ");
        out.println();
    }

    // Generic type
    public <T> void sort(T[] a) {
        shuffle(a);
        Arrays.sort(a);
    }

    public static <T> void printArray(T[] arr) {
        for (int i = 0; i < arr.length; i++)
            out.print(arr[i] + " ");
        out.println();
    }

    public String next() throws IOException {
        int len = 0;
        int c;
        do {
            c = in.read();
        } while (Character.isWhitespace(c) && c != -1);
        if (c == -1) {
            throw new NoSuchElementException("Reached EOF");
        }
        do {
            inputBuffer[len] = (char) c;
            len++;
            c = in.read();
        } while (!Character.isWhitespace(c) && c != -1);
        while (c != '\n' && Character.isWhitespace(c) && c != -1) {
            c = in.read();
        }
        if (c != -1 && c != '\n') {
            in.unread(c);
        }
        return new String(inputBuffer, 0, len);
    }

    public String nextLine() throws IOException {
        int len = 0;
        int c;
        while ((c = in.read()) != '\n' && c != -1) {
            if (c == '\r') {
                continue;
            }
            inputBuffer[len] = (char) c;
            len++;
        }
        return new String(inputBuffer, 0, len);
    }

    public boolean hasNext() throws IOException {
        String line = nextLine();
        if (line.isEmpty()) {
            return false;
        }
        in.unread('\n');
        in.unread(line.toCharArray());
        return true;
    }

    public void shuffle(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = (int) (Math.random() * (n - i));
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public void shuffle(long[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = (int) (Math.random() * (n - i));
            long temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public void shuffle(Object[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = (int) (Math.random() * (n - i));
            Object temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        if (FILE_INPUT)
            in = new PushbackReader(new BufferedReader(new FileReader(new File("output.txt"))), 1 << 20);
        if (FILE_OUTPUT)
            out = new PrintWriter(new FileWriter(new File("output.txt")));

        long time = 0;
        time -= System.nanoTime();
        new C().prayGod();
        time += System.nanoTime();

        if (RUN_TIMING)
            System.err.printf("%.3f ms%n", time / 1000000.0);

        out.flush();
        in.close();
    }
}
