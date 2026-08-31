import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputStreamReader in = new InputStreamReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {

    int[] t;
    int[] l;
    int[] r;
    int[] var;
    int[] numbers;
    int[] maxVal;
    int[] sum;

    final int INF = (int) 1e8;

    public void solve(int testNumber, InputStreamReader inSt, PrintWriter out) {
        InputReader in = new InputReader(inSt);
        int n = in.nextInt();
        int m = in.nextInt();

        t = new int[m];
        l = new int[m];
        r = new int[m];
        var = new int[m];

        for (int i = 0; i < t.length; i++) {
            t[i] = in.nextInt();
            l[i] = in.nextInt() - 1;
            r[i] = in.nextInt() - 1;
            var[i] = in.nextInt();
        }

        maxVal = new int[n];
        Arrays.fill(maxVal, (int) 1e9);
        sum = new int[n];

        if (!doOps()) {
            out.println("NO");
            return;
        }
        numbers = Arrays.copyOf(maxVal, maxVal.length);

        if (doCheck()) {
            out.println("YES");
            for (int a : maxVal) {
                out.print(a + " ");
            }
        } else {
            out.println("NO");
        }
    }

    private boolean doCheck() {
        for (int i = 0; i < t.length; i++) {
            if (t[i] == 1) {
                for (int j = l[i]; j <= r[i]; j++) {
                    numbers[j] += var[i];
                }
            } else {
                int max = Integer.MIN_VALUE;
                for (int j = l[i]; j <= r[i]; j++) {
                    max = Math.max(max, numbers[j]);
                }
                if (max != var[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean doOps() {
        for (int i = 0; i < t.length; i++) {
            if (t[i] == 1) {
                for (int j = l[i]; j <= r[i]; j++) {
                    sum[j] += var[i];
                }
            } else {

                for (int j = l[i]; j <= r[i]; j++) {
                    int tmp = var[i] - sum[j];
                    maxVal[j] = Math.min(maxVal[j], tmp);
                    if (maxVal[j] < -(int) 1e9) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    class InputReader {
        public BufferedReader reader;
        private String[] currentArray;
        int curPointer;

        public InputReader(InputStreamReader inputStreamReader) {
            reader = new BufferedReader(inputStreamReader);
        }

        public String next() {
            try {
                currentArray = null;
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void nextChars(char[] t) {
            try {
                currentArray = null;
                reader.read(t);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public char nextChar() {
            try {
                currentArray = null;
                return (char) reader.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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

        public long nextLong() {
            if ((currentArray == null) || (curPointer >= currentArray.length)) {
                try {
                    currentArray = reader.readLine().split(" ");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                curPointer = 0;
            }
            return Long.parseLong(currentArray[curPointer++]);
        }

    }
}

