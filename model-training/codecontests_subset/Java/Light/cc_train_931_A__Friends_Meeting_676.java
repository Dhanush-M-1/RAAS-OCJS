
import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        long ans = 0;
        int n = Math.abs(a - b);

        if (n % 2 == 1) {
            ans += (n / 2) + 1;
        }
        n /= 2;
        ans += (n * (n + 1));
        System.out.println((n == 0) ? 1 : ans);
    }
}
