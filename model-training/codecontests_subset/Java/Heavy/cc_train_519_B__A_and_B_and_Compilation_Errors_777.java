import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
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
        BAAndBAndCompilationErrors solver = new BAAndBAndCompilationErrors();
        solver.solve(1, in, out);
        out.close();
    }

    static class BAAndBAndCompilationErrors {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            List<List<Integer>> errors = new ArrayList<>();
            for (int i = 0; i < 3; ++i) {
                errors.add(new ArrayList<>());
                for (int j = 0; j < n - i; ++j) {
                    errors.get(i).add(in.nextInt());
                }
                Collections.sort(errors.get(i));
            }

            for (int i = 0; i < 2; ++i) {
                List<Integer> a = errors.get(i);
                List<Integer> b = errors.get(i + 1);
                for (int j = 0; j < a.size(); ++j) {
                    if (j == b.size() || !a.get(j).equals(b.get(j))) {
                        out.println(a.get(j));
                        break;
                    }
                }
            }
        }

    }
}

