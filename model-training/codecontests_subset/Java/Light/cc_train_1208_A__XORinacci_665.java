import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Aki {
    public static int length;
    public static int flag;
    public HashMap<Long, Long> map;
    public HashSet<Long> set;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Aki obj = new Aki();
        int test = sc.nextInt();
        obj.map = new HashMap<>();
        obj.set = new HashSet<>();
        for (int t = 0; t < test; ++t) {

            long a, b, c, n, i = 0;
            a = sc.nextLong();
            b = sc.nextLong();
            n = sc.nextLong();
            c = a ^ b;
            n = n % 3;
            if (n == 0) {
                System.out.println(a);
            } else if (n == 1) {
                System.out.println(b);
            } else {
                System.out.println(c);
            }
        }
    }
}