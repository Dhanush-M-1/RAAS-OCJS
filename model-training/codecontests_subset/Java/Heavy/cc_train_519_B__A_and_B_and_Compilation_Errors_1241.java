import java.util.Arrays;
import java.util.Scanner;

/**
 * @author stran
 * @version 1.0 (14/06/2016).
 */
public class P519B_ABCompilationErrors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n - 1];
        int[] c = new int[n - 2];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            b[i] = scanner.nextInt();
        }

        for (int i = 0; i < n - 2; i++) {
            c[i] = scanner.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        boolean foundA = false,
            foundB = false;

        for (int i = 0; i < n - 1; i++) {
            if (b[i] != a[i]) {
                foundA = true;
                System.out.println(a[i]);
                break;
            }
        }

        if (!foundA) {
            System.out.println(a[n - 1]);
        }

        for (int i = 0; i < n - 2; i++) {
            if (c[i] != b[i]) {
                foundB = true;
                System.out.println(b[i]);
                break;
            }
        }

        if (!foundB) {
            System.out.println(b[n - 2]);
        }
    }
}
