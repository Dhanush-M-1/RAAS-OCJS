import java.util.*;

public class Main {

    public static void main(String args[]) {

        // 入力
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        // 主処理
        boolean judge = s.startsWith("keyence") || s.endsWith("keyence");
        if (!judge) {
            if ((s.startsWith("k") && s.endsWith("eyence")) || (s.startsWith("ke") && s.endsWith("yence"))
                    || (s.startsWith("key") && s.endsWith("ence")) || (s.startsWith("keye") && s.endsWith("nce"))
                    || (s.startsWith("keyen") && s.endsWith("ce")) || (s.startsWith("keyenc") && s.endsWith("e"))
                    || (s.startsWith("k") && s.endsWith("eyence"))) {
                judge = true;

            }
        }
        String result = judge ? "YES" : "NO";

        // 出力
        System.out.println(result);
        sc.close();
    }
}
