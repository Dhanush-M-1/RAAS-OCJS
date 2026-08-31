import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<Long> primes;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        long q = sc.nextLong();
        sieve();
        ArrayList<Long> factors = new ArrayList<>();
        for (long p : primes) {
            if (p * p > q) break;
            while (q % p == 0) {
                q /= p;
                factors.add(p);
            }
        }
        if (q != 1)
            factors.add(q);
        if (factors.size() <= 1) out.print("1\n" +
                "0\n");
        else if (factors.size() < 3) out.println(2);
        else {
            out.println(1);
            out.println(factors.get(0) * factors.get(1));
        }

        out.flush();
        out.close();

    }

    static void sieve() {
        primes = new ArrayList<>();
        int n = (int) 1e7;
        boolean[] isComposite = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (isComposite[i]) continue;
            primes.add((long) i);
            if (1l * i * i < n) {
                for (int j = i * i; j < n; j += i)
                    isComposite[j] = true;
            }
        }
    }


    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream system) {
            br = new BufferedReader(new InputStreamReader(system));
        }

        public Scanner(String s) throws FileNotFoundException {

            br = new BufferedReader(new FileReader(new File(s)));
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