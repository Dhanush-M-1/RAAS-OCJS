import java.util.HashSet;
import java.util.ArrayDeque;
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
        int []w = new int[n + 1];
        for (int i = 0; i < n; i++) {
            w[i + 1] = in.nextInt();
        }
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        long sum = 0;
        for (int i = 0; i < m; i++) {
            int k = in.nextInt();
            if (!hashSet.contains(k)){
                for(int z:queue){
                    sum += w[z];
                }
                queue.addFirst(k);
                hashSet.add(k);
            }
            else {
                for(int z:queue){
                    if (z == k)break;
                    sum += w[z];
                }
                queue.remove(Integer.valueOf(k));
                queue.addFirst(k);
            }
        }
        out.print(sum);
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

