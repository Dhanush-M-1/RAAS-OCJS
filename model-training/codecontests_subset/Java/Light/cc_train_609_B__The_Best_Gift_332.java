import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Main {

    public static int[] arr = new int[200500];
    public static int[] best = new int[200500];
    public static int[] cnt = new int[200500];

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int n, m;
        while (input.hasNext()) {

            n = input.nextInt();
            m = input.nextInt();

            int c;
            for (int i = 0; i <= n; i++) {
                best[i] = 0;
                cnt[i] = 0;
            }
            for (int i = 0; i < n; i++) {
                c = input.nextInt();
                arr[i] = c;
                cnt[i] = best[c] + 1;
                best[c]++;
            }

            int ans = 0;
            for (int i = 0; i < n - 1; i++) {
                c = arr[i];
                ans += ((n - (i + 1)) - (best[c] - cnt[i]));
            }
            System.out.println(ans);

        }

    }

}
