import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class H implements Runnable {
    private Scanner in;
    private PrintWriter out;

    private void solve() {
        int k = in.nextInt();
        for (int i = 1; i <= k - 1; ++i) {
            for (int j = 1; j <= k - 1; ++j) {
                out.print("" + (i * j >= k ? i * j / k : "") + (i * j % k) + " ");
            }
            out.println();
        }
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
        new H().run();
    }
}
