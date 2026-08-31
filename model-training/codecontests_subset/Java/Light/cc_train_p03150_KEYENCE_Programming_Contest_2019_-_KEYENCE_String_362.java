// original submission:https://atcoder.jp/contests/keyence2019/submissions/4004186
// author: ks96neko

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        if (s.startsWith("k") && s.endsWith("eyence")) {
            System.out.println("YES");
        } else if (s.startsWith("ke") && s.endsWith("yence")) {
            System.out.println("YES");
        } else if (s.startsWith("key") && s.endsWith("ence")) {
            System.out.println("YES");
        } else if (s.startsWith("keye") && s.endsWith("nce")) {
            System.out.println("YES");
        } else if (s.startsWith("keyen") && s.endsWith("ce")) {
            System.out.println("YES");
        } else if (s.startsWith("keyenc") && s.endsWith("e")) {
            System.out.println("YES");
        } else if (s.contains("keyence")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
