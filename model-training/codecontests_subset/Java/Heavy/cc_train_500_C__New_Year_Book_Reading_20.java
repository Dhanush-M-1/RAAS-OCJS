import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.math.BigInteger;
import java.io.OutputStream;
import java.util.Stack;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Hai-Khanh Nguyen
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskC {
    int n, m;
    int[] book, w;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        book = new int[m+1];
        w = new int[n+1];
        for (int i=0; i<n; ++i) w[i] = in.nextInt();
        for (int i=0; i<m; ++i) book[i] = in.nextInt();
        boolean[] check = new boolean[n+10];
        int g =0;
        Stack<Integer> res = new Stack<Integer>();
        Stack<Integer> ttt = new Stack<Integer>();

        for (int i=0; i<m; ++i) {
            if (check[book[i]]) continue;
            ttt.push(book[i]);
            check[book[i]] = true;
        }
        for (int i=1; i<=n; ++i) {
            if (!check[i]) {
                ttt.push(i);
            }
        }
        while (!ttt.empty()) {
            res.push(ttt.pop());
        }
        int sum = 0;
        for (int i=0; i<m; ++i) {
            while (res.peek() != book[i]) {
                int tmp = res.pop();
                sum += w[tmp-1];
                ttt.push(tmp);
            }
            res.pop();
            while (!ttt.empty()) {
                res.push(ttt.pop());
            }
            res.push(book[i]);
        }
        out.println(sum);
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
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

}
