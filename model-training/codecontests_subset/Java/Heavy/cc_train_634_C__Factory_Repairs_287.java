import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt(), k = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt(), q = sc.nextInt();
        int[] cnt = new int[n + 1];
        FenwickTree beforeRepairs = new FenwickTree(n);
        FenwickTree afterRepairs = new FenwickTree(n);
        while (q-- > 0) {
            int type = sc.nextInt();
            int d = sc.nextInt();
            if (type == 1) {
                int quanitity = sc.nextInt();
                int extra = Math.min(quanitity, b - cnt[d]);
                beforeRepairs.update(d, extra);
                extra = Math.min(quanitity, a - cnt[d]);
                afterRepairs.update(d, extra);
                cnt[d] += quanitity;
            } else {
                int end = d + k;
                out.println(beforeRepairs.rsq(d - 1) + afterRepairs.rsq(end, n));
            }
        }
        out.close();
        out.flush();

    }

    static class FenwickTree {
        int n;
        long[] ft;

        FenwickTree(int n) {
            this.n = n;
            ft = new long[n + 1];
        }

        void update(int idx, int val) {
            if (val <= 0) return;
            while (idx <= n) {
                ft[idx] += val;
                idx += idx & -idx;
            }
        }

        long rsq(int idx) {
            long ans = 0;
            while (idx > 0) {
                ans += ft[idx];
                idx -= idx & -idx;
            }
            return ans;
        }

        long rsq(int a, int b) {
            return rsq(b) - rsq(a - 1);
        }

    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }


        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public char nextChar() throws IOException {
            return next().charAt(0);
        }

        public Long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }


        public int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public long[] nextLongArray(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }


        public Integer[] nextIntegerArray(int n) throws IOException {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public double[] nextDoubleArray(int n) throws IOException {
            double[] ans = new double[n];
            for (int i = 0; i < n; i++)
                ans[i] = nextDouble();
            return ans;
        }

        public short nextShort() throws IOException {
            return Short.parseShort(next());
        }

    }


}