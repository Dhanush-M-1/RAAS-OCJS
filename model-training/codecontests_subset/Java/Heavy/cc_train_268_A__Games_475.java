import java.io.*;
import java.util.Scanner;

/**
 * User: Oleksiy Pylypenko
 * Date: 1/6/13
 * Time: 1:46 PM
 */
public class A {
    static boolean debug = !"true".equalsIgnoreCase(System.getProperty("ONLINE_JUDGE"));
    private Scanner in;
    private PrintWriter out;

    private void solve() throws IOException {
        int n = in.nextInt();
        int hh[] = new int[n], aa[] = new int[n];
        for (int i = 0; i < n; i++) {
            hh[i] = in.nextInt(); aa[i] = in.nextInt();
        }
        int cnt = 0;
        for (int h = 0; h < n; h++) {
            for (int c = 0; c < n; c++) {
                if (c == h) { continue; }
                if (hh[h] == aa[c]) {
                    cnt++;
                }
            }
        }
        out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        new A().exec();
    }

    private void exec() {
        if (debug) {
            try {
                System.setIn(new FileInputStream(getClass().getName() + ".in"));
            } catch (FileNotFoundException e) {
                System.out.println(e);
                System.exit(1);
            }
        }
        in = new Scanner(new InputStreamReader(System.in));
        out = new PrintWriter(System.out, true);

        try {
            if (debug) {
                while (in.hasNext()) {
                    solve();
                }
            } else {
                solve();
            }
        } catch (IOException e) {
            if (debug) {
                System.out.println(e);
                System.exit(1);
            }
        } finally {
            out.close();
            in.close();
        }
    }

}
