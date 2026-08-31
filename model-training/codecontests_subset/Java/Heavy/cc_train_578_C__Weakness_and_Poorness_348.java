import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TaskC {
    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        TaskC taskA = new TaskC();
        taskA.open();
        taskA.solve();
        taskA.close();
    }

    String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String str = in.readLine();
            if (str == null) return null;
            else st = new StringTokenizer(str);
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private void close() {
        try {
            out.close();
            in.close();
        } catch (IOException ignore) {
        }
    }

    double getMaxSum(double[] a) {
        double maxS = a[0], curS = 0;
        for (double cur : a) {
            if (curS < 0) curS = 0;
            curS += cur;
            maxS = Math.max(maxS, curS);
        }
        return maxS;
    }

    double getMinSum(double[] a) {
        double minS = a[0], curS = 0;
        for (double cur : a) {
            if (curS > 0) curS = 0;
            curS += cur;
            minS = Math.min(minS, curS);
        }
        return minS;
    }


    private void solve() throws IOException {
        int n = nextInt();
        int[] a = new int[n];
        double[] b = new double[n];
        for (int i = 0; i < n; i++) {
           a[i] = nextInt();
        }
        double xLow = -10e5, xHigh = +10e5;
        double xLowP = xLow, xHighP = xHigh;
        while (xHigh - xLow > 1e-20) {
            double x = (xHigh + xLow) / 2.0;
            for (int i = 0; i < n; i++) {
                b[i] = a[i] - x;
            }
            double minSum = getMinSum(b);
            double maxSum = getMaxSum(b);
            if (minSum > 0 || -minSum < maxSum) {
                xLow = x;
            } else {
                xHigh = x;
            }
            if (xHigh == xHighP && xLow == xLowP) break;
            xHighP = xHigh;
            xLowP = xLow;
        }
        out.println(Math.max(Math.abs(getMinSum(b)), getMaxSum(b)));
    }

    private void open() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
    }
}