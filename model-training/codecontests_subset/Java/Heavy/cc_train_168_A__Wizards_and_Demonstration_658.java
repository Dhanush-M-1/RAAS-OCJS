
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.Arrays;

public class Solution {
//    ----------------------------------------------------------------------------

    public static void main(String[] args) throws IOException {

        //IF INPUT-OUTPUT is via files. uncomment use the below 3 lines of code. comment out the next 4
        //     File file = new File("input.txt"); // here input.txt and output.txt being the file names 
        //   InputReader in = new InputReader(new FileInputStream(file));
        //    PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"));
        //ELSE 
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {

        static final int mod = 1000000007;

        public void solve(int testNumber, InputReader in, PrintWriter out) {

            double n = in.nextDouble();
            double x = in.nextDouble();
            double y = in.nextDouble();

            double needed = Math.ceil((y / 100) * n);
            out.println((x >= needed) ? 0 : (int) (needed - x));

        }

    }

//    ----------------------------------------------------------------------------
    // MAIN - INPUT - OUTPUT 
    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public Double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int[] nextIntArray(int arraySize) {
            int array[] = new int[arraySize];

            for (int i = 0; i < arraySize; i++) {
                array[i] = nextInt();
            }

            return array;
        }
//need to review this again
//        public char[][] nextMatrix(int row, int col) {
//
//            char[][] m = new char[row][col];
//            
//            return m;
//        }

    }
}
