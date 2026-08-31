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
        AElections solver = new AElections();
        solver.solve(1, in, out);
        out.close();
    }

    static class AElections {
        public void solve(int testNumber, Scanner in, PrintWriter out) {

            int n = in.nextInt();

            int sum = 0;
            int maxVal = 0;
            for (int i = 0; i < n; i++) {
                int val = in.nextInt();
                if (val > maxVal) maxVal = val;
                sum += val;
            }

            int VotesCount = maxVal * n - sum;
            while (VotesCount <= sum) {
                maxVal++;
                VotesCount = maxVal * n - sum;
            }

            out.print(maxVal);
        }

    }
}

