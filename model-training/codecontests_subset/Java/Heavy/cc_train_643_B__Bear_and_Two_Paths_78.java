import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.jar.Pack200;

public class B {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

	void solve() throws IOException {
        int t = 1;
        int i = 0;
        while (i++ < t) {
            solveTest();
        }
	}

    List<Integer>[] g;

    void solveTest() throws IOException {
        int n = readInt();
        int m = readInt();
        int a = readInt();
        int b = readInt();
        int c = readInt();
        int d = readInt();
        if(n == 4 || m <= n) {
            out.println("-1");
            return;
        }
        List<Integer> mid = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i == a || i == b || i == c || i == d) {
                continue;
            }
            mid.add(i);
        }
        out.print(a + " ");
        out.print(c + " ");
        for(int i: mid) {
            out.print(i + " ");
        }
        out.print(d + " ");
        out.println(b);

        out.print(c + " ");
        out.print(a + " ");
        for(int i: mid) {
            out.print(i + " ");
        }
        out.print(b + " ");
        out.println(d);

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
        new B().run();
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