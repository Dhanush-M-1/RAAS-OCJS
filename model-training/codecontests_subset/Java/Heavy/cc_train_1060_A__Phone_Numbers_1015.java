import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author ky112233
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        APhoneNumbers solver = new APhoneNumbers();
        solver.solve(1, in, out);
        out.close();
    }

    static class APhoneNumbers {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            String str = in.next();
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == '8') cnt++;
            }
            int cnt2 = n / 11;
            out.println(Math.min(cnt, cnt2));
        }

    }
}

