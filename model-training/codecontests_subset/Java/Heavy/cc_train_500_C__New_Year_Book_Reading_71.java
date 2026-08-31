import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
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
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        int[] days = new int[m];
        boolean[] read = new boolean[n];
        int[] stack = new int[n];
        int id = 1;
        for (int i = 0; i < m; i++) {
            days[i] = in.nextInt() - 1;
            if(!read[days[i]]){
                stack[days[i]] = id++;
                read[days[i]] = true;
            }
        }
        int cost = 0;
        int curPos;
        for (int i = 0; i < m; i++) {
            curPos = stack[days[i]];
            for (int j = 0; j < n; j++) {
                if(stack[j] < curPos && read[j]){
                    cost += w[j];
                    ++stack[j];
                }
            }
            stack[days[i]] = 1;
        }
        out.println(cost);
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

    public int nextInt(){
        return Integer.parseInt(next());
    }

}
