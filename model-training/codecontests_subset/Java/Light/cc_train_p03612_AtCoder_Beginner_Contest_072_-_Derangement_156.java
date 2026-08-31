import java.util.*;

public class Main {

    public static void main(String args[]) {

        // 入力
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(sc.next());
        }

        // 主処理
        int result = p[0] == 1 ? 1 : 0;
        boolean isContinuous = false;
        for (int i = 1; i < p.length; i++) {
            if (i + 1 == p[i]) {
                isContinuous = i == p[i - 1] && !isContinuous;
                if (!isContinuous) {
                    result++;
                }
            }
        }

        // 出力
        System.out.println(result);
        sc.close();
    }
}
