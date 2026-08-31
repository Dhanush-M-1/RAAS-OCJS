
import java.awt.Point;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
import static java.lang.Math.*;

public class B implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(null, new B(), "", 256 * (1L << 20)).start();
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

           // in = new BufferedReader(new FileReader("src/input.txt"));
            // out = new PrintWriter("output.txt");

            Locale.setDefault(Locale.US);
            solve();
            in.close();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
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

    // solution
    void solve() throws IOException {
        
        int n = readInt();
        int beaver = readInt();
        boolean[] free = new boolean[n + 1];
        int[] length = new int[n + 1];
        Arrays.fill(free, true);
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = readInt();
            free[parent[i]] = false;
        }
        for (int i = 1; i <= n; i++) {
            if (free[i]) {
                calculateLength(i, parent, length, beaver);
            }
        }
        boolean[] possible = new boolean[n + 1];
        possible[beaverLength] = true;
        for (int i = 1; i <= n; i++) {
            if (free[i]) {
                for (int j = possible.length - 1; j >= 1; j--) {
                    if (length[i] > 0 && j + length[i] < possible.length && possible[j]) {
                        possible[j + length[i]] = true;
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (possible[i]) {
                out.println(i);
            }
        }
    }
    
    int beaverLength;

    void calculateLength(int x, int[] parent, int[] length, int beaver) {
        if (parent[x] == 0) {
            length[x] = 1;
        } else {
            calculateLength(parent[x], parent, length, beaver);
            length[x] = length[parent[x]] + 1;
        }
        
        if (x == beaver) {
            beaverLength = length[x];
            length[x] = Integer.MIN_VALUE / 2;//to easily remove from knapsnack
        }
    }
}