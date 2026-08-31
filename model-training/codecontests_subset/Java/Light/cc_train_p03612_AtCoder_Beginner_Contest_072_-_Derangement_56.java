

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int[] a = new int[100002];
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
            }
            int ans = 0;

            for (int i = 0; i < N; i++) {
                if ( a[i] != i + 1 ) {
                    continue;
                }
                int start = i;
                while (i < N && a[i] == i + 1) {
                    i++;
                }
                ans += (i - start + 1) / 2;
                i--;
            }
            System.out.println(ans);
        }
    }
}
