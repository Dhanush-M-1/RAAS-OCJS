import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        String s = in.next();
        int ans = 0;
        for (int i = 0; i < x; i++) {
            int pos = n - 1 - i;
            if (i == y) {
                ans += (s.charAt(pos) == '0' ? 1 : 0);
            } else {
                ans += (s.charAt(pos) == '1' ? 1 : 0);
            }
        }
        out.println(ans);
        in.close();
    }
}