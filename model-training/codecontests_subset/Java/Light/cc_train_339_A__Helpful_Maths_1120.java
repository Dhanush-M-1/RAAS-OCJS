import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

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
        helpfulmaths solver = new helpfulmaths();
        solver.solve(1, in, out);
        out.close();
    }

    static class helpfulmaths {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            char[] map = in.nextLine().toCharArray();
            ArrayList<Character> list = new ArrayList<Character>();
            for (int i = 0; i < map.length; i++)
                if (i % 2 == 0)
                    list.add(map[i]);
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size() - 1; i++)
                sb.append(list.get(i) + "+");
            sb.append(list.get(list.size() - 1));
            out.println(sb.toString());
        }

    }
}

