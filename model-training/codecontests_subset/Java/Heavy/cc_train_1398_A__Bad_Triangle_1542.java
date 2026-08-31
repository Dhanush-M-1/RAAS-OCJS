import java.util.*;
import java.io.*;

public class Badtri {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while (t-- > 0) {
            int len = sc.nextInt();
            int[] a = new int[len];
            for (int i = 0; i < len; i++) {
                a[i] = sc.nextInt();
            }
            print(a);
        }
    }

    static void print(int[] a) {
        if (a.length < 3) {
            System.out.println("-1");
            return;
        }
        boolean f = false;
        int k = a.length - 1;
        int i = 0, j = 1;
        if (a[i] + a[j] > a[k]) {
            System.out.println("-1");
            return;
        } else {
            System.out.println((i + 1) + " " + (j + 1) + " " + (k + 1));
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
}