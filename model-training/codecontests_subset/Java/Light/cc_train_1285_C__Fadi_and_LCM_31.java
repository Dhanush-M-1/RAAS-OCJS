import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FadyLCM {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long x = Long.parseLong(reader.readLine());
        reader.close();

        long sqrtX = (long) Math.sqrt(x);

        long a = 1;
        long b = x;
        for (int i = 1; i <= sqrtX; i++) {
            if (x % i == 0) {
                long xDivI = x / i;
                if (i * xDivI == x * gcd(i, xDivI)) {
                    if (Math.max(i, xDivI) < Math.max(a, b)) {
                        a = i;
                        b = xDivI;
                    }
                }
            }
        }

        System.out.println(a + " " + b);

    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
