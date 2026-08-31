
import java.math.*;
import java.util.*;

public class BruteForce {

    public static Scanner in = new Scanner(System.in);

    public static ArrayList<Long> getD(long n) {
        ArrayList<Long> divs = new ArrayList<Long>();
        for (long i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    divs.add(i);
                } else {
                    divs.add(i);
                    divs.add(n / i);
                }
            }
        }
        return divs;
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static long lcm(long a, long b) {
        long ab = a * b;
        long gcd = gcd(a, b);
        return ab / gcd;
    }

    public static void main(String[] args) {
        long x = in.nextLong();

        ArrayList<Long> divs = getD(x);
        Collections.sort(divs);
        long min =10000000000001l;
        long a = 0;
        long b = 0;
        for (long val : divs) {
            long tst = x / val;
           // System.out.println(val+" "+tst);
            if (lcm(val, tst) == x) {
                if (Math.max(val, tst) < min) {
                    a = tst;
                    b = val;
                    min=Math.max(val, tst);
                }
            }
        }
        System.out.println(a + " " + b);
    }
}
