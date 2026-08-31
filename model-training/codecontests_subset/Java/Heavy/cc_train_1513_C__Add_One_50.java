import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {

    static final long mod = (long) 1e9 + 7l;
    static int steps = 2_000_03;
    static long counts[][] = new long[11][steps];

    private static void solve(int t) {
        String s = fs.next();
        int m = fs.nextInt();
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += counts[s.charAt(i) - '0'][m] % mod;
        }
        out.println(ans % mod);
    }

    private static void solvedd(int t) {
        String num = fs.next();
        long len = num.length();
        int n = fs.nextInt();
        long nxt = 0;
        StringBuilder sb1 = null;
        int smll = 9;
        for (int i = 0; i < len; i++) {
            int no = num.charAt(i) - '0';
            if (no != 0 && smll > no) smll = no;
        }
        int dec = 10 - smll;
        if (n > dec) {
            long doubling = n / dec;
            for (int i = 0; i < doubling; i++) {
                len += len;
                len = len % mod;
            }
            long leftover = n % dec;
            while (leftover > 0) {
                sb1 = new StringBuilder();
                for (int i = 0; i < num.length(); i++) {
                    int no = num.charAt(i) - '0';
                    sb1.append(no + 1);
                }
                nxt = Integer.parseInt(sb1.toString());
                num = nxt + "";
                leftover--;
            }
            out.println(len);
        } else {
            while (n > 0) {
                sb1 = new StringBuilder();
                for (int i = 0; i < num.length(); i++) {
                    int no = num.charAt(i) - '0';
                    sb1.append(no + 1);
                }
                nxt = Integer.parseInt(sb1.toString());
                num = nxt + "";
                n--;
            }
            out.println(sb1.length() % mod);
        }
    }

//    private static void solved(int t) {
//
//        String num = fs.next();
//        int n = fs.nextInt();
//        long nxt = 0;
//        StringBuilder sb1 = null;
//        StringBuilder sb2 = null;
//        if (n > 9) {
//            while (n > 9) {
//                sb1 = new StringBuilder();
//                int smll = 9;
//                for (int i = 0; i < num.length(); i++) {
//                    int no = num.charAt(i) - '0';
//                    if (no != 0 && smll > no) smll = no;
//                }
//                int dec = 10 - smll;
//                n -= dec;
//                for (int i = 0; i < num.length(); i++) {
//                    int no = num.charAt(i) - '0';
//                    int newnum = no + dec;
//                    if (newnum > 10) {
//                        sb1.append(left[9 - (10 - no) - 1]);
//                    } else {
//                        sb1.append(newnum);
//                    }
//                }
//                long nxtnum = Long.parseLong(sb1.toString());
////                if (nxtnum > mod) {
////                    nxtnum %= mod;
////                }
//                nxt = nxtnum;
//                num = nxt + "";
//            }
//        } else {
//            while (n > 0) {
//                sb1 = new StringBuilder();
//                for (int i = 0; i < num.length(); i++) {
//                    int no = num.charAt(i) - '0';
//                    sb1.append(no + 1);
//                }
//                nxt = Integer.parseInt(sb1.toString()) % mod;
//                num = nxt + "";
//                n--;
//            }
//        }
//        out.println(nxt % mod);
//        out.flush();
//    }


    public static void main(String[] args) {
        fs = new FastScanner();
        out = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        int t = fs.nextInt();
        preprocess();
        for (int i = 1; i <= t; i++) solve(t);
        out.close();
//        System.err.println( System.currentTimeMillis() - s + "ms" );
    }

    private static void preprocess() {
        for (int i = 0; i < 10; i++) counts[i][0] = 1;
        for (int i = 1; i < steps; i++) {
            for (int j = 0; j < 9; j++) {
                counts[j][i] = counts[j + 1][i - 1];
            }
            counts[9][i] = (counts[1][i - 1] + counts[0][i - 1]) % mod;
        }
    }

    static boolean DEBUG = true;
    static PrintWriter out;
    static FastScanner fs;

    static void trace(Object... o) {
        if (!DEBUG) return;
        System.err.println(Arrays.deepToString(o));
    }

    static void pl(Object o) {
        out.println(o);
    }

    static void p(Object o) {
        out.print(o);
    }

    static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static void sieveOfEratosthenes(int n, int factors[]) {
        factors[1] = 1;
        for (int p = 2; p * p <= n; p++) {
            if (factors[p] == 0) {
                factors[p] = p;
                for (int i = p * p; i <= n; i += p)
                    factors[i] = p;
            }
        }
    }

    static long mul(long a, long b) {
        return a * b % mod;
    }

    static long fact(int x) {
        long ans = 1;
        for (int i = 2; i <= x; i++) ans = mul(ans, i);
        return ans;
    }

    static long fastPow(long base, long exp) {
        if (exp == 0) return 1;
        long half = fastPow(base, exp / 2);
        if (exp % 2 == 0) return mul(half, half);
        return mul(half, mul(half, base));
    }

    static long modInv(long x) {
        return fastPow(x, mod - 2);
    }

    static long nCk(int n, int k) {
        return mul(fact(n), mul(modInv(fact(k)), modInv(fact(n - k))));
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreElements())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
