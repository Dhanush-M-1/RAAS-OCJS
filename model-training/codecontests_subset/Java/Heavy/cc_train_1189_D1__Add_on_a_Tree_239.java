import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Task {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new Task().run();
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

    class lolkek implements Comparable<lolkek> {
        int x;
        int y;

        public lolkek(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(lolkek a) {
            if (x == a.x) {
                return (y - a.y);
            }
            return x - a.x;
        }
    }

    public boolean isSimple(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
            if(i * i > n) {
                break;
            }
        }
        return true;
    }



    public void solve() throws IOException {
        int n = readInt();
        ArrayList[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList();
        }
        for(int i = 0; i < n - 1; i++) {
            int x = readInt() - 1;
            int y = readInt() - 1;
            graph[x].add(y);
            graph[y].add(x);
        }
        for(int i = 0; i < n; i++) {
            if(graph[i].size() == 2) {
                out.print("NO");
                return;
            }
        }
        out.print("YES");
    }
}