import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
    FastScanner scanner;
    PrintWriter writer;

    void solve() throws Exception {
        scanner = new FastScanner(System.in);
        writer = new PrintWriter(System.out);

        int n = scanner.nextInt();
        int as = 0;
        int maxa = 0;

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            as += a;
            maxa = Math.max(a, maxa);
        }

        int k = Math.max(2 * as / n + 1, maxa);
        writer.println(k);

        writer.close();
    }

    public static void main(String[] args) throws Exception {
        new A().solve();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer tokenizer;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        FastScanner(File f) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(f));
        }

        String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(br.readLine(), " \n\r\t");
            }

            return tokenizer.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}
