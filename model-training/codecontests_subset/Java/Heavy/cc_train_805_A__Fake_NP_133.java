import java.io.*;
import java.util.*;

public class Main {

    static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;

    final static long INF = Long.MAX_VALUE;

    private final static Random rnd = new Random();

    boolean checkIndex(int index, int size) {
        return (0 <= index && index < size);
    }


    void solve() throws IOException {
        int a = rI();
        int b = rI();
        if (a==b){
            out.print(minInt(a,b));
        } else out.print(2);

    }


    // ===========================================================================
    long minLong(long... values) {
        long min = Integer.MAX_VALUE;
        for (long value : values) {
            min = Math.min(min, value);
        }
        return min;
    }

    long maxLong(long... values) {
        long max = Integer.MIN_VALUE;
        for (long value : values) {
            max = Math.max(max, value);
        }
        return max;
    }

    int maxInt(int... values) {
        int max = Integer.MIN_VALUE;
        for (int value : values) {
            max = Math.max(max, value);
        }
        return max;
    }

    int minInt(int... values) {
        int min = Integer.MAX_VALUE;
        for (int value : values) {
            min = Math.min(min, value);
        }
        return min;
    }

    // ==============================================================================

    public static void main(String[] args) {
        new Main().run();
    }

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok;

    long maxA(int[] ans) {
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] > max) {
                max = ans[i];

            }
        }
        return max;
    }

    long minA(long[] a) {
        long min = Long.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    void init() throws FileNotFoundException {
        if (ONLINE_JUDGE) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
        tok = new

                StringTokenizer("");

    }

    void run() {
        try {
            long timeStart = System.currentTimeMillis();

            init();
            solve();

            out.close();

            long timeEnd = System.currentTimeMillis();
            System.err.println("Time = " + (timeEnd - timeStart) + " COMPILED");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    long memoryTotal, memoryFree;

    void memory() {
        memoryFree = Runtime.getRuntime().freeMemory();
        System.err.println("Memory = " + ((-memoryTotal + memoryFree) >> 10) + " KB");
    }

    String readLine() throws IOException {
        return in.readLine();
    }

    String delimiter = " ";

    String rS() throws IOException {
        while (!tok.hasMoreTokens()) {
            String nextLine = readLine();
            if (null == nextLine)
                return null;

            tok = new StringTokenizer(nextLine);
        }

        return tok.nextToken(delimiter);
    }

    int[] rA(int b) {
        int a[] = new int[b];
        for (int i = 0; i < b; i++) {
            try {
                a[i] = rI();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return a;
    }

    int rI() throws IOException {
        return Integer.parseInt(rS());
    }

    long rL() throws IOException {
        return Long.parseLong(rS());
    }

    void sort(int[] a) {
        Integer arr[] = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = a[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < a.length; i++) {
            a[i] = arr[i];
        }
    }

}