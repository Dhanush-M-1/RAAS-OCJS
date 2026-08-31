import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Template implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void init() throws FileNotFoundException {
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        } catch (Exception e) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine(), " :");
            } catch (Exception e) {
                return null;
            }
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    int[] readIntArray(int size) throws IOException {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = readInt();
        }
        return res;
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    <T> List<T>[] createGraphList(int size) {
        List<T>[] list = new List[size];
        for (int i = 0; i < size; i++) {
            list[i] = new ArrayList<>();
        }
        return list;
    }

    public static void main(String[] args) {
        new Thread(null, new Template(), "", 1l * 200 * 1024 * 1024).start();
    }

    long timeBegin, timeEnd;

    void time() {
        timeEnd = System.currentTimeMillis();
        System.err.println("Time = " + (timeEnd - timeBegin));
    }

    long memoryTotal, memoryFree;

    void memory() {
        memoryFree = Runtime.getRuntime().freeMemory();
        System.err.println("Memory = " + ((memoryTotal - memoryFree) >> 10)
                + " KB");
    }

    public void run() {
        try {
            timeBegin = System.currentTimeMillis();
            memoryTotal = Runtime.getRuntime().freeMemory();
            init();
            solve();
            out.close();
            if (System.getProperty("ONLINE_JUDGE") == null) {
                time();
                memory();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    int[] p;

    int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    void merge(int x, int y) {
        x = find(x);
        y = find(y);
        if (new Random().nextBoolean()) {
            p[x] = y;
        } else {
            p[y] = x;
        }
    }


    void solve() throws IOException {
        String s = in.readLine();
        StringTokenizer tok = new StringTokenizer(s);
        List<Boolean> signs = new ArrayList<>();
        signs.add(true);
        int n;
        while (true) {
            String token = tok.nextToken();
            if (token.equals("?")) continue;
            if (token.equals("+")) {
                signs.add(true);
            } else if (token.equals("-")) {
                signs.add(false);
            } else {
                n = Integer.parseInt(tok.nextToken());
                break;
            }
        }
        int size = signs.size();
        int[] values = new int[size];
        boolean[] mult = new boolean[size];
        for (int i = 0; i < size; i++) {
            mult[i] = signs.get(i);
        }
        Arrays.fill(values, n);
        int current = 0;
        for (int i = 0; i < size; i++) {
            if (mult[i]) current += n;
            else current -= n;
        }

        for (int i = 0; i < size; i++) {
            if (mult[i]) {
                if (current > n) {
                    int dec = Math.min(n - 1, current - n);
                    values[i] -= dec;
                    current -= dec;
                }
            } else {
                if (current < n) {
                    int inc = Math.min(n - 1, n - current);
                    values[i] -= inc;
                    current += inc;
                }
            }
        }
        if (current == n) {
            out.println("Possible");
            for (int i = 0; i < size; i++) {
                if (i != 0) out.print(mult[i] ? "+ " : "- ");
                out.print(values[i] + " ");
            }
            out.println("= " + n);
        } else {
            out.println("Impossible");
        }

    }


}