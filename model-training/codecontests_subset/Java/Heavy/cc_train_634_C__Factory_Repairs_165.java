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

    int[] xb;
    int[] xa;
    int[] fTreeLeft;
    int[] fTreeRight;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int q = in.nextInt();

        xb = new int[n+1];
        xa = new int[n+1];

        fTreeLeft = new int[n+1];
        fTreeRight = new int[n+1];

        for (int i=0; i<q; i++){
            int cmd = in.nextInt();

            if (cmd == 1){
                int d = in.nextInt();
                int val = in.nextInt();

                int toAddB = Math.min(val, b - xb[d]);
                add(fTreeLeft, d, toAddB);
                xb[d] += toAddB;

                int toAddA = Math.min(val, a - xa[n+1-d]);
                add(fTreeRight, n+1 - d, toAddA);
                xa[n+1-d] += toAddA;
            } else {
                int d = in.nextInt();

                int val = query(fTreeLeft, d-1) + query(fTreeRight, n+1 -(d+k));

                out.println(val);
            }

        }

    }

    private int query(int[] tree, int d) {
        int sol =0;

        while (d > 0){
            sol += tree[d];
            d -= d & (-d);
        }

        return sol;
    }

    private void add(int[] tree, int d, int val) {
        if (val <= 0){
            return;
        }

        while (d < tree.length){
            tree[d] += val;
            d = d + (d & (-d));
        }
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;


    public InputReader(InputStream stream){
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public String next(){
        while (tokenizer == null || !tokenizer.hasMoreTokens()){
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException("FATAL ERROR", e);
            }
        }

        return tokenizer.nextToken();
    }

    public int nextInt(){
        return Integer.valueOf(next());
    }

}

