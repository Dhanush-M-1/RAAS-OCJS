import java.io.*;
import java.io.IOException;
import java.util.*;

@SuppressWarnings({"rawtypes", "unchecked"})
class Main {
    final static int INF = 1 << 28;
    final static long LNF = 1L << 60;
    final static double EPS = 1e-9;
    final static double GOLDEN_RATIO = (1.0 + Math.sqrt(5)) / 2.0;

    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        final MyScanner sc = new MyScanner();
        String N;
        N = sc.next();
        long K;
        K = sc.nextLong();
        solve(N, K);
    }

    static void solve(String N, long K){
        long ans = 0; 
        String suji = N;

        while (true) {
            ans += s(suji, (int)K);

            K--;
            if(K < 0) break;

            suji = suji.substring(1);
            if (suji.equals("")) {
                break;
            }

            while(true) {
                if(Character.getNumericValue(suji.charAt(0)) != 0) break;
                if(suji.length() == 1) break;
                suji = suji.substring(1);
            }
        }
        System.out.println(ans);
    }

    static long s(String suji, int k) {
        if(k == 0) return 1;
        long ans = 0; 
        int saijoi = Character.getNumericValue(suji.charAt(0)); // not 0;

        ans += num(suji.length() - 1, (int) k);
        if(suji.length() != 1) {
            ans += (saijoi - 1) * num(suji.length() - 1, (int) k-1);
        } else {
            ans += (saijoi) * num(suji.length() - 1, (int) k-1);
        }
        return ans;
    }

    static long num(int keta, int k) {
        if (k<0) return 0;
        if(keta < k) return 0;
        long ret = 0;
        ret = C(keta, k, MOD);
        ret *= pow(9, k, MOD);
        return ret;
    }

    static long pow(long a, long r, long MOD) {
        long sum = 1;
        while (r > 0) {
            if ((r & 1) == 1) {
                sum *= a;
                sum %= MOD;
            }
            a *= a;
            a %= MOD;
            r >>= 1;
        }
        return sum;
    }

    static long C(int n, int r, long MOD) {
        long sum = 1;
        for (int i = n; 0 < i; --i) {
            sum *= i;
            sum %= MOD;
        }
        long s = 1;
        for (int i = r; 0 < i; --i) {
            s *= i;
            s %= MOD;
        }
        sum *= pow(s, MOD - 2, MOD);
        sum %= MOD;

        long t = 1;
        for (int i = n - r; 0 < i; --i) {
            t *= i;
            t %= MOD;
        }
        sum *= pow(t, MOD - 2, MOD);
        sum %= MOD;

        return sum;
    }

    static class MyScanner {
 
        BufferedReader br;
        StringTokenizer st;
 
        MyScanner(FileReader fileReader) {
            br = new BufferedReader(fileReader);
        }
 
        MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String nn() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        String next() {
            return nn();
        }

        String nextLine() {
            String ans = "";
            try {
                ans = br.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return ans;
        }
 
        char nextChar() {
            return nn().charAt(0);
        }
 
        int nextInt() {
            return Integer.parseInt(nn());
        }
 
        long nextLong() {
            return Long.parseLong(nn());
        }
 
        double nextDouble() {
            return Double.parseDouble(nn());
        }
 
        Integer[] niArr0(int n) {
            Integer[] ar = new Integer[n];
            for (int i = 0; i < n; i++) {
                ar[i] = nextInt();
            }
            return ar;
        }
 
        Integer[] niArr1(int n) {
            Integer[] ar = new Integer[n + 1];
            for (int i = 1; i <= n; i++) {
                ar[i] = nextInt();
            }
            return ar;
        }
 
        Long[] nlArr0(int n) {
            Long[] ar = new Long[n];
            for (int i = 0; i < n; i++) {
                ar[i] = nextLong();
            }
            return ar;
        }
 
        Long[] nlArr1(int n) {
            Long[] ar = new Long[n + 1];
            for (int i = 1; i <= n; i++) {
                ar[i] = nextLong();
            }
            return ar;
        }
    }

}
