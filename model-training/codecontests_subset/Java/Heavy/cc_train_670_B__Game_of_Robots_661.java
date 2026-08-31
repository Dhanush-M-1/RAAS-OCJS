import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @author ramilagger
 */
public class Main {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    int n;

    public void solve() throws Exception {
        int n = nextInt();
        int cnt = 1;
        int k = nextInt();
        int[] a = nextArray(n);
        while (k > cnt){
            k-= cnt++;
        }
        pw.println(a[k - 1]);
    }

    public void run() throws Exception {
        long start = System.currentTimeMillis();
        solve();
        if (!ONLINE_JUDGE) {
            long end = System.currentTimeMillis();
            System.err.println(end - start + " ms");
        }
        pw.close();
    }

    public Main() throws Exception {

        br = (ONLINE_JUDGE) ? new BufferedReader(new InputStreamReader(System.in))
                : new BufferedReader(new FileReader("in.txt"));

        pw = (ONLINE_JUDGE) ?
                new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))
                : new PrintWriter(new BufferedWriter(new FileWriter("out.txt")));

    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public BigInteger nextBigInteger() throws IOException {
        return new BigInteger(next());
    }

    public String nextLine() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            return br.readLine();
        }
        StringBuilder sb = new StringBuilder(st.nextToken());
        while (st.hasMoreTokens()) {
            sb.append(" " + st.nextToken());
        }
        return sb.toString();
    }

    public int[] nextArray(int n) throws IOException {
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nextInt();
        }
        return temp;
    }

    public long[] nextLArray(int n) throws IOException {
        long[] temp = new long[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nextLong();
        }
        return temp;
    }

    final BufferedReader br;
    final PrintWriter pw;
    StringTokenizer st;
}