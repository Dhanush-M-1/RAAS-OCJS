import javafx.util.Pair;

import java.util.*;
import java.io.*;

public class A {
    FastScanner in;
    PrintWriter out;
    boolean systemIO = true;


    class Pair {
        int x;
        int y;
        public Pair(int a, int b) {
            x = a;
            y = b;
        }
    }

    public void solve() {
        String s = in.next();
        String s1 = in.next();
        String s2 = in.next();
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }
        int[] b = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            b[s1.charAt(i) - 'a']++;
        }
        int[] c = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            c[s2.charAt(i) - 'a']++;
        }
        int t1 = 0;
        int t2 = 0;
        for (int i = 0; i < 1000000; i++) {
            int ok = 0;
            for (int j = 0; j < 26; j++) {
                if (a[j] < b[j] * i) ok = 1;
            }
            if (ok == 1) {
                break;
            }
            int k = 100000000;
            for (int j = 0; j < 26; j++) {
                int x = a[j] - b[j] * i;
                if (c[j] != 0)
                    k = Math.min(k, x / c[j]);
            }
            if (t1 + t2 < i + k) {
                t1 = i;
                t2 = k;
            }
        }
        for (int i = 0; i < t1; i++) {
            out.print(s1);
        }
        for (int i = 0; i < t2; i++) {
            out.print(s2);
        }
        for (int i = 0; i < 26; i++) {
            a[i] = a[i] - t1 * b[i] - t2 * c[i];
            for (int j = 0; j < a[i]; j++) {
                out.print(((char) ('a' + i)));
            }
        }
    }

    public void run() {
        try {
            if (systemIO) {
                in = new FastScanner(System.in);
                out = new PrintWriter(System.out);
            } else {
                in = new FastScanner(new File("a.in"));
                out = new PrintWriter(new File("a.out"));
            }
            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;


        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

    }

    public static void main(String[] arg) {
        new A().run();
    }
}