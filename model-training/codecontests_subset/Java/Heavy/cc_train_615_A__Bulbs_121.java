
import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] switched = new boolean[m + 1];
        for (int i = 0; i < n; i++) {
            int xi = sc.nextInt();
            for (int j = 0; j < xi; j++) {
                int next = sc.nextInt();
                if (!switched[next]) {
                    switched[next] = true;
                }
            }
        }
        sc.close();
        for (int i = 1; i <= m; i++) {
            if (!switched[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

}
