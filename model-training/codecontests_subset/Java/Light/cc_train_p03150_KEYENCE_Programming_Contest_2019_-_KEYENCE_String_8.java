import java.util.Scanner;

class B {
    public static final char[] keyence = "keyence".toCharArray();

    public static void main(String... args) {
        final Scanner sc = new Scanner(System.in);
        final char[] S = sc.next().toCharArray();
        int prefix = 0;
        while (prefix < S.length && prefix < keyence.length && S[prefix] == keyence[prefix])
            prefix++;
        int suffix = 0;
        while (suffix < S.length && suffix < keyence.length && S[S.length - suffix - 1] == keyence[keyence.length - suffix - 1])
            suffix++;
        System.out.println(prefix + suffix >= keyence.length ? "YES" : "NO");
    }
}
public class Main {
    public static void main(String... args) {
        B.main();
    }
}
