
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class A248 {

    public void solve() throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);


        int n = toInt(br.readLine());
        int a[] = getIntArray(br.readLine());
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 100) {
                x++;
            } else {
                y++;
            }
        }
        int sum = x * 100 + y * 200;
        if ((sum / 100) % 2 != 0) {
            System.out.println("NO");
        } else {
            int forone = (sum / 100) / 2;
            for (int i = 0; i < y; i++) {
                if (forone >= 2) {
                    forone -= 2;
                }
            }
            for (int i = 0; i < x; i++) {
                if (forone >= 1) {
                    forone -= 1;
                }
            }
            if (forone == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new A248().solve();

    }

    public static Integer toInt(String s) {
        return Integer.parseInt(s.trim());
    }

    public static Long toLong(String s) {
        return Long.parseLong(s.trim());
    }

    public static Double toDouble(String s) {
        return Double.parseDouble(s.trim());
    }

    public static int[] getIntArray(String line) {
        String s[] = line.split(" ");
        int a[] = new int[s.length];
        for (int i = 0; i < s.length; ++i) {
            a[i] = Integer.parseInt(s[i]);
        }
        return a;
    }

    public static Integer[] getIntegerArray(String line) {
        String s[] = line.split(" ");
        Integer a[] = new Integer[s.length];
        for (int i = 0; i < s.length; ++i) {
            a[i] = Integer.parseInt(s[i]);
        }
        return a;
    }

    public static Double[] getDoubleArray(String line) {
        String s[] = line.split(" ");
        Double a[] = new Double[s.length];
        for (int i = 0; i < s.length; ++i) {
            a[i] = Double.parseDouble(s[i]);
        }
        return a;
    }

    public static Long[] getLongArray(String line) {
        String s[] = line.split(" ");
        Long a[] = new Long[s.length];
        for (int i = 0; i < s.length; ++i) {
            a[i] = Long.parseLong(s[i]);
        }
        return a;
    }

    public static Long getMaxFromLongArray(Long a[]) {
        Long max = Long.MIN_VALUE;
        for (int i = 0; i < a.length; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    public static Long getMinFromLongArray(Long a[]) {
        Long min = Long.MAX_VALUE;
        for (int i = 0; i < a.length; ++i) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        return min;
    }

    public static Integer getMaxFromIntegerArray(Integer a[]) {
        Integer max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    public static Integer getMinFromIntegerArray(Integer a[]) {
        Integer min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; ++i) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        return min;
    }

    static long modPow(long a, long x, long p) {
        //calculates a^x mod p in logarithmic time.
        long res = 1;
        while (x > 0) {
            if (x % 2 != 0) {
                res = (res % p * a % p) % p;
            }
            a = (a % p * a % p) % p;
            x /= 2;
        }
        return res;
    }

    static long modInverse(long a, long p) {
        //calculates the modular multiplicative of a mod m.
        //(assuming p is prime).
        return modPow(a, p - 2, p);
    }

    static long modBinomial(long n, long k, long p) {
        // calculates C(n,k) mod p (assuming p is prime).

        long numerator = 1; // n * (n-1) * ... * (n-k+1)
        for (long i = 0; i < k; i++) {
            numerator = (numerator % p * (n - i) % p) % p;
        }

        long denominator = 1; // k!
        for (long i = 1; i <= k; i++) {
            denominator = (denominator % p * i % p) % p;
        }

        // numerator / denominator mod p.
        return (numerator % p * modInverse(denominator, p) % p) % p;
    }

    public static long calculate(long k, long n) {
        return (modBinomial(n, k, 1000000007));
    }
}
