import java.io.*;
import java.util.StringTokenizer;

public class A_Garden {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int readInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        pw.println(solve());
        pw.close();
    }

    private static int solve() throws IOException {
        int n = readInt();
        int k = readInt();

        int largestBucket = -1;
        for (int i = 0; i < n; i++) {
            int b = readInt();
            if ( k % b == 0 && largestBucket < b) largestBucket = b;
        }

        return k / largestBucket;
    }
}
