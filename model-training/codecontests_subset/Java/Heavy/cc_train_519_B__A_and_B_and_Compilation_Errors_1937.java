import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Hedin on 22-Mar-15.
 */
public class Round294ProblemB {

    static void solve() {
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n - 1];
        int[] c = new int[n - 2];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 2; i++) {
            c[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        int ansB = 0;
        int ansC = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] != b[i]) {
                ansB = a[i];
                break;
            }
        }
        if (ansB == 0) {
            ansB = a[n - 1];
        }
        for (int i = 0; i < n - 2; i++) {
            if (b[i] != c[i]) {
                ansC = b[i];
                break;
            }
        }
        if (ansC == 0) {
            ansC = b[n - 2];
        }
        pw.println(ansB);
        pw.println(ansC);
    }

    static ContestScanner sc;
    static PrintWriter pw;

    public static void main(String[] args) {
        sc = new ContestScanner(System.in);
        pw = new PrintWriter(System.out);

        solve();

        sc.close();
        pw.flush();
        pw.close();
    }

    static class ContestScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public ContestScanner(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public void close() {
            try {
                reader.close();
            } catch (IOException ignored) {}
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String s = null;
                try {
                    s = reader.readLine();
                } catch (IOException ignored) {}
                if (s == null) {
                    return null;
                }
                tokenizer = new StringTokenizer(s);
            }
            return tokenizer.nextToken();
        }

        boolean hasMoreTokens() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String s = null;
                try {
                    s = reader.readLine();
                } catch (IOException ignored) {}
                if (s == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(s);
            }
            return true;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
