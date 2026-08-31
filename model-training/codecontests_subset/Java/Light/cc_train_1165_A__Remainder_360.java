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
        ARemainder solver = new ARemainder();
        solver.solve(1, in, out);
        out.close();
    }

    static class ARemainder {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            String str = in.next();
            int cnt = 0;
            int i = n - 1;
            while (i > n - x - 1) i--;
            for (int j = i + 1; j < n; j++) {
                if (j == n - y - 1) {
                    if (str.charAt(j) == '0') cnt++;
                } else if (str.charAt(j) == '1') cnt++;
            }
            out.println(cnt);
        }

    }
}

