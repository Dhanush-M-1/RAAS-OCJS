
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        char[] c = new char[n];
        Arrays.fill(c, 'a');

        if (n == 1) {
            System.out.println("a");
            return;
        }

        solve(c, 1);
    }

    private static void solve(char[] c, int index) {

        if (index < c.length - 1) {

            while (true) {
                // 指定されたindexより先に文字が存在する場合、再帰的に呼び出す。
                solve(c, index + 1);
                //まだいける？
                if (moumuri(c, index)) {
                    break;
                }
                // 指定されているindexを1こ上げて、その先の文字を全部aにしちゃう。
                c[index]++;
                Arrays.fill(c, index + 1, c.length, 'a');
            }
        } else {

            while (true) {
                // 配列のお尻を指定されている場合、出力処理をする。
                System.out.println(String.valueOf(c));
                //まだいける？
                if (moumuri(c, index)) {
                    break;
                }
                // 指定されているindexを1こ上げる
                c[index]++;
            }
        }
    }

    private static boolean moumuri(char[] c, int index) {
        for (int i = 0; i < index; i++) {
            if (c[i] >= c[index]) {
                return false;
            }
        }
        return true;
    }
}
