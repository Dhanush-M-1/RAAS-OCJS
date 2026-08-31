import java.util.*;

public class Main {

    static final int MOD = 1000000007;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        rec(n, "a", 'a');

    }

    private static void rec(int n, String s, char max) {
        if (n == s.length()) {
            System.out.println(s);
            return;
        }

        for (char c = 'a'; c < (char) (max + 2); c++) {
            rec(n, s + c, max > c ? max : c);
        }


    }
}
