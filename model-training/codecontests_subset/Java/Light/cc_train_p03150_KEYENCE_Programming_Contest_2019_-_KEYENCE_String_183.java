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
        KEYENCE2019_B solver = new KEYENCE2019_B();
        solver.solve(1, in, out);
        out.close();
    }

    static class KEYENCE2019_B {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String keyence = "keyence";
            String str = in.next();

            int i = 0;
            for (i = 0; i < str.length(); i++) {
                if (str.charAt(i) != keyence.charAt(i)) {
                    keyence = keyence.substring(i);
                    break;
                }
            }

            if (str.endsWith(keyence)) {
                out.print("YES");
            } else {
                out.print("NO");
            }
        }

    }
}

