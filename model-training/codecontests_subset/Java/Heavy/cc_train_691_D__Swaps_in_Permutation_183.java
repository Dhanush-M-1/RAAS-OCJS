import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class CodeForces {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader inputReader = new InputReader(System.in);
        PrintWriter printWriter = new PrintWriter(System.out, true);

        int n = inputReader.nextInt();
        int m = inputReader.nextInt();
        int[] p = new int[n];
        WeightedQuickUnion wqu = new WeightedQuickUnion(n);
        PriorityQueue<Integer>[] queues = new PriorityQueue[n];
        int next;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = inputReader.nextInt() - 1;
            queues[i] = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        }
        for (int i = 0; i < m; i++) {
            wqu.uniteSites(inputReader.nextInt() - 1, inputReader.nextInt() - 1);
        }
        for (int i = 0; i < n; i++) {
            next = wqu.findRoot(i);
            queues[next].add(p[i]);
        }
        for (int i = 0; i < n; i++) {
            res[i] = queues[wqu.findRoot(i)].poll();
        }
        for (int i = 0; i < n; i++) {
            printWriter.print(res[i] + 1 + " ");
        }

        printWriter.close();
    }

    public static class WeightedQuickUnion {
        private final int[] parent;
        private final int[] weight;

        public WeightedQuickUnion(int n) {
            parent = new int[n];
            weight = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }

        public int findRoot(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public boolean isConnected(int i, int j) {
            return findRoot(i) == findRoot(j);
        }

        public void uniteSites(int i, int j) {
            int rootI = findRoot(i);
            int rootJ = findRoot(j);
            if (rootI == rootJ) return;

            if (weight[rootI] < weight[rootJ]) {
                parent[rootI] = rootJ;
                weight[rootJ] += weight[rootI];
            }
            else {
                parent[rootJ] = rootI;
                weight[rootI] += weight[rootJ];
            }
        }
    }

    private static void shuffleArray(int[] a) {
        Random r = new Random();
        int tmp;
        for (int i = 1; i < a.length; i++) {
            tmp = r.nextInt(i + 1);
            int val = a[tmp];
            a[tmp] = a[i];
            a[i] = val;
        }
    }

    private static class InputReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        public int[] nextIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; ++i) {
                array[i] = nextInt();
            }
            return array;
        }

        public long[] nextLongArray(int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; ++i) {
                array[i] = nextLong();
            }
            return array;
        }

        public double[] nextDoubleArray(int size) {
            double[] array = new double[size];
            for (int i = 0; i < size; ++i) {
                array[i] = nextDouble();
            }
            return array;
        }

        public String[] nextStringArray(int size) {
            String[] array = new String[size];
            for (int i = 0; i < size; ++i) {
                array[i] = next();
            }
            return array;
        }

        public boolean[][] nextBooleanTable(int rows, int columns, char trueCharacter) {
            boolean[][] table = new boolean[rows][columns];
            for (int i = 0; i < rows; ++i) {
                String row = next();
                assert row.length() == columns;
                for (int j = 0; j < columns; ++j) {
                    table[i][j] = (row.charAt(j) == trueCharacter);
                }
            }
            return table;
        }

        public char[][] nextCharTable(int rows, int columns) {
            char[][] table = new char[rows][];
            for (int i = 0; i < rows; ++i) {
                table[i] = next().toCharArray();
                assert table[i].length == columns;
            }
            return table;
        }

        public int[][] nextIntTable(int rows, int columns) {
            int[][] table = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    table[i][j] = nextInt();
                }
            }
            return table;
        }

        public long[][] nextLongTable(int rows, int columns) {
            long[][] table = new long[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    table[i][j] = nextLong();
                }
            }
            return table;
        }

        public double[][] nextDoubleTable(int rows, int columns) {
            double[][] table = new double[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    table[i][j] = nextDouble();
                }
            }
            return table;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        public boolean hasNext() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line = readLine();
                if (line == null) {
                    return false;
                }
                tokenizer = new StringTokenizer(line);
            }
            return true;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(readLine());
            }
            return tokenizer.nextToken();
        }

        public String readLine() {
            String line;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return line;
        }
    }
}
