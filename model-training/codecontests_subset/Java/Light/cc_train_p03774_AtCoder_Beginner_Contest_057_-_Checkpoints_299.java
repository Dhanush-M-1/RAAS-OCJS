import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[m];
        int[] d = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }
        int tmp;
        int output = 0;
        for (int i = 0; i < n; i++) {
            tmp = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (tmp > Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j])) {
                    tmp = Math.min(tmp, Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]));
                    output = j + 1;
                }
            }
            System.out.println(output);
        }
    }
}
