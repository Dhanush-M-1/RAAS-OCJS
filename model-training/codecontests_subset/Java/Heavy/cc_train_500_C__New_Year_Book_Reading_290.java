import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
        }
        List<Integer> order = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt() - 1;
            if (!order.contains(b[i])) {
                order.add(b[i]);
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            int j;
            for (j = 0; order.get(j) != b[i]; j++) {
                res += w[order.get(j)];
            }
            order.remove(j);
            order.add(0, b[i]);
        }
        out.println(res);
    }
}

class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int p[] = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
        }
        int a[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = in.next();
            for (int j = 0; j < n; j++) {
                a[i][j] = line.charAt(j) == '1' ? 1 : 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if ((a[i][k] & a[k][j]) == 1) {
                        a[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (p[i] > p[j] && a[i][j] == 1) {
                    int tmp = p[i];
                    p[i] = p[j]; p[j] = tmp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(p[i] + " ");
        }
        out.println();
    }
}

class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int t = in.nextInt();
        int d[] = new int[n];
        for (int i = 0; i < n - 1; i++) {
            d[i] = in.nextInt();
        }
        int i = 0;
        while (i <= t-1) {
            if (i == t-1) {
                out.println("YES");
                return;
            }
            i += d[i];

        }
        out.println("NO");
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