import java.io.*;
import java.util.*;
import java.math.*;

public class p578c {
    public static double[] a = new double[200010];
    public static double[] b = new double[200010];

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextDouble();
        }
        double low = Double.MAX_VALUE, high = Double.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, a[i]);
            high = Math.max(high, a[i]);
        }
        double[] res = new double[2];
        double x1, x2;
        for (int i = 1; i <= 100; i++) {
            double mid = (low + high) / 2.0;
            res = f(mid, n);
            x1 = res[0]; x2 = res[1];
            if (x1 > x2) low = mid;
            else high = mid;
        }
        double mid = (low + high) / 2.0;
        res = f(mid, n);
        x1 = res[0]; x2 = res[1];
        out.println(Math.max(x1, x2));
        out.close();
    }

    public static double[] f(double x, int n) {
        double[] res = new double[2];
        for (int i = 0; i < n; i++) {
            b[i] = a[i] - x;
        }
        double x1 = g(b, n);
        for (int i = 0; i < n; i++) {
            b[i] *= -1;
        }
        double x2 = g(b, n);
        res[0] = x1; res[1] = x2;
        return res;
    }

    public static double g(double[] arr, int n) {
        double max = 0.0, cur = 0.0;
        for (int i = 0; i < n; i++) {
            cur += arr[i];
            if (cur > max) max = cur;
            if (cur < 0) cur = 0;
        }
        return max;
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair p) {
            return x < p.x ? -1 : x > p.x ? 1 : 0;
        }
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public boolean hasMoreElements() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                String s;
                try {
                    s = reader.readLine();
                } catch (IOException e) {
                    return false;
                }
                tokenizer = new StringTokenizer(s);
            }
            return tokenizer.hasMoreElements();
        }
    }
}