import java.util.Scanner;
import java.lang.*;

public class Garden {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int m = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (k % a[i] != 0)
                a[i] = 0;
        }
        m = a[0];
        for (int i = 0; i < n - 1; i++) {
            m = Math.max(m, a[i + 1]);
        }
        System.out.println(k / m);
    }
}