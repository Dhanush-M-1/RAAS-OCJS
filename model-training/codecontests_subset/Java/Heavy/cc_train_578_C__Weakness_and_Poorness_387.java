import java.io.*;
import java.util.*;
import java.math.*;

public class A implements Runnable {

    public void run() {
        long startTime = System.nanoTime();

        int n = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        double minx = -1e4, maxx = 1e4, res = 0;
        for (int iter = 0; iter < 100; iter++) {

            double t = (minx + maxx) / 2;

            double gmin = 1e9, gmax = -1e9;
            double min = 1, max = -1;
            for (int i = 0; i < n; i++) {
                double v = a[i] - t;
                min = Math.min(min + v, v);
                max = Math.max(max + v, v);
                gmin = Math.min(gmin, min);
                gmax = Math.max(gmax, max);
            }
            if (-gmin < gmax) {
                minx = t;
            } else {
                maxx = t;
            }
            res = gmax;
        }
        println(res);

        if (fileIOMode) {
            System.out.println((System.nanoTime() - startTime) / 1e9);
        }
        out.close();
    }

    //-----------------------------------------------------------------------------------

    private static boolean fileIOMode;
    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        fileIOMode = args.length > 0 && args[0].equals("!");
        if (fileIOMode) {
            in = new BufferedReader(new FileReader("a.in"));
            out = new PrintWriter("a.out");
        } else {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
        tokenizer = new StringTokenizer("");

        new Thread(new A()).start();
    }

    private static String nextLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    private static String nextToken() {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(nextLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private static long nextLong() {
        return Long.parseLong(nextToken());
    }

    private static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private static BigInteger nextBigInteger() {
        return new BigInteger(nextToken());
    }

    private static void print(Object o) {
        if (fileIOMode) {
            System.out.print(o);
        }
        out.print(o);
    }

    private static void println(Object o) {
        if (fileIOMode) {
            System.out.println(o);
        }
        out.println(o);
    }

    private static void printf(String s, Object... o) {
        if (fileIOMode) {
            System.out.printf(s, o);
        }
        out.printf(s, o);
    }
}
