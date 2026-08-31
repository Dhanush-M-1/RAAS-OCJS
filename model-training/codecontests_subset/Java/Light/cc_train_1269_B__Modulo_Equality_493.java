
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class ModEq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintStream out = System.out;

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int diff = (b[i]-a[0]+m)%m;
            boolean good = true;
            for (int j = 1; j < n; j++) {
                int idx = (i+j)%n;
                if (((a[j]+diff) % m) != b[idx]) {
                    good = false;
                    break;
                }
            }
            if (good) {
                result = Math.min(diff, result);
            }
        }
        out.println(result);
    }
}
