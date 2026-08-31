import java.io.*;
import java.util.*;

public class Main {
    //    private static long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }

    private void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            if (k % a == 0 && a > max) {
                max = a;
            }
        }
        out.print(k / max);
    }


    public static void main(String args[]) throws Exception {
        new Main().run();
    }

    private void run() throws Exception {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        InputReader in = new InputReader(inputStream);
        solve(in, out);
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() throws IOException {
            if (tokenizer == null)
                return reader.readLine();
            String line = "";
            if (tokenizer.hasMoreTokens())
                line = tokenizer.nextToken("");
            tokenizer = null;
            return line;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

}
