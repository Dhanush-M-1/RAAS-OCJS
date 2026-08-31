import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author duke007
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DCompression solver = new DCompression();
        solver.solve(1, in, out);
        out.close();
    }

    static class DCompression {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            List<Integer> divisors = Divisors.divisorsOfN(n);
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String temp = in.next();
                for (int j = 0; j < temp.length(); j++) {
                    int fourBits = Integer.parseInt(temp.substring(j, j + 1), 16);
                    matrix[i][4 * j] = ((fourBits & 8) / 8);
                    matrix[i][4 * j + 1] = ((fourBits & 4) / 4);
                    matrix[i][4 * j + 2] = ((fourBits & 2) / 2);
                    matrix[i][4 * j + 3] = ((fourBits & 1) / 1);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] += matrix[i][j - 1];
                }
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
            int ans = 1;
            for (int i = 0; i < divisors.size(); i++) {
                int x = divisors.get(i);
                int y = n / x;
                boolean flag = true;
                for (int j = 0; j < y; j++) {
                    for (int k = 0; k < y; k++) {
                        int u = j * x;
                        int v = k * x;
                        int p = u + x - 1;
                        int q = v + x - 1;
                        int totalCount = matrix[p][q];
                        if (v > 0)
                            totalCount -= matrix[p][v - 1];
                        if (u > 0)
                            totalCount -= matrix[u - 1][q];
                        if (v > 0 && u > 0)
                            totalCount += matrix[u - 1][v - 1];
                        if (totalCount != 0 && totalCount != (x * x)) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag)
                        break;
                }
                if (flag)
                    ans = x;
            }
            out.print(ans);
        }

    }

    static class Divisors {
        public static List<Integer> divisorsOfN(int N) {
            List<Integer> divisors = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if ((N % i) == 0)
                    divisors.add(i);
            }
            return divisors;
        }

    }
}

