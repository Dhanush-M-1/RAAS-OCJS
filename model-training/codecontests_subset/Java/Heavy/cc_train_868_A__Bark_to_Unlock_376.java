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
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {
        public boolean isPresent(String s, String[] words) {
            for (int i = 0; i < words.length; i++) {
                for (int j = i; j < words.length; j++) {
                    String comb = words[i] + words[j];
                    if (comb.contains(s)) return true;
                    comb = words[j] + words[i];
                    if (comb.contains(s)) return true;
                }
            }
            return false;
        }

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String s = in.next();
            int n = in.nextInt();

            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = in.next();
            }


            if (isPresent(s, words)) {
                out.println("YES");
            } else {
                out.println("NO");
            }

        }

    }
}

