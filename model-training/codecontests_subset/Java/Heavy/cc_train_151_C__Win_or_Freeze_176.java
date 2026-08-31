
import java.util.Scanner;

public class A {
    public static long isPrime(long x) {
        for (long i = 2; i * i <= x; i++)
            if (x % i == 0)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x = in.nextLong();
        long last = isPrime(x);
        if (last == -1) {
            System.out.println(1);
            System.out.println(0);
        } else {
            long temp = isPrime(x / last);
            if (temp == -1) {
                System.out.println(2);
            } else {
                System.out.println(1);
                System.out.println(last * temp);
            }
        }
    }
}
