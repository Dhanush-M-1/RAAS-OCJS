import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.function.BiFunction;


public class Main {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
//        InputReader in = new InputReader(new File("in.txt"));
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();

    }
}

class Task {
    public void solve(InputReader in, PrintWriter out) {
        in.nextInt();
        String str = in.nextLine();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') continue;

            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) == '.') continue;

                int diff = j - i;
                boolean t = true;

                for (int k = 1; k <= 4; k++) {
                    int p = i + diff * k;
                    if (p >= str.length() || str.charAt(p) == '.') {
                        t = false;
                        break;
                    }
                }

                if (t) {
                    out.println("yes");
                    return;
                }

            }

        }

        out.println("no");
    }
}

class MaxFlow {
    private boolean[] visited;
    public int maxFlow(int[][] cap, int s, int t) {
        int flow = 0;


        while (true) {
            visited = new boolean[cap.length];
            int df = findPath(cap, s, t, Integer.MAX_VALUE);
            if (df <= 0) break;
            flow += df;
        }

        return flow;
    }

    private int findPath(int[][] cap, int u, int t, int minRes) {
        if (u == t) return minRes;
        visited[u] = true;

        for(int i = 0; i < visited.length; i++) {
            if (!visited[i] && cap[u][i] > 0) {
                int df = findPath(cap, i, t, Math.min(minRes, cap[u][i]));

                if (df > 0 ) {
                    cap[u][i] -= df;
                    cap[i][u] += df;
                    return df;
                }
            }
        }

        return 0;
    }
}

class IOUtils {
    public static int[][] readArray(InputReader in, int length) {
        int[][] arrays = new int[length][length];

        for (int[] row : arrays) {
            for (int i = 0; i < row.length; i++) {
                row[i] = in.nextInt();
            }
        }
        return arrays;
    }
}

class StopWatch {
    private static double start, end;
    private static final double h = 1000000000.0;

    //	public static final double h = 1000.0;
    public static void start() {
        init();
        start = System.nanoTime();
//		start = System.currentTimeMillis();
    }

    public static double elapsedTime() {
        end = System.nanoTime();
//		end = System.currentTimeMillis();
        double areault = (end - start) / h;
        System.out.println(areault);
        init();
        return areault;
    }

    private static void init() {
        start = end = 0.0;
    }
}


class InputReader {
    private BufferedReader reader;
    public StringTokenizer tokenizer;

    InputReader(File file) {
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        tokenizer = null;
    }

    InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (Exception e) {

            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine() {
        String str = "";
        try {
            str = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return str;
    }

    public boolean hasMoreTokens() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String str = null;
            try {
                str = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException();
            }
            if (str == null) return false;
            tokenizer = new StringTokenizer(str);
        }
        return true;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}