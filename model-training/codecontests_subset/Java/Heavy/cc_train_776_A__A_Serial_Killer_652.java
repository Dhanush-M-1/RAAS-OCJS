import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Yilin Chen
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
            TreeSet<String> set = new TreeSet<>();
            set.add(in.next());
            set.add(in.next());
            for (String victim : set) {
                out.print(victim + " ");
            }
            out.println();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                set.remove(in.next());
                set.add(in.next());
                for (String victim : set) {
                    out.print(victim + " ");
                }
                out.println();
            }
        }

    }
}

