import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n + 1];
        boolean[] same = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
            if (p[i] == i) {
                same[i] = true;
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!same[i]) {
                continue;
            }
            cnt++;
            if (i < n && same[i + 1]) {
                i++;
            }
        }
        System.out.println(cnt);
    }

}
