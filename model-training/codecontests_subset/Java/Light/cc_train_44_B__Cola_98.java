import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        int res = 0;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                int rem = 2 * n - i - j * 2;
                if (rem>=0&&rem % 4 == 0 && rem / 4 <= c) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}