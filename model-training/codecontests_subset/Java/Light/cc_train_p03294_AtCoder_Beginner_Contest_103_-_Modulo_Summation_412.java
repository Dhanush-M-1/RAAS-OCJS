import java.util.Scanner;

/**
 * https://beta.atcoder.jp/contests/abc103/tasks/abc103_c
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int ans = 0;
        for (int i = 0; i < num; i++) {
            ans += sc.nextInt();
        }

        System.out.println(ans - num);
    }
}
