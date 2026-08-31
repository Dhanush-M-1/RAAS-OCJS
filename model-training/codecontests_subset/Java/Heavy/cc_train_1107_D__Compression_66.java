import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Azhan Khan
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        DCompression solver = new DCompression();
        solver.solve(1, in, out);
        out.close();
    }

    static class DCompression {
        public static int bitset[][];

        public static int rectsum(int r1, int r2, int c1, int c2) {
            return bitset[r2][c2] - bitset[r1 - 1][c2] - bitset[r2][c1 - 1] + bitset[r1 - 1][c1 - 1];
        }

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            int n = Integer.parseInt(in.nextLine());
            bitset = new int[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                String s = in.nextLine();
                String bin = hex2binary(s);
                for (int j = 1; j <= n; j++) {
                    bitset[i][j] = bin.charAt(j - 1) - '0';
                    bitset[i][j] += bitset[i - 1][j] + bitset[i][j - 1] - bitset[i - 1][j - 1];
                }
            }
            for (int x = n; x >= 1; x--) {
                if (n % x == 0) {
                    boolean valid = true;

                    for (int i = 1; i <= n && valid; i += x) {
                        for (int j = 1; j <= n && valid; j += x) {
                            int i2 = i + x - 1;
                            int j2 = j + x - 1;
                            if (i2 > n || j2 > n) continue;

                            int sum = rectsum(i, i2, j, j2);

                            if (sum != x * x && sum != 0) {
                                valid = false;
                            }
                        }
                    }

                    if (valid) {
                        out.println(x);
                        return;
                    }
                }
            }

        }

        public static String hex2binary(String hex) {
            StringBuilder result = new StringBuilder(hex.length() * 4);
            for (char c : hex.toUpperCase().toCharArray()) {
                switch (c) {
                    case '0':
                        result.append("0000");
                        break;
                    case '1':
                        result.append("0001");
                        break;
                    case '2':
                        result.append("0010");
                        break;
                    case '3':
                        result.append("0011");
                        break;
                    case '4':
                        result.append("0100");
                        break;
                    case '5':
                        result.append("0101");
                        break;
                    case '6':
                        result.append("0110");
                        break;
                    case '7':
                        result.append("0111");
                        break;
                    case '8':
                        result.append("1000");
                        break;
                    case '9':
                        result.append("1001");
                        break;
                    case 'A':
                        result.append("1010");
                        break;
                    case 'B':
                        result.append("1011");
                        break;
                    case 'C':
                        result.append("1100");
                        break;
                    case 'D':
                        result.append("1101");
                        break;
                    case 'E':
                        result.append("1110");
                        break;
                    case 'F':
                        result.append("1111");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid hex: '" + hex + "'");
                }
            }
            return result.toString();
        }

    }

    static class FastScanner {
        BufferedReader br;

        public FastScanner(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
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