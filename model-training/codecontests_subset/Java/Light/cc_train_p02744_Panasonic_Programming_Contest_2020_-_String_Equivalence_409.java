import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
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
        DStringEquivalence solver = new DStringEquivalence();
        solver.solve(1, in, out);
        out.close();
    }

    static class DStringEquivalence {
        public void solve(int testNumber, Scanner in, PrintWriter out) {

            // 初めて出てくる順番が必ずa,b,c,d,e,f,g,h,i,jの順であればよいことがわかる
            int n = in.nextInt();
            bfs("", n, 'a');
        }

        void bfs(String str, int n, char ch) {
            // ch は新しく作る場合どこまで使ってよいかを示すもの
            if (n == 0) {
                System.out.println(str);
                return;
            }
            for (char c = 'a'; c <= ch; c++) {
                StringBuilder sb = new StringBuilder(str);
                sb.append(c);
                if (c == ch) {
                    bfs(new String(sb), n - 1, (char) (ch + 1));
                } else {
                    bfs(sb.toString(), n - 1, ch);
                }
            }
        }

    }
}

