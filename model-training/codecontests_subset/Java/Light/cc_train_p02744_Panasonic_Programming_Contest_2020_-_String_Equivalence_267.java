import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

class D {
    public static void main(String... args) {
        final Scanner sc = new Scanner(System.in);
        try (final PrintWriter pw = new PrintWriter(System.out, false)) {
            final int N = sc.nextInt();
            final char[] cs = new char[N];
            Arrays.fill(cs, 'a');
            do {
                pw.println(new String(cs));
            } while (next(cs));
        }
    }

    static boolean next(char[] cs) {
        char[] max = new char[cs.length];
        max[0] = (char) ('a' - 1);
        for (int i = 1; i < cs.length; i++)
            max[i] = (char) Math.max(max[i - 1], cs[i - 1]);
        for (int i = cs.length - 1; i > 0; i--)
            if (cs[i] <= max[i]) {
                cs[i]++;
                for (int j = i + 1; j < cs.length; j++)
                    cs[j] = 'a';
                return true;
            }
        return false;
    }
}
public class Main {
    public static void main(String... args) {
        D.main();
    }
}
