import java.util.*;

public class A1208 {
    static Scanner sc = new Scanner(System.in);

    static void test() {
        int res;
        int a = sc.nextInt(), b = sc.nextInt(), n = sc.nextInt();
        if (n % 3 == 0) {
            res = a;
        } else if (n % 3 == 1) {
            res = b;
        } else {
            res = a ^ b;
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0)
            test();
    }  
}
