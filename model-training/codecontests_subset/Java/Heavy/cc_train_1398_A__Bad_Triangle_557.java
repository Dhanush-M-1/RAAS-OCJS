import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A_ {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer st;

    private static int readInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        int T = readInt();
        while (T-- > 0) solve();
        pw.close();
    }

    private static void solve() throws IOException {
        int n = readInt();
        int first = readInt();
        int second = readInt();
        for (int i = 3; i < n; i++) {
            readInt();
        }
        int last = readInt();

        if (first + second <= last) pw.println("1 2 " + n);
        else pw.println(-1);
    }
}
