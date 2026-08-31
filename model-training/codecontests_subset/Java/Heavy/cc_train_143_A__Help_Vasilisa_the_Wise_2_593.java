//package A143;

/**
 *
 * @author Abdulrahman Mobarak
 */
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskA {

        int r1, r2, c1, c2, d1, d2;

        boolean check(int arr[][]) {
            return (arr[0][0] + arr[0][1] == r1)
                    && (arr[1][0] + arr[1][1] == r2)
                    && (arr[0][0] + arr[1][0] == c1)
                    && (arr[0][1] + arr[1][1] == c2)
                    && (arr[0][0] + arr[1][1] == d1)
                    && (arr[0][1] + arr[1][0] == d2)
                    && arr[0][0] != arr[0][1] 
                    && arr[0][0] != arr[1][0]
                    && arr[0][0] != arr[1][1]
                    && arr[0][1] != arr[1][0]
                    && arr[1][1] != arr[0][1] 
                    && arr[1][1] != arr[1][0];
        }

        public void solve(int testNumber, InputReader input, PrintWriter out) throws IOException {
            int arr[][] = new int[2][2];
            r1 = input.nextInt();
            r2 = input.nextInt();
            c1 = input.nextInt();
            c2 = input.nextInt();
            d1 = input.nextInt();
            d2 = input.nextInt();
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    for (int k = 1; k < 10; k++) {
                        for (int l = 1; l < 10; l++) {
                            arr[0][0] = i;
                            arr[0][1] = j;
                            arr[1][0] = k;
                            arr[1][1] = l;
                            if (check(arr)) {
                                for (int m = 0; m < 2; m++) {
                                    for (int n = 0; n < 2; n++) {
                                        out.print(arr[m][n] + " ");
                                    }
                                    out.println();
                                }
                                return;
                            }
                        }
                    }
                }
            }
            out.println(-1);
        }

    }

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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
