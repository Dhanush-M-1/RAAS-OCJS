import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Don Li
 */
public class SubmarineInTheRybinskSea2 {
    
    int MOD = 998244353;
    
    void solve() {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        
        int[] cnt = new int[11];
        int[] len = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = countDigits(a[i]);
            cnt[len[i]]++;
        }
        
        long[] p10 = new long[20];
        p10[0] = 1;
        for (int i = 1; i < 20; i++) p10[i] = p10[i - 1] * 10 % MOD;
        
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int q = len[i];
            for (int p = 1; p <= 10; p++) {
                int x = a[i];
                if (q <= p) {
                    long mul = 11;
                    while (x > 0) {
                        int d = x % 10;
                        ans = (ans + d * mul % MOD * cnt[p] % MOD) % MOD;
                        x /= 10;
                        mul = mul * 100 % MOD;
                    }
                } else {
                    long mul = 11;
                    for (int j = 0; j < p; j++) {
                        int d = x % 10;
                        ans = (ans + d * mul % MOD * cnt[p] % MOD) % MOD;
                        x /= 10;
                        mul = mul * 100 % MOD;
                    }
                    ans += x * p10[2 * p] % MOD * cnt[p] % MOD * 2 % MOD;
                    ans %= MOD;
                }
            }
        }
        out.println(ans);
    }
    
    int countDigits(int x) {
        int num = 0;
        while (x > 0) {
            x /= 10;
            num++;
        }
        return num;
    }
    
    public static void main(String[] args) {
        in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);
        new SubmarineInTheRybinskSea2().solve();
        out.close();
    }
    
    static FastScanner in;
    static PrintWriter out;
    
    static class FastScanner {
        BufferedReader in;
        StringTokenizer st;
        
        public FastScanner(BufferedReader in) {
            this.in = in;
        }
        
        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
        
        public long nextLong() {
            return Long.parseLong(nextToken());
        }
        
        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
