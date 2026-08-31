import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        FastPrinter out = new FastPrinter(System.out);
        int n = in.nextInt(), k = in.nextInt(), operations[][] = new int[k][4], arr[] = new int[n], arr1[], change[] = new int[n];
        Arrays.fill(arr, 100000000);
        for (int i = 0; i < k; i++) {
            operations[i][0] = in.nextInt();
            operations[i][1] = in.nextInt();
            operations[i][2] = in.nextInt();
            operations[i][3] = in.nextInt();
            if (operations[i][0] == 1)
                for (int j = operations[i][1] - 1, limit = operations[i][2], d = operations[i][3]; j < limit; j++)
                    change[j] += d;
            else
                for (int j = operations[i][1] - 1, limit = operations[i][2], m = operations[i][3]; j < limit; j++)
                    if (arr[j] + change[j] > m)
                        arr[j] = m - change[j];
        }
        arr1 = arr.clone();
        for (int i = 0; i < k; i++)
            if (operations[i][0] == 1)
                for (int j = operations[i][1] - 1, limit = operations[i][2], d = operations[i][3]; j < limit; j++)
                    arr[j] += d;
            else {
                int max = -1000000001, m = operations[i][3];
                for (int j = operations[i][1] - 1, limit = operations[i][2]; j < limit; j++)
                    max = Math.max(max, arr[j]);
                if (max != m) {
                    out.println("NO");
                    out.close();
                    return;
                }
            }
        out.println("YES");
        for (int i = 0; i < n; i++)
            out.print(arr1[i] + " ");
        out.close();
    }
}

class InputReader {
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

    public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int[] readIntArray(int n) {
        int[] ret = new int[n];
        for (int i = 0; i < n; i++)
            ret[i] = nextInt();
        return ret;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

}

class FastPrinter extends PrintWriter {

    public FastPrinter(OutputStream out) {
        super(out);
    }

    public FastPrinter(Writer out) {
        super(out);
    }

}