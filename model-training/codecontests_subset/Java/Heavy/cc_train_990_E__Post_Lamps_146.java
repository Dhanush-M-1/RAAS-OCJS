import java.io.*;
import java.util.StringTokenizer;

public class E1 {

    FastScanner scanner;
    PrintWriter writer;

    void solve() throws IOException {
        scanner = new FastScanner(System.in);
        writer = new PrintWriter(System.out);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[] ss = new int[m];
        int[] as = new int[k];

        for (int i = 0; i < m; i++)
            ss[i] = scanner.nextInt();

        for (int i = 0; i < k; i++)
            as[i] = scanner.nextInt();

        if (m > 0 && ss[0] == 0)
            writer.println(-1);
        else {
            int[] free = new int[n + 1];
            int prev = 0;
            int j = 0;
            for (int i = 1; i <= n; i++) {
                free[i] = prev;
                if (j < ss.length && ss[j] == i) {
                    j++;
                } else {
                    prev = i;
                }
            }

            long min = -1;
            for (int i = k; i >= 1; i--) {
                long c = lamps(i, n, free);
                if (c != -1 && (min == -1 || c * as[i - 1] < min))
                    min = c * as[i - 1];
            }

            writer.println(min);
        }

        writer.close();
    }

    int lamps(int l, int n, int[] free) {
        int c = 1;
        int prev = 0;
        for (int p = l + 1; p <= n; p = p + l + 1) {
            int f = free[p];
            if (f <= prev)
                return -1;
            p = f;
            prev = p;
            c++;
        }

        return c;
    }

    public static void main(String... args) throws IOException {
        new E1().solve();
    }

    static class FastScanner {

        BufferedReader br;
        StringTokenizer tokenizer;

        FastScanner(String fileName) throws FileNotFoundException {
            this(new FileInputStream(new File(fileName)));
        }

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String nextLine() throws IOException {
            tokenizer = null;
            return br.readLine();
        }

        String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    return null;
                }
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}
