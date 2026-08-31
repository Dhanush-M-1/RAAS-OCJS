import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Gaurav
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class TaskA {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            HashSet<Integer> set = new HashSet<Integer>();
            HashSet<Integer> set2 = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                set.add(in.nextInt());
            }
            for (int i = 0; i < m; i++) {
                set2.add(in.nextInt());
            }
            int flag = 0;
            int ans = 0;
            Iterator it = set2.iterator();
            while (it.hasNext()) {
                int tm = (Integer) it.next();
                if (!set.add(tm)) {
                    ans = tm;
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                out.println("NO");
            else
                out.println("YES" + "\n" + 1 + " " + ans);
        }

    }
}

