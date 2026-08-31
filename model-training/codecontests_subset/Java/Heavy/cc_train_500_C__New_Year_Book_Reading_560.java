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
        int[] w = new int[n+1];
        for (int i = 1; i <= n; i++) {
            w[i] = in.nextInt();
        }
        boolean[] read = new boolean[n+1];
        int[] stack = new int[n+1];
        int index = 1;
        int[] day = new int[m];
        for (int i = 0; i < m; i++) {
            day[i] = in.nextInt();
            if(!read[day[i]]){
                stack[day[i]] = index++;
                read[day[i]] = true;
            }
        }
        int cost = 0;
        for (int i = 0; i < m; i++) {
            int curPos = stack[day[i]];
            for (int j = 1; j <= n; j++) {
                if(stack[j] < curPos && read[j]){
                    ++stack[j];
                    cost += w[j];
                }
            }
            stack[day[i]] = 1;
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
