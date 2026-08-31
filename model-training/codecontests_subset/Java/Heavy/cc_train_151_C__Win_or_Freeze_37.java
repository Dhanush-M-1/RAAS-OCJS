import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    static boolean isPrime (long num) {
        for (long i = 2; i * i <= num; i++)
            if (num % i == 0) return false;
        return true;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int MAX = (int) 1e7;
        boolean primes[] = new boolean[MAX + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 0; i * i <= MAX; i++)
            if (primes[i])
                for (int j = 2; i * j <= MAX; j++)
                    primes[i * j] = false;


        long n = sc.nextLong();
        long tmp = n;
        int cnt = 0;
        long first = -1, second = -1;
        for (int i = 2; i <= Math.min(MAX, tmp - 1); i++)
            if (primes[i]) {
                while (n % i == 0) {
                    n /= i;
                    cnt++;
                    if (first == -1) first = i;
                    else second = i;
                }
            }

        if ((cnt > 0 && n > MAX && isPrime(n))) {
            cnt++;
            if (first == -1) first = n;
            else second = n;
        }

        if (cnt == 0) {
            System.out.println(1);
            System.out.println(0);
            return;
        } else if (cnt == 1 || cnt == 2) {
            System.out.println(2);
        } else {
            System.out.println(1);
            System.out.println(first * second);
        }
        out.flush();
        out.close();
    }


    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

    }
}