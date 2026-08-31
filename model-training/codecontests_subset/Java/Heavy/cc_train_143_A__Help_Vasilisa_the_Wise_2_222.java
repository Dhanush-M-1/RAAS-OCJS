import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author mprodev
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        AHelpVasilisaTheWise2 solver = new AHelpVasilisaTheWise2();
        solver.solve(1, in, out);
        out.close();
    }

    static class AHelpVasilisaTheWise2 {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int r1 = in.nextInt(), r2 = in.nextInt();
            int c1 = in.nextInt(), c2 = in.nextInt();
            int d1 = in.nextInt(), d2 = in.nextInt();

            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    int fir = r1 - i;
                    int sec = r2 - j;
                    HashSet<Integer> set = new HashSet<>();
                    set.add(i);
                    set.add(j);
                    set.add(fir);
                    set.add(sec);
                    if (set.size() != 4) continue;
                    else set.clear();
                    if (fir == i) continue;
                    if (sec == j) continue;
                    if (fir < 1 || fir > 9) continue;
                    if (sec < 1 || sec > 9) continue;
                    if (i + j != c1) continue;
                    if (fir + sec != c2) continue;
                    if (i + sec != d1) continue;
                    if (j + fir != d2) continue;

                    out.println(i + " " + fir);
                    out.println(j + " " + sec);
                    return;
                }
            }
            out.println(-1);
        }

    }
}

