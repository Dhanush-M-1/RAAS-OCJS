import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Vector;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ReaderFastIO in = new ReaderFastIO(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DCompression solver = new DCompression();
        solver.solve(1, in, out);
        out.close();
    }

    static class DCompression {
        public void solve(int testNumber, ReaderFastIO in, PrintWriter out) {

            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int[][] prefixSum = new int[n][n];
            List<Integer> divisores = new Vector<>();

            for (int i = 0; i < n; i++) {
                fill(i, in.nextLine().toCharArray(), matrix);
            }

            for (int i = 0; i < n; i++) {

                prefixSum[i][0] = matrix[i][0];
                for (int j = 1; j < n; j++) {
                    prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j];
                }
            }

            for (int i = n; i >= 2; i--) {
                if (n % i == 0) divisores.add(i);
            }

            for (Integer div : divisores) {
                if (isOk(matrix, prefixSum, div, n, out)) {
                    out.println(div);
                    return;
                }
            }

            out.println("1");
        }

        private boolean isOk(int[][] matrix, int[][] prefixSum, int x, int n, PrintWriter out) {

            int m = n / x;

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < m; j++) {

                    int offsetRow = i * x;
                    int offsetCol = j * x;
                    int sum = 0;

                    for (int ki = offsetRow; ki < offsetRow + x; ki++) {

                        sum += prefixSum[ki][offsetCol + x - 1] - (prefixSum[ki][offsetCol] - matrix[ki][offsetCol]);

                    }

                    if (sum != 0 && sum != x * x) return false;

                }
            }


            return true;
        }

        private void fill(int row, char[] line, int[][] matrix) {

            for (int j = 0; j < line.length; j++) {

                int number = "0123456789ABCDEF".indexOf(line[j]);
                int index = (j + 1) * 4 - 1;
                while (number > 0) {
                    matrix[row][index--] = number % 2;
                    number /= 2;
                }
            }

        }

    }

    static class ReaderFastIO {
        BufferedReader br;
        StringTokenizer st;

        public ReaderFastIO() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public ReaderFastIO(InputStream input) {
            br = new BufferedReader(new InputStreamReader(input));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}

