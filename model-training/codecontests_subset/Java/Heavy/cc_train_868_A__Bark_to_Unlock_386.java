import java.io.*;
import java.util.*;

public class A {
    FScanner in = new FScanner();
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);


    void run() {
        String pw = in.next();
        int n = in.nextInt();
        String[] p = new String[n];
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        boolean found = false;
        for (int i = 0; i < n; i++) {
            p[i] = in.next();
            cnt1[p[i].charAt(0) - 'a']++;
            cnt2[p[i].charAt(1) - 'a']++;
            if (pw.compareTo(p[i]) == 0)
                found = true;
        }
        if (found)
            out.print("YES");
        else {
            out.print(
                    (cnt2[pw.charAt(0) - 'a'] > 0 && cnt1[pw.charAt(1) - 'a'] > 0) ?
                            "YES" :
                            "NO"
            );
        }
        out.close();
    }

    public static void main(String[] args) {
        new A().run();
    }

    static class FScanner {
        BufferedReader br;
        StringTokenizer st;

        FScanner() {
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
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

        char[][] nextCharArray(int n, int m) {
            char[][] g = new char[n][m];
            for (int i = 0; i < n; i++)
                g[i] = next().toCharArray();
            return g;
        }

        double[] nextDoubleArray(int n) {
            double[] a = new double[n];
            for (int i = 0; i < n; i++)
                a[i] = nextDouble();
            return a;
        }

        int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
    }
}
