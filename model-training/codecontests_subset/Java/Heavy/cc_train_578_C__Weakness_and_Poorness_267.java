import java.io.*;
import java.util.*;
import java.math.*;

public class C implements Runnable {
    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer st;
    private static Random rnd;

    private void solve() throws IOException {
        int valuesCount = nextInt();
        int[] values = new int[valuesCount];
        for (int i = 0; i < valuesCount; i++) {
            values[i] = nextInt();
        }
        double l = Integer.MIN_VALUE, r = Integer.MAX_VALUE;
        for (int step = 0; step < 160; step++) {
            double p0 = l + (r - l) / 3.0;
            double p1 = r - (r - l) / 3.0;
            double v0 = solveSmart(valuesCount, values, p0);
            double v1 = solveSmart(valuesCount, values, p1);
            if (v0 > v1) {
                l = p0;
            } else {
                r = p1;
            }
        }
        double x = (l + r) * 0.5;
        out.println(solveSmart(valuesCount, values, x));
    }

    // private double solveOne(int valuesCount, int[] values, double x) {
    // double result = 0;
    // for (int i = 0; i < valuesCount; i++) {
    // double sum = 0;
    // for (int j = i; j < valuesCount; j++) {
    // sum += values[j] - x;
    // result = Math.max(result, Math.abs(sum));
    // }
    // }
    // return result;
    // }

    private double solveSmart(int valuesCount, int[] values, double x) {
        double result = 0, min = 0.0, max = 0.0;
        double sum = 0.0;
        for (int i = 0; i < valuesCount; i++) {
            sum += (values[i] - x);
            result = Math.max(result, Math.abs(sum - min));
            result = Math.max(result, Math.abs(sum - max));
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        return result;
    }

    public static void main(String[] args) {
        new C().run();
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            rnd = new Random();

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = in.readLine();

            if (line == null)
                return null;

            st = new StringTokenizer(line);
        }

        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}