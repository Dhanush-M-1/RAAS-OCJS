import java.io.*;
import java.util.*;

public class Main {

    private static void run(Reader in, PrintWriter out) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        long sum = 0;
        long[] max = new long[n];
        for (int i = 0; i < n; i++) {
            sum += a[i];
            max[i] = sum;
            if (i != 0 && max[i] < max[i - 1]) max[i] = max[i - 1];
        }

        for (int i = 0; i < m; i++) {
            long x = in.nextInt();
            long ans;
            if (max[n - 1] >= x) {
                ans = cost(x, max);
            } else if (sum <= 0) {
                ans = -1;
            } else {
                long round = x / sum;
                long remain = x % sum;
                long adjust = (max[n - 1] - remain) / sum;

                remain += adjust * sum;
                round -= adjust;
                ans = cost(remain, max) + round * n;
            }
            out.print(ans);
            out.print(' ');
        }
        out.println();
    }

    static int cost(long x, long[] max) {
        int left = 0;
        int right = max.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (max[mid] >= x) {
                right = mid;
            } else if (max[mid] < x) {
                left = mid + 1;
            }
        }
        return max[left] >= x ? left : -1;
    }

    public static void main(String[] args) throws IOException {
        Reader in = new Reader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            run(in, out);
        }

        out.flush();
        in.close();
        out.close();
    }

    static class Reader {
        BufferedReader reader;
        StringTokenizer st;

        Reader(InputStreamReader stream) {
            reader = new BufferedReader(stream, 32768);
            st = null;
        }

        void close() throws IOException {
            reader.close();
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() throws IOException {
            return reader.readLine();
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

    }
}