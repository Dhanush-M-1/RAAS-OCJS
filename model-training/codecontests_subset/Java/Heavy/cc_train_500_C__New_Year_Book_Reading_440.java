import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
}

class Task {
    public void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++)
            w[i] = in.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
            b[i]--;
        }
        int result = 0;
        List<Integer> books = new LinkedList<Integer>();
        for (int i = 0; i < m; i++) {
            int ix = books.indexOf(b[i]);
            if (ix == -1) {
                for (int j = 0; j < books.size(); j++)
                    result += w[books.get(j)];
                books.add(0, b[i]);
            } else {
                for (int j = 0; j < ix; j++) {
                    result += w[books.get(j)];
                }
                books.remove(ix);
                books.add(0, b[i]);
            }
        }
        out.print(result);
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

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong(){
        return Long.parseLong(next());
    }
}