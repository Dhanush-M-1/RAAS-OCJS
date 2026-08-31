import java.io.*;
import java.util.StringTokenizer;

public class C_CyclicPermutations {
    private static final int MOD = 1000000007;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static StringTokenizer st;

    private static int readInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    private static String readToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public static void main(String[] args) throws IOException {
        pw.println(solve());
        pw.close();
    }

    private static long solve() throws IOException {
        int n = readInt();

        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial = factorial * i % MOD;
        }

        long powerOf2 = 1;
        for (int i = 1; i <n; i++) {
            powerOf2 = powerOf2 * 2 % MOD;
        }

        return ((factorial - powerOf2) % MOD + MOD ) % MOD;
    }
}
