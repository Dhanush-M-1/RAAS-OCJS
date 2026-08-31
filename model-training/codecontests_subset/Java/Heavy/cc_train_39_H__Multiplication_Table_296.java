
import java.util.Scanner;

/**
 * @author igor_kz
 */
public class H39 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1 ; i < n ; i++) {
            for (int j = 1 ; j < n ; j++) {
                int c = i * j;
                Print(c , n);
            }
            System.out.println();
        }
    }

    public static void Print(int c, int n) {
        int[] a = new int[100];
        int cnt = 0;
        while (c > 0) {
            a[cnt++] = c % n;
            c /= n;
        }
        for (int i = cnt - 1 ; i >= 0 ; i--) System.out.print(a[i]);
        System.out.print(" ");
    }
}
