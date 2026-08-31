import java.io.*;
import java.util.*;

public class Solution {
    static MyScanner sc;
    private static PrintWriter out;
    static long M2 = 1_000_000_000L + 7;

    public static void main(String[] s) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("100000 1000000000 10001 100000 ");
//        for (int i = 1; i < 100000; i++) {
//            stringBuilder.append(" 10000 100000 ");
//        }
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

    private static void solve() throws IOException {
        int n = sc.nextInt();
        int k = sc.nextInt();
        long s = sc.nextInt();
        long t = sc.nextInt();
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = sc.nextInt();
            cars[i][1] = sc.nextInt();
        }
        int[] st = sc.na(k);
        Arrays.sort(st);
        long[] dest = new long[k + 1];
        dest[0] = st[0];
        dest[1] = (s - st[k - 1]);
        for (int i = 1; i < k; i++) {
            dest[i + 1] = st[i] - st[i - 1];
        }

        long ml = 0;
        long mh = 4000000000L;

        while (ml + 1 < mh) {
            long mid = (ml + mh) / 2;

            long curs = 0;
            for (long d : dest) {
                if (d > mid) {
                    curs = 2000000001;
                    break;
                } else {
                    curs += d * 2 - Math.min(d, mid - d);
                }
            }

            if (curs <= t) {
                mh = mid;
            } else {
                ml = mid;
            }
        }
        long a = mh;
        int ff = Arrays
                .stream(cars)
                .filter(rm -> rm[1] >= a)
                .map(t1 -> t1[0])
                .min(Comparator.naturalOrder())
                .orElse(-1);
        out.println(ff);
    }

    private static Collection<? extends String> k2(int[][] data) {
        ArrayList<String> res = new ArrayList<>();
        for (int s = 0; s < data[0].length; s++) {
            int min = 1000;
            for (int i = 0; i < data.length; i++) {
                min = Math.min(min, data[i][s]);
            }
            for (int l = 0; l < min; l++) {
                res.add("col " + (s + 1));
            }
            for (int i = 0; i < data.length; i++) {
                data[i][s] -= min;
            }

        }

        return res;
    }

    private static Collection<? extends String> k1(int[][] data) {
        ArrayList<String> res = new ArrayList<>();
        for (int s = 0; s < data.length; s++) {
            int min = 1000;
            for (int i = 0; i < data[0].length; i++) {
                min = Math.min(min, data[s][i]);
            }
            for (int l = 0; l < min; l++) {
                res.add("row " + (s + 1));
            }
            for (int i = 0; i < data[0].length; i++) {
                data[s][i] -= min;
            }

        }

        return res;
    }


    private static void solveT() throws IOException {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static long gcd(long l, long l1) {
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

        Integer[] nab(int n) {
            Integer[] k = new Integer[n];
            for (int i = 0; i < n; i++) {
                k[i] = sc.fi();
            }
            return k;
        }

        int[] na(int n) {
            int[] k = new int[n];
            for (int i = 0; i < n; i++) {
                k[i] = sc.fi();
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

        int fi() {
            String t = next();
            int cur = 0;
            boolean n = t.charAt(0) == '-';
            for (int a = n ? 1 : 0; a < t.length(); a++) {
                cur = cur * 10 + t.charAt(a) - '0';
            }
            return n ? -cur : cur;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }


}