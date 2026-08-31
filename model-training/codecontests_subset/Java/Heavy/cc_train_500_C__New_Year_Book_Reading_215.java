
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProbC {

    public static void main(String args[]) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        SolverC.InputReader in = new SolverC.InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SolverC solver = new SolverC();
        int testCount = 1;
        for (int i = 1; i <= testCount; i++) {
            solver.solve(in, out);
        }
        out.close();
    }
}

class SolverC {

    public void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        int w[] = new int[n+1];
        for (int i=1; i<=n; i++) {
            w[i] = in.nextInt();
        }

        int arr[] = new int[n+1];
        int curr = 0;
        int cont[] = new int[n+1];
        int sum = 0;
        int total = 0;

        for (int i=0; i<m; i++) {
            int x = in.nextInt();

            if (cont[x] == 0) {
                arr[curr++] = x;
                total += sum;
                sum += w[x];
                cont[x] = 1;
            } else {
                int j = 0;
                for (; j<curr; j++) {
                    if (arr[j] == x) {
                        break;
                    }
                }
                if (j != curr-1) {
                    for (int k=j+1; k<curr; k++) {
                        total += w[arr[k]];
                        arr[k-1] = arr[k];
                    }
                    arr[curr-1] = x;
                }
            }
        }

        out.println(total);
    }

    static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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
    }
}
