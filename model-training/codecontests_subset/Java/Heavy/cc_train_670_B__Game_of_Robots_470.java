import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tok = null;

    private static String nextToken() throws IOException {
        if (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }

        return tok.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public static void main(String[] args) throws IOException {
        int n = nextInt();
        long k = nextInt() - 1;
        int[] id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = nextInt();
        }

        long m = 1;
        for (; m * (m + 1) <= 2 * k; m++);
        m--;
        long l = k - (m * (m + 1) / 2);
        System.out.println(id[(int) l]);

//        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
        // 1 2 4 7 11 16 22 29
        // 3 5 8 12 17 23 30
        // 6 9 13 18
        // 1, 2, 3, 4, ...
        // n (n + 1) / 2 + i = k
        // n^2 + n = 2k
        // 2k >= n^2
        // sqrt(2k) >= n
        // n (n + 1) / 2 + i = k
        // n (n + 1) + 2i = 2k

    }
}
