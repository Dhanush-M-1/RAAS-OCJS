import java.io.*;
import java.util.*;

public class Main {
    static int[] ans;
    static int[] a;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
//        out = new PrintWriter(new File("output.txt"));
//        br = new BufferedReader(new FileReader(new File("input.txt")));
        int GOVNO = nextInt();
        for (int NASRAL = 0; NASRAL < GOVNO; NASRAL++) {
            int n = nextInt();
            int m = nextInt();
            long[] a = new long[n];
            long[] pr = new long[n];
            long max = 0;
            ArrayList<Point> k = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
                if (i == 0) pr[0] = a[0];
                else pr[i] = pr[i - 1] + a[i];
                if (pr[i] > max) {
                    k.add(new Point(pr[i], i));
                    max = pr[i];
                }
            }
            for (int i = 0; i < m; i++) {
                long x = nextInt();
                if (x > max && pr[n - 1] <= 0) {
                    out.print(-1 + " ");
                    continue;
                }
                long ans = 0;
                if (x > max) {
                    long l = 0;
                    long r = (long)(1e9 + 10);
                    while (l + 1 != r) {
                        long mid = (l + r) / 2;
                        if (pr[n - 1] * mid < x - max) l = mid;
                        else r = mid;
                    }
                    ans += r * n;
                    x -= r * pr[n - 1];
                }
                if (x <= 0) {
                    out.print(ans - 1 + " ");
                    continue;
                }
                int l = -1;
                int r = k.size() -1;
                while (l + 1 != r) {
                    int mid = (l + r) / 2;
                    if (k.get(mid).val < x) l = mid;
                    else r = mid;
                }
                out.print(k.get(r).ind + ans + " ");
            }

            out.println();

        }
        out.close();
    }


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static StringTokenizer in = new StringTokenizer("");


    public static String next() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}

class Point {
    long val;
    long ind;

    public Point(long val, long ind) {
        this.val = val;
        this.ind = ind;
    }
}