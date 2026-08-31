
import java.util.Scanner;

public class P615A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        boolean[] union = new boolean[m + 1];
        for (int i = 1; i <= m; i++) {
            union[i] = false;
        }
        int k;
        for (int i = 0; i < n; i++) {
            k = s.nextInt();
            for (int j = 0; j < k; j++) {
                union[s.nextInt()] = true;
            }
        }

        for (int i = 1; i <= m; i++) {
            if (union[i] == false) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}