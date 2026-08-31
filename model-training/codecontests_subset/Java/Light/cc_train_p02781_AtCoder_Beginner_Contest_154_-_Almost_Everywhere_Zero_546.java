import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static final int UNCALC = -1;
    static int[] num;
    static int n;
    static long[][][] memo;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        char[] s = sc.next().toCharArray();
        n = s.length;
        num = new int[n];
        for (int i = 0; i < n; i++)
            num[i] = s[i] - '0';
        int k = sc.nextInt();
        memo = new long[2][k + 1][n];
        for (long[][] a : memo)
            for (long[] b : a)
                Arrays.fill(b, UNCALC);
        out.println(dp(1, k, 0));
        out.flush();
        out.close();
    }

    static long dp(int equal, int rem, int i) {
        if (rem < 0) return 0;
        if (i == n) return rem == 0 ? 1 : 0;
        if (memo[equal][rem][i] != UNCALC) return memo[equal][rem][i];
        long cnt = 0;
        int end = equal == 1 ? num[i] : 9;
        for (int add = 0; add <= end; add++) {
            int ne = equal == 0 ? 0 : (add < num[i] ? 0 : 1);
            int nrem = rem;
            if (add != 0) nrem--;
            cnt += dp(ne, nrem, i + 1);
        }
        return memo[equal][rem][i] = cnt;
    }


    static class Scanner {

        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        boolean ready() throws IOException {
            return br.ready();
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