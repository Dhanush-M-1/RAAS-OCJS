import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


/**
 * @authod Rashedul Hasan Rijul
 */
public class Solution {

    FastReader fastReader;
    OutputStream outputStream = System.out;
    PrintWriter out;

    List<String> matrix;

    Map<Character, String> bits;
    int[][] sum;
    int[] rowSum;
    int[] colSum;

    public Solution() {
    }

    public Solution(FastReader fastReader) {
        this.fastReader = fastReader;
        this.out = new PrintWriter(outputStream, true);
    }

    public void solve() {

        init();

        int n = fastReader.nextInt();

        matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = fastReader.next();
            matrix.add(s);
        }

/*        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(getValue(i, j));
            }
            out.println();
        }*/

        initSums(n);

       /* for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(sum[i + 1][j + 1] + " ");
            }
            out.println();
        }
*/
/*        List<Integer> divisor = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisor.add(i);
            }
        }*/

        /*int lo = 0, hi = divisor.size() - 1;

        int mid;

        while (lo < hi) {

            mid = lo + hi;
            mid /= 2;

            if (possible(n, divisor.get(mid))) {
                if (lo == mid) {
                    if (possible(n, divisor.get(hi))) {
                        lo = hi;
                        break;
                    } else {
                        break;
                    }
                }
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }

        int ans = divisor.get(lo);*/

        for (int i = n; i >= 1; i--) {
            if (n % i == 0) {
                if (possible(n, i)) {
                    out.println(i);
                    break;
                }
            }
        }
        // out.println(ans);
        out.close();
    }

    private boolean possible(int n, int x) {

        if (x == 1) {
            return true;
        }

        int cnt = x * x;

        for (int i = 0; i < n; i += x) {
            for (int j = 0; j < n; j += x) {
                int sum = getSum(i, j, (i + x - 1), (j + x - 1));

                if (sum == 0 || sum == cnt) {
                    continue;
                } else {
                    return false;
                }

            }
        }
        return true;
    }

    private int getSum(int r, int c, int r1, int c1) {
        r++;
        c++;
        r1++;
        c1++;

        return sum[r1][c1] - sum[r - 1][c1] - sum[r1][c - 1] + sum[r - 1][c - 1];
    }

    private void initSums(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                sum[i + 1][j + 1] = sum[i][j] + rowSum[i + 1] + colSum[j + 1];

                if (getValue(i, j) == 1) {
                    sum[i + 1][j + 1]++;
                    rowSum[i + 1]++;
                    colSum[j + 1]++;
                }
            }
        }
    }

    private void init() {

        bits = new HashMap<>();

        bits.put('0', "0000");
        bits.put('1', "0001");
        bits.put('2', "0010");
        bits.put('3', "0011");
        bits.put('4', "0100");
        bits.put('5', "0101");
        bits.put('6', "0110");
        bits.put('7', "0111");
        bits.put('8', "1000");
        bits.put('9', "1001");
        bits.put('A', "1010");
        bits.put('B', "1011");
        bits.put('C', "1100");
        bits.put('D', "1101");
        bits.put('E', "1110");
        bits.put('F', "1111");

        sum = new int[5210][5210];
        rowSum = new int[5210];
        colSum = new int[5210];
    }

    public int getValue(int r, int c) {

        String s = matrix.get(r);

        char ch = s.charAt(c / 4);

        String s1 = bits.get(ch);

        return s1.charAt(c % 4) - '0';
    }


    public static void main(String args[]) throws FileNotFoundException {

        // for testing in local
        // FastReader fastReader = FastReader.getFileReader("in.txt");

        FastReader fastReader = FastReader.getDefaultReader();

        Solution soln = new Solution(fastReader);
        soln.solve();
    }

    /**
     * TEMPLATE METHOD --------
     */
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        public static FastReader getFileReader(String fileName) throws FileNotFoundException {
            return new FastReader(new InputStreamReader(new FileInputStream(new File("in.txt"))));
        }

        public static FastReader getDefaultReader() throws FileNotFoundException {
            return new FastReader();
        }

        public FastReader(InputStreamReader inputStreamReader) {
            br = new BufferedReader(inputStreamReader);
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
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
