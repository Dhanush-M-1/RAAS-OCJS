import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Erasyl Abenov
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
            try (PrintWriter out = new PrintWriter(outputStream)) {
                TaskB solver = new TaskB();
                solver.solve(1, in, out);
            }
    }
}

class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
       int n = in.nextInt();
       int countTwo = 0;
       int countOne = 0;
       for(int i = 0; i < n; ++i){
           if(in.nextInt() > 100) countTwo++;
           else countOne++;
       }
       if(countTwo % 2 == 0 && countOne % 2 == 0 || countTwo % 2 != 0 && countOne > 1 && countOne % 2 == 0){
           out.println("YES");
       }else{
           out.println("NO");
       }
    }
}

class InputReader {
    private final BufferedReader reader;
    private StringTokenizer tokenizer;
    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }
 
    public String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
 
    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(nextLine());
        }
        return tokenizer.nextToken();
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