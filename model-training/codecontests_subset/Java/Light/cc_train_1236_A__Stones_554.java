import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            int num = c >> 1, cnt = 0;
            if (b <= num) cnt = b;
            else cnt += num + Math.min((b - num) >> 1, a);
            System.out.println(cnt*3);
        }
    }
}
