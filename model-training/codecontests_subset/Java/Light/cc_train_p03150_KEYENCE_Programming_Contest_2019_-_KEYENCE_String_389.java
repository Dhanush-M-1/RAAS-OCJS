
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    private static final PrintStream so = System.out;
    private static final Scanner     sc = new Scanner(System.in);
    static final String KEYENCE = "keyence";
    public static void main(String[] args) {
        String s = sc.next();
        if (s.startsWith(KEYENCE)) {
            so.println("YES");
        } else if (s.endsWith(KEYENCE)) {
            so.println("YES");
        } else {
            for (int i = 0; i < KEYENCE.length(); i++) {
                if (s.startsWith(KEYENCE.substring(0, i)) && s.endsWith(KEYENCE.substring(i, KEYENCE.length()))) {
                    so.println("YES");
                    return;
                }
            }
            so.println("NO");
        }
    }
}
