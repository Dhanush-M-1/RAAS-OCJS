import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        long ans = 0;
        for (int i = 0; i <= a; i += 2)
            for (int j = 0; j <= b; j++) {
                int needed = n - i / 2 - j;
                if (needed % 2 == 1 || needed < 0)
                    continue;
                if (needed <= 2 * c) {
                    ans++;
                }
            }
        System.out.println(ans);
    }
}
