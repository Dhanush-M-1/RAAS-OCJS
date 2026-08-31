/**
 * Created by Andrew on 16.09.2015.
 */

import java.io.*;
import java.util.StringTokenizer;

public class C {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void solve() throws IOException {
        int n = readInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = readInt();
        }

        double l = -200000;
        double r = 200000;
        for(int i = 0; i < 100; i++) {
            double cl = l + (r - l) / 3;
            double cr = r - (r - l) / 3;
            double pl = poor(a, -cl);
            double pr = poor(a, -cr);
            if(pl < pr) {
                r = cr;
            } else {
                l = cl;
            }
        }
        double res = poor(a, -(l + r) / 2);
        out.println(res);
    }

    double poor(int[] a, double delta) {
        double curSumP = 0;
        double curSumN = 0;
        double maxSum = 0;
        double minSum = 0;
        for(int i = 0; i < a.length; i++) {
            double v = a[i] + delta;
            if(v < 0) {
                curSumP += v;
                curSumN -= v;
            } else {
                curSumN -= v;
                curSumP += v;
            }
            if(curSumN < 0) curSumN = 0;
            if(curSumP < 0) curSumP = 0;
            maxSum = Math.max(maxSum, curSumP);
            minSum = Math.max(minSum, curSumN);
        }
        return Math.max(minSum, maxSum);
    }


    void init() throws FileNotFoundException {
        if (ONLINE_JUDGE) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    int[] readArr(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = readInt();
        }
        return res;
    }

    long[] readArrL(int n) throws IOException {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = readLong();
        }
        return res;
    }

    public static void main(String[] args) {
        new C().run();
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            init();
            solve();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }
}