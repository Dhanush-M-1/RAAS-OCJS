import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        B solver = new B();
        solver.solve(1, in, out);
        out.close();
    }

    static class B {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            // 入力
            StringBuilder S = new StringBuilder();
            StringBuilder tmp = new StringBuilder();
            S.append(in.next());
            boolean ok = false;

            if (S.length() == 7) {
                if ("keyence".equals(S.toString())) {
                    ok = true;
                }
            } else {
                int sublen = S.length() - 7;
                for (int i = 0; i < S.length() - sublen; i++) {
                    tmp.append(S.toString());
                    if ("keyence".equals(tmp.replace(i, i + sublen, "").toString())) {
                        ok = true;
                        break;
                    }
                    tmp.setLength(0);
                }
            }

            out.println(ok ? "YES" : "NO");

        }

    }
}

