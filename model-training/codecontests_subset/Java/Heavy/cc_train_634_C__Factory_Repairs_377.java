import java.io.*;
import java.util.*;

import static java.lang.Math.*;


public class Main {
    FastScanner in;
    PrintWriter out;

    static final String FILE = "";

    int n, k, a, b, q;

    int SQ = (int)sqrt(200_000) + 1;
    long ms1[] = new long[SQ * SQ];
    long ms2[] = new long[SQ * SQ];
    long sum1[] = new long[SQ];
    long sum2[] = new long[SQ];

    long get1(int a, int b) {
        long ans = 0;
        for (int i = a; i <= b;) {
            if (i % SQ == 0 && i + SQ <= b) {
                ans += sum1[i / SQ];
                i += SQ;
            } else {
                ans += ms1[i];
                i++;
            }
        }
        return ans;
    }

    long get2(int a, int b) {
        long ans = 0;
        for (int i = a; i <= b;) {
            if (i % SQ == 0 && i + SQ <= b) {
                ans += sum2[i / SQ];
                i += SQ;
            } else {
                ans += ms2[i];
                i++;
            }
        }
        return ans;
    }

    public void solve() {
        n = in.nextInt();
        k = in.nextInt();
        a = in.nextInt();
        b = in.nextInt();
        q = in.nextInt();

        for (int i = 0; i < q; i++) {
            int com = in.nextInt();
            if (com == 1) {
                int d = in.nextInt() - 1, ai = in.nextInt();
                int dSQ = d / SQ;

                sum1[dSQ] -= ms1[d];
                ms1[d] = min(b, ai + ms1[d]);
                sum1[dSQ] += ms1[d];

                sum2[dSQ] -= ms2[d];
                ms2[d] = min(a, ai + ms2[d]);
                sum2[dSQ] += ms2[d];
            } else {

                int p = in.nextInt() - 1;
                out.println(get1(0, p - 1) + get2(p + k, n - 1));

            }
        }
    }

    public void run() {
        if (FILE.equals("")) {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
        } else {
            try {
                in = new FastScanner(new FileInputStream(FILE +
                        ".in"));
                out = new PrintWriter(new FileOutputStream(FILE +
                        ".out"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        solve();
        out.close();
    }

    public static void main(String[] args) {
        (new Main()).run();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }
    }

    class Pair<A extends Comparable<A>, B extends Comparable<B>>
            implements Comparable<Pair<A, B>> {
        public A a;
        public B b;

        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair<A, B> o) {
            if (o == null || o.getClass() != getClass())
                return 1;
            int cmp = a.compareTo(o.a);
            if (cmp == 0)
                return b.compareTo(o.b);
            return cmp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (a != null ? !a.equals(pair.a) : pair.a != null) return
                    false;
            return !(b != null ? !b.equals(pair.b) : pair.b != null);
        }
    }

    class PairInt extends Pair<Integer, Integer> {
        public PairInt(Integer u, Integer v) {
            super(u, v);
        }
    }

    class PairLong extends Pair<Long, Long> {
        public PairLong(Long u, Long v) {
            super(u, v);
        }
    }

}