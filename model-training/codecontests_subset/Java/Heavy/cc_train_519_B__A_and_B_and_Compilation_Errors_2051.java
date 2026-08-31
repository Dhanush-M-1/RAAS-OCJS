import java.util.*;

/**
 *
 * @author greggy
 */
public class AAndBAndCompilationErrors {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] compile1 = new int[n];
        int[] compile2 = new int[n - 1];
        int[] compile3 = new int[n - 2];

        for (int i = 0; i < n; i++) {
            compile1[i] = in.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            compile2[i] = in.nextInt();
        }

        for (int i = 0; i < n - 2; i++) {
            compile3[i] = in.nextInt();
        }

        Arrays.sort(compile1);
        Arrays.sort(compile2);
        Arrays.sort(compile3);

        for (int i = 0; i < n - 1; i++) {
            if (compile1[i] != compile2[i]) {
                System.out.println(compile1[i]);
                break;
            }
            if (i == n - 2) {
                System.out.println(compile1[n - 1]);
            }
        }

        for (int i = 0; i < n - 2; i++) {
            if (compile2[i] != compile3[i]) {
                System.out.println(compile2[i]);
                break;
            }
            if (i == n - 3) {
                System.out.println(compile2[n - 2]);
            }
        }

    }
}