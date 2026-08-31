import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class SolutionCF634C {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void solve() throws IOException {
        int t = 1;
        while (t-- > 0) {
            solveTest();
        }
    }

    class SqrtDecomposition {
        int n;
        int[] a;
        int[] sqrt;
        int blockSize;
        int maxPossible;


        public SqrtDecomposition(int n, int[] a, int maxPossible) {
            this.n = n;
            this.a = a;
            this.maxPossible = maxPossible;
            blockSize = Math.max(100, (int) Math.sqrt(n));
            sqrt = new int[n / blockSize + 1];
            for (int i = 0; i < n; i += blockSize) {
                int curBlock = i / blockSize;
                int end = i + blockSize < n ? i + blockSize : n;
                for(int j = i; j < end; j++) {
                    sqrt[curBlock] += a[j];
                }
            }
        }

        void add(int index, int value) {
            if(a[index] + value > maxPossible) {
                value = maxPossible - a[index];
            }
            a[index] += value;
            sqrt[index / blockSize] += value;
        }

        int get(int from, int to) {
            if(from > to) return 0;
            int res = 0;
            int fromBlock = from / blockSize;
            int toBlock = to / blockSize;
            if(fromBlock == toBlock) {
                for(int i = from; i <= to; i++) {
                    res += a[i];
                }
                return res;
            }
            int fromEnd = endOfBlock(from);
            for(int i = from; i < fromEnd; i++) {
                res += a[i];
            }
            for(int i = toBlock * blockSize; i <= to; i++) {
                res += a[i];
            }
            for(int i = fromBlock + 1; i < toBlock; i++) {
                res += sqrt[i];
            }
            return res;
        }

        int endOfBlock(int i) {
            int start = i / blockSize * blockSize;
            return start + blockSize < n ? start + blockSize : n;
        }

    }

    private void solveTest() throws IOException {
        int n = readInt();
        int k = readInt();
        int a = readInt();
        int b = readInt();
        int q = readInt();

        SqrtDecomposition sa = new SqrtDecomposition(n, new int[n], a);
        SqrtDecomposition sb = new SqrtDecomposition(n, new int[n], b);
        for(int i = 0; i < q; i++) {
            int type = readInt();
            if(type == 1) {
                int index = readInt()-1;
                int value = readInt();
                sa.add(index, value);
                sb.add(index, value);
            } else {
                int start = readInt()-1;
                int res = sb.get(0, start-1);
                res += sa.get(start + k, n-1);
                out.println(res);
            }
        }
    }

    int get(Map<Long, Integer> map, long key) {
        if (!map.containsKey(key)) {
            return 0;
        }
        return map.get(key);
    }

    void add(Map<Long, Integer> map, long key) {
        if (!map.containsKey(key)) {
            map.put(key, 0);
        }
        map.put(key, map.get(key) + 1);
    }

    void remove(Map<Long, Integer> map, long key) {
        Integer count = map.get(key);
        if (count.equals(0)) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }

    void init() throws FileNotFoundException {
        if (ONLINE_JUDGE) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine(), " .");
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    int[] readArr(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = readInt();
        }
        return res;
    }

    long[] readArrL(int n) throws IOException {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = readLong();
        }
        return res;
    }

    public static void main(String[] args) {
        new SolutionCF634C().run();
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            init();
            solve();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }
}