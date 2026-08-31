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
        AKeanuReeves solver = new AKeanuReeves();
        solver.solve(1, in, out);
        out.close();
    }

    static class AKeanuReeves {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            String str = in.next();
            if (str.length() == 1) {
                out.println(1);
                out.println(str);
                return;
            }
            int zeroCnt = 0, oneCnt = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') oneCnt++;
                else zeroCnt++;
            }
            if (zeroCnt != oneCnt) {
                out.println(1);
                out.println(str);
                return;
            }
            out.println(2);
            out.println(str.substring(0, 1) + " " + str.substring(1));
        }

    }
}

