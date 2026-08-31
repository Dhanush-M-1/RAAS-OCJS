import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Rene
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
            int pos = 0;
            int neg = 0;
            int n = -1;
            boolean positive = true;
            ArrayList<Boolean> signs = new ArrayList<Boolean>();
            while (in.hasNext()) {
                String s = in.next();
                char c = s.charAt(0);
                if (c == '?') {
                    if (positive) {
                        pos++;
                        signs.add(true);
                    } else {
                        neg++;
                        signs.add(false);
                    }
                } else if (c == '-') positive = false;
                else if (c == '+') positive = true;
                else if (c != '=') n = Integer.valueOf(s);
            }
//        System.out.printf("pos %d neg %d n %d\n", pos, neg, n);
            if (n > pos * n - neg || n < pos - neg * n) {
                out.println("Impossible");
                return;
            }
            String result = "";
            int target = n;
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for (boolean b : signs) {
                if (b) {
                    int minA = target - n * (pos - 1) + neg;
                    int maxA = Math.min(n, target - pos + 1 + n * neg);
                    result += " + " + maxA;
                    numbers.add(maxA);
                    target -= maxA;
                    pos--;
                } else {
                    int maxA = Math.min(n, n * pos - neg + 1 - target);
                    result += " - " + maxA;
                    numbers.add(-maxA);
                    target += maxA;
                    neg--;
                }
            }
            result += " = " + n;
            out.println("Possible");
            out.println(result.substring(3));
        }

    }
}

