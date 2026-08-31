import java.util.Scanner;

public class Main {
    private static boolean solve(String S, String Q) {
        int slen = S.length();
        int qlen = Q.length();

        for(int i = 0; i < qlen + 1; i++) {
            String spre = S.substring(0, i);
            String qpre = Q.substring(0, i);

            if (!spre.equals(qpre)) continue;

            String ssuf = S.substring(slen - (qlen - i), slen);
            String qsuf = Q.substring(i, qlen);

            if (ssuf.equals(qsuf)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        final String Q = "keyence";

        if (solve(S, Q)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
