import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Aeroui
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            boolean[] playing = new boolean[4];
            playing[1] = playing[2] = true;

            for (int i = 0; i < n; ++i) {
                int winner = in.nextInt();
                if (!playing[winner]) {
                    out.println("NO");
                    return;
                }

                for (int j = 1; j <= 3; ++j) {
                    if (j != winner && playing[j]) {
                        playing[j] = false;
                    } else if (j != winner && !playing[j]) {
                        playing[j] = true;
                    }
                }

            }

            out.println("YES");
        }

    }
}

