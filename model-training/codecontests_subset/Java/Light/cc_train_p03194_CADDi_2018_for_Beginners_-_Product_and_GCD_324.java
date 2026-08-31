import java.util.*;
import java.lang.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long p = sc.nextLong();
        if (n >= 40) {
            System.out.println(1);
        } else if (n == 1) {
            System.out.println(p);
        } else {
            for (int i = (int)Math.sqrt(p); i > 0; i--) {
                if (p % (Math.pow(i, n)) == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
