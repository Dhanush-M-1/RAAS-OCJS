import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Tifuera
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
        int w[] = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }

        int b[] = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt() - 1;
        }
        boolean[] used = new boolean[n];
        int[] privIdx = new int[n];
        Arrays.fill(privIdx, -1);

        int res = 0;
        for (int i = 0; i < m; i++) {
            Arrays.fill(used, false);
            int pIdx = privIdx[b[i]];
            int tmp = 0;
            for (int j = pIdx + 1; j < i; j++) {
                if (!used[b[j]]) {
                    used[b[j]] = true;
                    tmp += w[b[j]];
                }
            }
            res += tmp;
            privIdx[b[i]] = i;
        }

        out.println(res);
    }

}

class InputReader {
    private BufferedReader reader;
    private String[] currentArray;
    private int curPointer;

    public InputReader(InputStream inputStream) {
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }


    public int nextInt() {
        if ((currentArray == null) || (curPointer >= currentArray.length)) {
            try {
                currentArray = reader.readLine().split(" ");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            curPointer = 0;
        }
        return Integer.parseInt(currentArray[curPointer++]);
    }

}

