
import java.util.Scanner;

public class Main {

    public static int n_;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n_ = Integer.parseInt(scan.next());
        scan.close();

        dfs("a", 'a');

    }

    private static void dfs(String s, char max) {
        // 終了条件
        if (s.length() == n_) {
            System.out.println(s);
            return;
        }

        for (char c = 'a'; c <= max + 1; c++) {
            if (c > max) {
                dfs(s + c, c);
            } else {
                dfs(s+c,max);
            }
        }

    }
}
