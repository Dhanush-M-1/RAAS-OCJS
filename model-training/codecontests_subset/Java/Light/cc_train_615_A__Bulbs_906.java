import java.util.Scanner;

public class Bulbs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] a = new boolean[m];

        for (int i = 0; i < n; ++i) {
            int z = sc.nextInt();
            for (int j = 0; j < z; ++j) {
                a[sc.nextInt() - 1] = true;
            }
        }

        boolean res = true;
        for (int i = 0; i < m; ++i) {
            res = res && a[i];
        }

        System.out.println(res? "YES": "NO");
    }
}
