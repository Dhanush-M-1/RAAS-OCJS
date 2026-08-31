/**
 * Created with IntelliJ IDEA.
 * User: Zakhar_Voit
 * Date: 11.06.12
 * Time: 2:16
 */

import java.io.*;
import java.util.*;

import static java.lang.System.clearProperty;
import static java.lang.System.exit;

public class A {
    BufferedReader in;
    PrintWriter out;
    StringTokenizer st = new StringTokenizer("");
    int a, b, c;

    void init() {

    }

    void read() throws IOException {
        a = nextInt();
        b = nextInt();
        c = nextInt();
    }

    void solve() {

    }

    void write() {
        out.println((int)Math.ceil(c * 1.0 * a / b) - c);
    }

    public void run() throws IOException {
        openIO();
        init();
        read();
        solve();
        write();
        out.close();
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new A().run();
                } catch (Throwable e) {
                    e.printStackTrace();
                    exit(999);
                }
            }
        }, "1", 1 << 23).start();
    }

    public void openIO() throws IOException {
        if (new File("input.txt").exists()) {
            System.setIn(new FileInputStream("input.txt"));
            out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        } else {
            out = new PrintWriter(System.out);
        }
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    String nextToken() throws IOException {
        while (!st.hasMoreTokens())
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextLine() throws IOException {
        st = new StringTokenizer("");
        return in.readLine();
    }

    boolean EOF() throws IOException {
        while (!st.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null)
                return true;
            st = new StringTokenizer(s);
        }
        return false;
    }
}