import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.IOException;

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
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int q = in.nextInt();

        FenwickTree beforeTree = new FenwickTree(n);
        FenwickTree afterTree = new FenwickTree(n);

        long[] beforeOrders = new long[n];
        long[] afterOrder = new long[n];

        for (int i = 0; i < q; i++) {
            int type = in.nextInt();
            if (type == 1) {
                int day = in.nextInt() - 1;
                long volume = in.nextInt();

                long toB = Math.min(b, beforeOrders[day] + volume);
                if (toB > beforeOrders[day]) {
                    beforeTree.inc(day, toB - beforeOrders[day]);
                    beforeOrders[day] = toB;
                }

                long toA = Math.min(a, afterOrder[day] + volume);
                if (toA > afterOrder[day]) {
                    afterTree.inc(day, toA - afterOrder[day]);
                    afterOrder[day] = toA;
                }

            } else {
                int start = in.nextInt() - 1;
                long sum = 0;
                if (start > 0) {
                    sum += beforeTree.sum(0, start - 1);
                }

                if (start + k <= n - 1) {
                    sum += afterTree.sum(start + k, n - 1);
                }
                out.println(sum);
            }
        }
    }

    private static class FenwickTree {
        int n;
        long[] t;

        public FenwickTree(int n) {
            this.n = n;
            t = new long[n];
        }

        long sum(int r) {
            long result = 0;
            for (; r >= 0; r = (r & (r + 1)) - 1)
                result += t[r];
            return result;
        }

        void inc(int i, long delta) {
            for (; i < n; i = (i | (i + 1)))
                t[i] += delta;
        }

        long sum(int l, int r) {
            return sum(r) - sum(l - 1);
        }
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

