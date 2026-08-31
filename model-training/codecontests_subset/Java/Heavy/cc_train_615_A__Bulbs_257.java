import java.util.Scanner;

/**
 * Created by Muhammad on 07.06.2016.
 */
public class C_615A {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean []a = new boolean[m+1];
        int cnt = 0, x = 0;
        for (int i = 1; i <= n; i++) {
            x = sc.nextInt();
            for (int j = 0; j < x; j++){
                int y = sc.nextInt();
                if (!a[y]) {
                    cnt++;
                    a[y] = true;
                }
                if (cnt == m) {
                    System.out.print("YES");
                    return;
                }
            }
        }
        System.out.print("NO");
    }
}
