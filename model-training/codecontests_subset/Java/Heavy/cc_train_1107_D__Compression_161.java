import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D {

    public static void main(String[] args) throws IOException {
        init();

        String[] hex = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
                "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        HashMap<Character, Integer> hexToDec = new HashMap<>();
        for (int i = 0; i < nums.length; i++) hexToDec.put(nums[i], i);


        int n = nextInt();

        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            String row = next();
            StringBuilder bin = new StringBuilder();
            for (int j = 0; j < row.length(); j++) {
                bin.append(hex[hexToDec.get(row.charAt(j))]);
            }

            for (int j = 0; j < bin.length(); j++) {
                matrix[i][j] = bin.charAt(j) - '0';

                if (i > 0) matrix[i][j] += matrix[i - 1][j];

                if (j > 0) matrix[i][j] += matrix[i][j - 1];
                    

                // Subtract double counted part
                if (i > 0 && j > 0) matrix[i][j] -= matrix[i - 1][j - 1];
            }
        }

//        for (int[] row: matrix) System.out.println(Arrays.toString(row));

        int ans = 1;
        for (int i = n; i > 1; i--) {
            if (n % i == 0 && compatible(i, matrix)) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
    
    private static boolean compatible(int x, int[][] matrix) {
        boolean compat = true;
        for (int i = x; i - 1 < matrix.length; i += x) {
            for (int j = x; j - 1 < matrix[i - 1].length; j += x) {
                int wholeRegion = calcNum(i - x, j - x,i - 1, j - 1, matrix);
                int bigRegion = wholeRegion % (x*x) == 0 ? wholeRegion / (x*x) : -1;
//                System.out.println("For (" + i + ", " + j + ")" + ": " + " " + bigRegion);
                if (bigRegion != 0 && bigRegion != 1) {
                    compat = false;
                    break;
                }
            }
            
            if (!compat) break;
        }
        
        return compat;
    }

    private static int calcNum(int r1, int c1, int r2, int c2, int[][] matrix) {
        return matrix[r2][c2] -
                (c1 > 0 ? matrix[r2][c1 - 1] : 0) -
                (r1 > 0 ? matrix[r1 - 1][c2] : 0) +
                ((r1 > 0 && c1 > 0) ? matrix[r1 - 1][c1 - 1] : 0);
    }

    //Input Reader
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
    }

    private static String next() throws IOException {
        String read;
        while (!tokenizer.hasMoreTokens()) {
            read = reader.readLine();
            if (read == null || read.equals(""))
                return "-1";
            tokenizer = new StringTokenizer(read);
        }

        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}