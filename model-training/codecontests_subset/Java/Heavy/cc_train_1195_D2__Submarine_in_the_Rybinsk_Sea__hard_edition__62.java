
import java.io.*;
import java.util.*;

public class D2 {

    public void solve() throws IOException {
        int n = nextInt();
        long[] t = new long[20];
        t[0] = 1;
        long mod = 998244353;
        for (int i = 1; i < 20; i++) {
            t[i] = (10 * t[i - 1]) % mod;
        }
        long ans = 0;
        int[] dig = new int[11];
        long[] ar = new long[n];
        int[] ad = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = nextLong();
            String s = "" + ar[i];
            dig[s.length()]++;
            ad[i] = s.length();
        }
        for (int i = 0; i < n; i++) {
            long a = ar[i];
            for (int j = 1; j < 11; j++) {
                if (dig[j] == 0) continue;
                if (ad[i] <= j) {
                    int c = 0;
                    long b = a;
                    while (b > 0) {
                        long d = b % 10;
                        b /= 10;
                        ans += (((d * t[c]) % mod) * dig[j]) % mod;
                        ans += (((d * t[c + 1]) % mod) * dig[j]) % mod;
                        c += 2;
                        ans %= mod;
                    }
                } else {
                    int c = 0;
                    long b = a;
                    for (int k = 0; k < j; k++) {
                        long d = b % 10;
                        b /= 10;
                        ans += (((d * t[c]) % mod) * dig[j]) % mod;
                        ans += (((d * t[c + 1]) % mod) * dig[j]) % mod;
                        c += 2;
                        ans %= mod;
                    }
                    while (b > 0) {
                        long d = b % 10;
                        b /= 10;
                        ans += 2 * (((d * t[c]) % mod) * dig[j]) % mod;
                        c++;
                        ans %= mod;
                    }
                }
            }
        }
        out.print(ans);
    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public int[] nextArr(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextInt();
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        new D2().run();
    }
}