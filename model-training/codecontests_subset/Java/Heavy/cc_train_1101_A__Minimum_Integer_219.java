

import javax.xml.transform.Source;
import java.nio.charset.IllegalCharsetNameException;
import java.rmi.MarshalException;
import java.util.*;
import java.io.*;
import java.math.*;

public class program {
    public static FastIO file = new FastIO();

    private static void solve() {
        int tt = nextInt();
//        int tt = 1;
        long start = 0;
        while (tt-- > 0) {
            int l1 = nextInt(), r1 = nextInt(), d = nextInt();
            if (d >= l1 && r1 >= d) System.out.println(((r1+d)-(r1+d)%d));
            else System.out.println(d);
        }
    }

    private static int[] nextArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = nextInt();
        return a;
    }

    public static int[][] nextArray2D(int n, int m) {
        int[][] result = new int[n][];
        for (int i = 0; i < n; i++) {
            result[i] = nextArray(m);
        }
        return result;
    }

    public static long pow(long n, long p) {
        long ret = 1L;
        while (p > 0) {
            if (p % 2 != 0L)
                ret *= n;
            n *= n;
            p >>= 1L;
        }
        return ret;
    }

    public static String next() {
        return file.next();
    }

    public static int nextInt() {
        return file.nextInt();
    }

    public static long nextLong() {
        return file.nextLong();
    }

    public static double nextDouble() {
        return file.nextDouble();
    }

    public static String nextLine() {
        return file.nextLine();
    }

    public static class FastIO {
        BufferedReader br;
        StringTokenizer st;

        public FastIO() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

    public static void main(String[] args) {
        solve();
    }


}