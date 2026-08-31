import java.util.Scanner;

public class Main {
    public static final int MOD = 1_000_000_007;
    public static final String KEYENCE = "keyence";

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        boolean ans = solve(S);

        System.out.println(ans ? "YES" : "NO");
    }

    private static boolean solve(String S) {
        if (S.startsWith(KEYENCE) || S.endsWith(KEYENCE)) return true;

        for (int i=1; i<KEYENCE.length(); i++) {
            if (S.startsWith(KEYENCE.substring(0, i)) && S.endsWith(KEYENCE.substring(i))) return true;
        }

        return false;
    }

}
