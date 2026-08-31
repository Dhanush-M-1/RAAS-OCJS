import javax.annotation.processing.SupportedSourceVersion;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = /*new InputReader(new FileReader("input.txt"));*/   new InputReader(inputStream);
        PrintWriter out = /*new PrintWriter("output.txt"); */  new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(in, out);
        out.close();
    }

    private static class TaskB {

        static final long max = 1000000000000000000L;
        static final double eps = 0.0000001;
        static final long mod = 1000000007;

        void solve(InputReader in, PrintWriter out) throws IOException {

            int K = in.nextInt();

            String A[][] = new String[K][K];

            for (int i = 1; i < K; i++)
                for (int j = 1; j < K; j++)
                    A[i][j] = Integer.toString(i * j, K);

            for (int i = 1; i < K; i++) {
                for (int j = 1; j < K; j++)
                    out.print(A[i][j] + " ");
                out.println();
            }
        }

        long gcd(long A, long B) {
            if (B == 0) return A;
            return gcd(B, A % B);
        }

        boolean isPrime(long n) {
            if (n <= 1 || n > 3 && (n % 2 == 0 || n % 3 == 0))
                return false;
            for (long i = 5, j = 2; i * i <= n; i += j, j = 6 - j)
                if (n % i == 0)
                    return false;
            return true;
        }

        boolean isEqual(double A, double B) {
            return Math.abs(A - B) < eps;
        }

        double dist(double X1, double Y1, double X2, double Y2) {
            return Math.sqrt((X1 - X2) * (X1 - X2) + (Y1 - Y2) * (Y1 - Y2));
        }

        boolean nextPer(int[] data) {
            int i = data.length - 1;
            while (i > 0 && data[i] < data[i - 1]) {
                i--;
            }
            if (i == 0) {
                return false;
            }
            int j = data.length - 1;
            while (data[j] < data[i - 1]) {
                j--;
            }
            int temp = data[i - 1];
            data[i - 1] = data[j];
            data[j] = temp;
            Arrays.sort(data, i, data.length);
            return true;
        }

        long pow(long A, long B, long MOD) {
            if (B == 0) {
                return 1;
            }
            if (B == 1) {
                return A;
            }
            long val = pow(A, B / 2, MOD);
            if (B % 2 == 0) {
                return val * val % MOD;
            } else {
                return val * (val * A % MOD) % MOD;
            }
        }
    }

    private static class InputReader {
        StringTokenizer st;
        BufferedReader br;

        public InputReader(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public InputReader(FileReader s) throws FileNotFoundException {
            br = new BufferedReader(s);
        }

        public String next() {
            while (st == null || !st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public boolean ready() {
            try {
                return br.ready();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}