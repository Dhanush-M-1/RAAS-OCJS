import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author silviase
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ASTring solver = new ASTring();
        solver.solve(1, in, out);
        out.close();
    }

    static class ASTring {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String str = in.next();
            int tCnt = 0;
            int sCnt = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'S') {
                    // S
                    sCnt++;
                } else {
                    // T
                    if (sCnt > 0) sCnt--;
                    else tCnt++;
                }
            }

            out.println(sCnt + tCnt);
        }

    }
}

