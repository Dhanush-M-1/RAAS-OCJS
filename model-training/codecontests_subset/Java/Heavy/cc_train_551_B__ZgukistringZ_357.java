import java.io.*;
import java.util.StringTokenizer;


public class Main {


    static final int INF = (int) 1e9;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        char[] a = sc.next().toCharArray();
        int[] cnta = getCountArray(a);
        char[] b = sc.next().toCharArray();
        char[] c = sc.next().toCharArray();
        int[] cntb = getCountArray(b);
        int[] cntc = getCountArray(c);
        int idx = 0;
        while (true) {
            int bs = canConstruct(cnta, cntb);
            int cs = canConstruct(cnta, cntc);
            if (bs + cs == 0) break;
            int[] takeB = removeString(cnta, cntb);
            int[] takeC = removeString(cnta, cntc);
            int newb = canConstruct(takeC, cntb);
            int newc = canConstruct(takeB, cntc);
            if (cs == 0 || bs - newb > cs - newc) {
                for (int i = 0; i < b.length; i++)
                    a[idx++] = b[i];
                cnta = takeB;

            } else {
                for (int i = 0; i < c.length; i++)
                    a[idx++] = c[i];
                cnta = takeC;
            }
        }
        for (int i = 0; i < 26; i++)
            while (cnta[i]-- > 0)
                a[idx++] = (char) (i + 'a');
        out.println(new String(a));
        out.flush();
        out.close();
    }

    static int[] getCountArray(char[] x) {
        int[] cnt = new int[26];
        for (int c : x)
            cnt[c - 'a']++;
        return cnt;
    }

    static int[] removeString(int[] cnta, int[] cntb) {
        int[] cnt = new int[26];
        for (int i = 0; i < 26; i++)
            cnt[i] = cnta[i] - cntb[i];
        return cnt;
    }

    static int canConstruct(int[] a, int[] b) {
        int ans = INF;
        for (int i = 0; i < 26; i++)
            if (b[i] != 0) ans = Math.min(a[i] / b[i], ans);
        return ans;
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        public Scanner(String file) throws Exception {
            br = new BufferedReader(new FileReader(file));
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