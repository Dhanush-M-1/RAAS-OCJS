import java.io.*;
import java.util.*;

public class Main {

    void solve() throws IOException {
        int a = nextInt();
        int b = nextInt();
        
        int hours = 0;
        
        while (a>=b) {
            int t = (a/b*b);
            a-=t;
            a+=t/b;
            hours+=t;
        }
        
        hours+=a;
        
        out.print(hours);
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer st;

    public Main() {
    };

    public void goMain() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        st = new StringTokenizer("");
        solve();
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try {
            if (new File("input.txt").exists()) {
                System.setIn(new FileInputStream("input.txt"));
            }
        } catch (SecurityException e) {
        }
        ;
        Main m = new Main();
        m.goMain();
    }

    String nextToken() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    String nextString() throws IOException {
        st = new StringTokenizer("");
        return in.readLine();
    }

}
