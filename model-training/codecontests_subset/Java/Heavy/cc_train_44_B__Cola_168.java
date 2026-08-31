import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class B implements Runnable {
    private Scanner in;
    private PrintWriter out;

    private void solve() {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int ans = 0;
        for (int n2 = 0; n2 <= c && 2 * n2 <= n; ++n2) {
            for (int n1 = 0; n1 <= b && 2 * n2 + n1 <= n; ++n1) {
                int nh = 2 * (n - 2 * n2 - n1);
                if (nh <= a) {
                    ++ans;
                }
            }
        }
        out.println(ans);
    }

    @Override
    public void run() {
        Locale.setDefault(Locale.US);
        in = new Scanner(System.in);
        out = new PrintWriter(System.out);
        solve();
        in.close();
        out.close();
    }

    public static void main(String[] args) {
        new B().run();
    }
}
