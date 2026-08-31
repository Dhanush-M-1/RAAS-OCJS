import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProbC {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long x = Long.parseLong(br.readLine());
        long ansA = 0;
        long ansB = 0;
        int sqrt = (int) Math.floor(Math.sqrt(x));
        for (int i = 1; i <= sqrt; i++) {
            if (lcm(i, x / i) == x) {
                ansA = i;
                ansB = x / i;
            }
        }

        System.out.println(ansA + " " + ansB);
    }

    static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        else {
            return Math.abs(a * b) / gcd(a, b);
        }
    }

    static long gcd(long a, long b) {
        if (a == 0 || b == 0) {
            return a + b;
        } else {
            long absNumber1 = Math.abs(a);
            long absNumber2 = Math.abs(b);
            long biggerValue = Math.max(absNumber1, absNumber2);
            long smallerValue = Math.min(absNumber1, absNumber2);
            return gcd(biggerValue % smallerValue, smallerValue);
        }
    }
}
