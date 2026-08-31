import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long k = in.nextLong();
        for (int i = 1; i <= n; i++) {
            if (k <= i) break;
            k -= i;
        }
        int res = 0;
        for (int i = 1; i <= k; i++) res = in.nextInt();
        System.out.println(res);
    }
}
