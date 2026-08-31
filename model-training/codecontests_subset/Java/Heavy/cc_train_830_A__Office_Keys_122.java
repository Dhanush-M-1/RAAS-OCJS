import java.beans.IntrospectionException;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.text.DecimalFormat;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class C {
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static long MOD = (long) (1e9 + 7);
    //static int MOD = 998244353;
    static long MOD2 = MOD * MOD;
    static FastReader sc = new FastReader();
    static int pInf = Integer.MAX_VALUE;
    static int nInf = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int test = 1;
        //test = sc.nextInt();
        for (int i = 1; i <= test; i++){
            //out.print("Case #"+i+": ");
            solve();
        }
        out.flush();
        out.close();
    }
    static long oo = (long) (1e16);
    public static void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int office = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            b[i] = sc.nextInt();
        }
        ruffleSort(a);
        ruffleSort(b);
        long[][] dp = new long[m+1][n+1];
        for(int i= 0 ; i < m+1; i++){
            for(int j = 0; j < n+1; j++){
                dp[i][j] = oo;
            }
        }
//        out.println(Arrays.toString(a));
//        out.println(Arrays.toString(b));
        dp[0][0] = 0;
        for(int loc = 0; loc < m; loc++){
            for(int per = 0; per <= n; per++){
                //If we don't take the person
                dp[loc+1][per] = Math.min(dp[loc+1][per],dp[loc][per]);
                //When we take the person
                if(per<n){
                    dp[loc+1][per+1] = Math.min(dp[loc+1][per+1],Math.max(dp[loc][per],Math.abs(b[loc]-office)+Math.abs(a[per]-b[loc])));
                }

            }
        }
//        for(int i = 0; i < m+1; i++){
//            out.println(Arrays.toString(dp[i]));
//        }
        out.println(dp[m][n]);
    }
    static long nC2(long n) {
        return add((n * (n + 1)) / 2, 0);
    }
    public static long mul(long a, long b) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }
    public static long add(long a, long b) {
        return ((a % MOD) + (b % MOD)) % MOD;
    }
    public static long c2(long n) {
        if ((n & 1) == 0) {
            return mul(n / 2, n - 1);
        } else {
            return mul(n, (n - 1) / 2);
        }
    }
    //Pair Class
    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair o) {
            if ((this.x == o.x)) {
                return -1*(this.y - o.y);
            }
            return (this.x - o.x);
        }
    }


    //Shuffle Sort
    static final Random random = new Random();
    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
    //Brian Kernighans Algorithm
    static long countSetBits(long n) {
        if (n == 0) return 0;
        return 1 + countSetBits(n & (n - 1));
    }
    //Euclidean Algorithm
    static long gcd(long A, long B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
    //Modular Exponentiation
    static long fastExpo(long x, long n) {
        if (n == 0) return 1;
        if ((n & 1) == 0) return fastExpo((x * x) % MOD, n / 2) % MOD;
        return ((x % MOD) * fastExpo((x * x) % MOD, (n - 1) / 2)) % MOD;
    }
    //AKS Algorithm
    static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i <= Math.sqrt(n); i += 6)
            if (n % i == 0 || n % (i + 2) == 0) return false;
        return true;
    }
    public static long modinv(long x) {
        return modpow(x, MOD - 2);
    }
    public static long modpow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long x = modpow(a, b / 2);
        x = (x * x) % MOD;
        if (b % 2 == 1) {
            return (x * a) % MOD;
        }
        return x;
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        //it reads the data about the specified point and divide the data about it ,it is quite fast
        //than using direct

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception r) {
                    r.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());//converts string to integer
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception r) {
                r.printStackTrace();
            }
            return str;
        }
    }
}