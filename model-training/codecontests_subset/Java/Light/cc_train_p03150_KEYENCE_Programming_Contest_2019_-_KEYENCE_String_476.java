import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[]$) {
        String s = scanner.next();
        for (int i = 0; i < 8; i++) {
            if (s.startsWith("keyence".substring(0, i)) && s.endsWith("keyence".substring(i))) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}