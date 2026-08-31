import java.io.PrintWriter;
import java.util.Scanner;

public class MathProblem {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String args[]) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int leftEnd = Integer.MAX_VALUE;
        int rightStart = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            leftEnd = Math.min(leftEnd, r);
            rightStart = Math.max(rightStart, l);
        }

        int ans = 0;
        if (leftEnd >= rightStart) {
            ans = 0;
        } else {
            ans = rightStart - leftEnd;
        }

        System.out.println(ans);
    }
}
