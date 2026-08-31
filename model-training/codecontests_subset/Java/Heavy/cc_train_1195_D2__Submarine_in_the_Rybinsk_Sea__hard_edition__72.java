import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main2 {

    private FastScanner scanner = new FastScanner();

    public static void main(String[] args) {
        new Main2().solve();
    }

    private void solve() {

        int n = scanner.nextInt();

        int a[] = new int[n], cnt[] = new int[11];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            cnt[String.valueOf(a[i]).length()] ++;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 11; j++) {
                if (cnt[j] == 0) {
                    continue;
                }
                ans = (ans + get1(a[i], j) * cnt[j]) % 998244353;
                ans = (ans + get2(a[i], j) * cnt[j]) % 998244353;
            }
        }

        System.out.println(ans );
    }

    long get1(int a, int cnt) {

        String s = String.valueOf(a);
        String ans = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            if (cnt > 0) {
                ans = s.charAt(i) + "0" + ans;
                cnt --;
            } else {
                ans = s.charAt(i) + ans;
            }
        }

        return new BigInteger(ans).mod(BigInteger.valueOf(998244353)).longValue();
    }


    long get2(int a, int cnt) {
        String s = String.valueOf(a);

        String ans = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (cnt > 0 && i != s.length() - 1) {
                ans = s.charAt(i) + "0" + ans;
                cnt --;
            } else {
                ans = s.charAt(i) + ans;
            }
        }

        return new BigInteger(ans).mod(BigInteger.valueOf(998244353)).longValue();
    }
    class FastScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;

        FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();

        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        Integer[] nextA(int n) {
            Integer a[] = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            return a;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}