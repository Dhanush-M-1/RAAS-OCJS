import java.util.*;

public class insight {
    public static void main(String... ar) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans = 0;
        int iterator = 0;
        while (n > 0) {
            ans++;
            n--;
            iterator++;

            if (iterator == m) {
                iterator = 0;
                n++;
            }
        }

        System.out.println(ans);
    }
}