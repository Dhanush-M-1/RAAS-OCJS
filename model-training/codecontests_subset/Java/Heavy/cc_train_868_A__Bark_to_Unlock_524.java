
import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {


    static MyScanner sc;
    private static PrintWriter out;
    static long M = 1000000007;


    public static void main(String[] s) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();

        if (stringBuilder.length() == 0) {
            sc = new MyScanner(System.in);
        } else {
            sc = new MyScanner(new BufferedReader(new StringReader(stringBuilder.toString())));
        }

        out = new PrintWriter(new OutputStreamWriter(System.out));

        initData();
        solve();
        out.flush();
    }

    private static void initData() {

    }

    private static void solve() {
        String t = sc.next();
        int n = sc.nextInt();
        String [] ll = new String[n];
        for (int i  = 0 ; i < n ; i++) {
            ll[i] = sc.next();
        }
        for (int i = 0 ; i < n ; i++) {
            if (t.equals(ll[i])) {
                out.println("YES");
                return;
            }
        }
        for (int i = 0 ; i < n ; i++) {
            if (ll[i].charAt(0) == t.charAt(1))
            for (int j = 0 ; j < n ; j++) {
                if (ll[j].charAt(1) == t.charAt(0) ) {
                    out.println("YES");
                    return;
                }
            }

        }
        out.println("NO");
    }



    private static void printa(int[] res) {
        for (int i : res) {
            out.print(i);
            out.print(' ');
        }
    }

    private static void solveT() {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }


    private static int gcd(int l, int l1) {
        if (l > l1) return gcd(l1, l);
        if (l == 0) return l1;
        return gcd(l1 % l, l);
    }

    private static long pow(long a, long b, long m) {
        if (b == 0) return 1;
        if (b == 1) return a;
        long pp = pow(a, b / 2, m);
        pp *= pp;
        pp %= m;
        return (pp * (b % 2 == 0 ? 1 : a)) % m;
    }

    private static void sort(int[] t, IntUnaryOperator op1, IntUnaryOperator op2) {
        sort(t, (k1, k2) -> {
            int p1 = op1.applyAsInt(k1);
            int p2 = op1.applyAsInt(k2);
            if (p1 != p2) {
                return p1 - p2;
            } else {
                return op2.applyAsInt(k1) - op2.applyAsInt(k2);
            }
        });
    }

    private static void sort(int[] t, IntBinaryOperator op) {
        List<Integer> k = Arrays.stream(t).boxed().collect(Collectors.toList());
        k.sort(op::applyAsInt);
        for (int i = 0; i < t.length; i++) {
            t[i] = k.get(i);
        }
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        MyScanner(BufferedReader br) {
            this.br = br;
        }

        public MyScanner(InputStream in) {
            this(new BufferedReader(new InputStreamReader(in)));
        }

        void findToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        String next() {
            findToken();
            return st.nextToken();
        }

        int[] na(int n) {
            int[] k = new int[n];
            for (int i = 0; i < n; i++) {
                k[i] = sc.nextInt();
            }
            return k;
        }

        long[] nl(int n) {
            long[] k = new long[n];
            for (int i = 0; i < n; i++) {
                k[i] = sc.nextLong();
            }
            return k;
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
    }


}