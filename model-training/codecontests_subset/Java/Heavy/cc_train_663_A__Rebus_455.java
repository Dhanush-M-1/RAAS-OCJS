import java.io.*;
import java.util.StringTokenizer;


public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String[] x = sc.nextLine().split(" ");
        int n = Integer.parseInt(x[x.length - 1]);
        int sum = 1;
        for (int i = 1; ; i += 2) {
            x[i - 1] = "1";
            if (x[i].equals("=")) break;
            sum += x[i].equals("+") ? 1 : -1;
        }
        int need = n - sum;
        for (int i = 0; i < x.length - 2 && need != 0; i += 2) {
            if (need > 0) {
                if (i == 0 || x[i - 1].equals("+")) {
                    int add = Math.min(n - 1, need);
                    need -= add;
                    x[i] = add + 1 + "";
                }
            } else {
                if (i != 0 && x[i - 1].equals("-")) {
                    int add = Math.min(-need, n - 1);
                    need += add;
                    x[i] = add + 1 + "";
                }
            }
        }
        if (need==0) {
            out.println("Possible");
            for (String xx : x)
                out.print(xx + " ");
        }else out.println( "Impossible");
        out.close();
        out.flush();

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

        public void waitForInput() throws InterruptedException {
            Thread.sleep(3000);
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

