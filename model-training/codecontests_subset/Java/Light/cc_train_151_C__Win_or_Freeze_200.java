
import java.util.*;

public class taskC {

    public static void main(String[] args) {
        new taskC().main();
    }

    void main() {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        if (n == 1) {
            exit1(0);
            return;
        }
        long d = 2, div1 = 0, div2 = 0;
        while (d * d <= n) {
            if (n % d == 0) {
                div1 = d;
                div2 = n / d;
                break;
            }
            d++;
        }
        long rest = -1;
        if (div2 != 0) {
            rest = isPrime(div2);
        }
        if (rest == 0) {
            exit2();
        } else {
            if (rest < 0) {
                rest = 0;
            }
            exit1(div1*rest);
        }
    }

    long isPrime(long x) {
        long d = 2;
        while (d * d <= x) {
            if (x % d == 0) {
                return d;
            }
            d++;
        }
        return 0;
    }

    void exit2() {
        System.out.println(2);
    }

    void exit1(long exCode) {
        System.out.println(1);
        System.out.println(exCode);
    }
}
