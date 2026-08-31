import java.util.Scanner;

/**
 * Created by Rohit on 10/21/15.
 */
public class Woodcutters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int x[] = new int[n];
        int h[] = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            h[i] = sc.nextInt();
        }

        int ans = 1;
        int max = x[0];
        for (int i = 1; i < n - 1; i++) {
            int one = x[i] - h[i];
            int two = x[i] + h[i];
            if (one > max) {
                ans++;
                max = x[i];
            } else if (two < x[i + 1]) {
                ans++;
                max = two;
            } else {
                max = x[i];
            }
        }
        if (n != 1)
            ans++;
        System.out.println(ans);
    }
}
