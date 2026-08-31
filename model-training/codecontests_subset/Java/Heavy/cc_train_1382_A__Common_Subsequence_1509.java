
import java.util.Scanner;

public class CommonSubsequence {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int res = -1;
            int[] a = new int[100000];
            for (int i = 0; i < n; i++) {
                ++a[scan.nextInt()];
            }
            for (int i = 0; i < m; i++) {
                int k = scan.nextInt();
                if (a[k] != 0) {
                    res = k;
                }
            }
            if (res == -1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                System.out.println(1 + " " + res);

            }
        }
    }
}
