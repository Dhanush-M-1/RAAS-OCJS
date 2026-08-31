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
 * @author captainTurtle
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
            String p = in.next();
            int sayac = in.nextInt();
            int k = -1;
            String test[] = new String[sayac];

            for (int i = 0; i < sayac; i++) {
                test[i] = in.next();
            }
            for (int i = 0; i < sayac; i++) {
                for (int j = 0; j < sayac; j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(test[i].charAt(1));
                    sb.append(test[j].charAt(0));
                    if (p.equalsIgnoreCase(sb.toString()) || p.equalsIgnoreCase(test[i])) {
                        k = 0;
                        break;
                    } else {
                        continue;
                    }

                }
                if (k == 0)
                    break;
            }
            if (k == -1)
                System.out.print("NO");
            else if (k == 0)
                System.out.print("YES");
        }

    }
}

