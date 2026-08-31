import java.io.*;
import java.util.*;

/**
 * @auther chao
 * @date 15/12/30
 */
public class MainApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        boolean[] a = new boolean[m];
        for (int i = 0; i < n; i++) {
            int k = in.nextInt();
            while (--k >= 0) {
                int p = in.nextInt();
                a[p-1] = true;
            }
        }
        for (int i = 0; i < m; i++) {
            if (!a[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}