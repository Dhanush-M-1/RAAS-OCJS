import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author ZYCSwing
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            String s = in.next();
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < s.length() - 1; ++i) {
                String key = s.substring(i, i + 2);
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }

            int ma = 0;
            String res = "";
            for (Map.Entry entry : map.entrySet()) {
                if ((int) entry.getValue() > ma) {
                    ma = (int) entry.getValue();
                    res = (String) entry.getKey();
                }
            }
            out.println(res);
        }

    }
}

