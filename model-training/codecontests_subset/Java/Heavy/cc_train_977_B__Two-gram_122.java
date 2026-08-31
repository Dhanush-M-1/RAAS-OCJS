import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.HashMap;

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
        BTwogram solver = new BTwogram();
        solver.solve(1, in, out);
        out.close();
    }

    static class BTwogram {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            String s = in.next();
            HashMap<String, Integer> h = new HashMap<>();
            for (int i = 0; i < n - 1; i++) {
                String temp;
                temp = ("" + s.charAt(i) + s.charAt(i + 1));
                if (h.containsKey(temp)) {
                    int k = h.get(temp);
                    h.put(temp, ++k);
                } else {
                    h.put(temp, 1);
                }
            }
            int ans = -1;
            String ss = "";
            for (String t : h.keySet()) {
                if (ans < h.get(t)) {
                    ans = h.get(t);
                    ss = t;
                }
            }
            out.println(ss);
        }

    }
}

