import java.util.Scanner;

public class C1285 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        long d = (long) Math.sqrt(N);
        while (N%d != 0 || gcd(d,N/d) != 1) d--;
        System.out.println(d + " " + (N/d));
    }

    private static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a%b);
    }

}
