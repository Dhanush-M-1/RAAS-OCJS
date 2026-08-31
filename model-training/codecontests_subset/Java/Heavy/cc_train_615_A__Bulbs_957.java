import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class C515 {
    public static void main(String [] args) {
        InputStream inputReader = System.in;
        OutputStream outputReader = System.out;
        InputReader in = new InputReader(inputReader);
        PrintWriter out = new PrintWriter(outputReader);
        Algorithm solver = new Algorithm();
        solver.solve(in, out);
        out.close();
    }
}

class Algorithm {
    void solve(InputReader ir, PrintWriter pw) {
        int a;
        int[] mm=new int[105];
        int n = ir.nextInt();
        int m = ir.nextInt();
        for (int i = 1; i <= n; i++) {
            a = ir.nextInt();
            for (int j = 1; j <= a; j++) mm[ir.nextInt()] = 1;
        }
        a = 0;
        for (int i = 1; i <= m; i++) if (mm[i] == 1) a++;
        pw.print(a == m ? "YES" : "NO");

    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

}