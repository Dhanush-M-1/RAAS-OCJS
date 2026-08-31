import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    FastScanner in;
    PrintWriter out;

    void run() {
        in = new FastScanner();
        out = new PrintWriter(System.out);
        problem();
        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }

    public static long modPower(int x, int y) {
        if (y == 0) return 1;
        long z = modPower(x, y / 2);
        if ((y % 2) == 0)
            return (z * z) % N;
        else
            return (x * z * z) % N;
    }

    //    static int N = 998244353;
    static int N = (int) pow(10, 9) + 7;

    class Pair {
    }

    void problem() {
        int q = in.nextInt();

        for (int i = 0; i < q; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            int d = in.nextInt();

            long res;
            if (d < l || d > r) {
                res = d;
            } else {
                int diff = r % d;
                res = r + d - diff;
            }
            out.println(res);
        }

    }
}