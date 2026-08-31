import java.util.Scanner;

/**
 * @author 彭豪杰
 * @date 2020/7/20 0020
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void solve() {
        int n = scanner.nextInt();
        int ret = 0;
        while (n != 1) {
            if (n % 6 != 0 && n % 3 != 0) {
                System.out.println(-1);
                return;
            }
            ret++;
            if (n % 6 == 0) {
                n /= 6;
            }else{
                n *= 2;
            }
        }

        System.out.println(ret);
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }
}
