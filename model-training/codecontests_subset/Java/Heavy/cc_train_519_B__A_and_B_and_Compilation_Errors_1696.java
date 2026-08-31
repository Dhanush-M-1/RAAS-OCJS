import java.io.*;
import java.util.*;

public class A implements Runnable {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new Thread(null, new A(), "", 128 * (1L << 20)).start();

    }

    void init() throws FileNotFoundException {
        Locale.setDefault(Locale.US);
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    long timeBegin, timeEnd;

    void time() {
        timeEnd = System.currentTimeMillis();
        System.err.println("Time = " + (timeEnd - timeBegin));
    }

    public void run() {
        try {
            timeBegin = System.currentTimeMillis();

            init();
            solve();

            out.close();
            time();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }


    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine());
            } catch (Exception e) {
                return null;
            }
        }
        return tok.nextToken();
    }

    String readString(String s) throws IOException {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine(), s + "\n \t");
            } catch (Exception e) {
                return null;
            }
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    int readInt(String s) throws IOException {
        return Integer.parseInt(readString(s));
    }

    int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            int temp = a;
            a = b;
            b = temp;
        }
        return a;
    }


    void solve() throws IOException {
        int n = readInt();
        int[] first = new int[n];
        int[] second = new int[n - 1];
        int[] third = new int[n - 2];
        for (int i = 0; i < n; i++) {
            first[i] = readInt();
        }
        Arrays.sort(first);
        for (int i = 0; i < n - 1; i++) {
            second[i] = readInt();
        }
        Arrays.sort(second);
        for (int i = 0; i < n - 2; i++) {
            third[i] = readInt();
        }
        Arrays.sort(third);
        int ans1 = 0;
        int ans2 = 0;
        boolean flag = false;
        for (int i = 0; i < n - 1; i++) {
            if (first[i] != second[i]) {
                flag = true;
                ans1 = first[i];
                break;
            }
        }
        if (!flag) ans1 = first[n - 1];
        flag = false;
        for (int i = 0; i < n - 2; i++) {
            if (third[i] != second[i]) {
                flag = true;
                ans2 = second[i];
                break;
            }
        }
        if (!flag) ans2 = second[n - 2];

        System.out.println(ans1);
        System.out.println(ans2);

    }
}
