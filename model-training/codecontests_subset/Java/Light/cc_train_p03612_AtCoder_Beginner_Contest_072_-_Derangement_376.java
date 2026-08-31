import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            // 入力
            int n = Integer.parseInt(in.next()) + 1; //1-indexed
            boolean[] idx = new boolean[110000];
            Arrays.fill(idx, true);
            long ng = 0;
            for (int i = 1; i < n; i++) {
                if (Integer.parseInt(in.next()) == i) {
                    idx[i] = false;
                    ng++;
                }
            }
            long ans = 0;
            int i = 1;

            while (ng > 0 || i < n - 1) {
                if (!idx[i]) {
                    if (!idx[i + 1]) {
                        ng -= 2;
                        i += 2;
                    } else {
                        ng -= 1;
                        i += 1;
                    }
                    ans++;
                } else {
                    i += 1;
                }
            }


            // 出力
            out.println(ans);

        }

    }
}

