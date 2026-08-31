import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

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

        int w[] = new int[n];
        int b[] = new int[m];

        int total = 0;
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
            total += w[i];
        }
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }


        int matrix[][] = new int[n][m];

        for (int i = 0; i < m; i++) {
            matrix[0][i] = b[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j=m-1; j>0; j--){
                int cand = matrix[i-1][j-1];
                if (cand == 0) continue;
                boolean exist = false;
                for (int k=i-1; k>=0; k--){
                    if (matrix[k][j] == cand) exist = true;
                }
                if (!exist){
                    matrix[i][j] = cand;
                }
            }

            for (int j=1; j<m; j++){
                if (matrix[i][j] == 0 && matrix[i][j-1] != 0){
                    matrix[i][j] = matrix[i][j-1];
                }
            }
        }

        int cost = 0;
        for (int j=m-2; j>=0; j--){
            int one = b[j+1];
            for (int i=0; i<n; i++){
                if (matrix[i][j] == one){
                    break;
                }
                if (matrix[i][j] > 0)
                cost += w[matrix[i][j]-1];
            }
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

    public int nextInt() {
        return Integer.parseInt(next());
    }
}

