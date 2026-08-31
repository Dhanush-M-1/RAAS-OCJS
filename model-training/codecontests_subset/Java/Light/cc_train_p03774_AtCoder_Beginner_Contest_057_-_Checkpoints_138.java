import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m =sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        int[] c = new int[m];
        int[] d = new int[m];
        for (int i = 0; i < m; i++) {
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int min = Math.abs(a[i] - c[0]) + Math.abs(b[i] - d[0]);
            int minIndex = 0;
            for (int j = 0; j < m; j++) {
                int dis = Math.abs(a[i] - c[j]) + Math.abs(b[i] - d[j]);
                if (min > dis) {
                    minIndex = j;
                    min = dis;
                }
            }
            System.out.println(minIndex + 1);
        }
    }
}