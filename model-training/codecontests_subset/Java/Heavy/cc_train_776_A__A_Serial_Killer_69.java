import java.io.*;
import java.util.*;

import static java.lang.Math.*;

/**
 * @author maxkrivich
 */
public final class Main {

    public void solve(){
        String a = in.next(), b = in.next();
        int n = in.nextInt();
        System.out.printf("%s %s\n", a, b);
        for(int i = 0; i < n; i++){
            String n1 = in.next(), n2 = in.next();
            if(a.equals(n1)) a = n2;
            if(b.equals(n1)) b = n2;
            System.out.printf("%s %s\n", a, b);
        }
    }


    //    -------------I/O-------------    \\
    void run() {
        try {
            in = new FScanner(new File("input.txt"));
            out = new PrintWriter(new BufferedWriter(new FileWriter(new File("output.txt"))));
            solve();
            out.close();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void runIO() {
        in = new FScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        solve();
        out.close();
        in.close();
    }

    public static void main(String[] args) {
        new Main().runIO();
    }

    private FScanner in;
    private PrintWriter out;

    class FScanner {

        private BufferedReader br;
        private StringTokenizer st;

        public FScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }

        void useString(String s) {
            if (s != null) {
                st = new StringTokenizer(s);
            }
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String s = "";
            try {
                s = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
        }

        void close() {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    class Pair<X, Y> implements Comparable<Pair<X, Y>> {
        public X first;
        public Y second;

        public Pair(X first, Y second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 11 * hash + Objects.hashCode(this.first);
            hash = 11 * hash + Objects.hashCode(this.second);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Pair<?, ?> other = (Pair<?, ?>) obj;
            if (!Objects.equals(this.first, other.first)) {
                return false;
            }
            if (!Objects.equals(this.second, other.second)) {
                return false;
            }
            return true;
        }

        @Override
        public int compareTo(Pair<X, Y> p) {
            return ((Comparable<X>) first).compareTo(p.first);
        }

        @Override
        public String toString() {
            return first + " " + second;
        }
    }

    static class Library {
        public static boolean isPrime(int n) {
            for (int i = 2; i * i <= n; i++)
                if (n % i == 0)
                    return false;
            return true;
        }

        public static long bpow(long x, long n) {
            long ans = 1l;
            while (n != 0) {
                if (n % 2 == 0)
                    ans *= x;
                x *= x;
                n >>= 1;
            }
            return ans;
        }

        public static long gcd(long a, long b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }

        public static long lcm(long a, long b) {
            return a / gcd(a, b) * b;
        }


        public static long phi(long n) {
            long res = n;
            for (int i = 2; i * i <= n; ++i)
                if (n % i == 0) {
                    while (n % i == 0)
                        n /= i;
                    res -= res / i;
                }
            if (n > 1)
                res -= res / n;
            return res;
        }

        public static int[] generatePrimes(int n) {
            boolean[] prime = new boolean[n + 1];
            Arrays.fill(prime, 2, n + 1, true);
            for (int i = 2; i * i <= n; i++)
                if (prime[i])
                    for (int j = i * i; j <= n; j += i)
                        prime[j] = false;
            int[] primes = new int[n + 1];
            int cnt = 0;
            for (int i = 0; i < prime.length; i++)
                if (prime[i])
                    primes[cnt++] = i;

            return Arrays.copyOf(primes, cnt);
        }

        public static int[] generateDivisorTable(int n) {
            int[] divisor = new int[n + 1];
            for (int i = 1; i <= n; i++)
                divisor[i] = i;
            for (int i = 2; i * i <= n; i++)
                if (divisor[i] == i)
                    for (int j = i * i; j <= n; j += i)
                        divisor[j] = i;
            return divisor;
        }

    }

}