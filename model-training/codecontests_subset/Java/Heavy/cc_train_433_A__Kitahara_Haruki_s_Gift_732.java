import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A248 {

    private BufferedReader in;
    private StringTokenizer st;
    private PrintWriter out;

    void solve() throws IOException {

        int n = nextInt();
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            if (x == 200)
                a++;
            else
                b++;
        }
        if (a % 2 == 1) {
            if (b >= 2 && b % 2 == 0) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        } else {
            if (b % 2 == 0) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }

    }

    A248() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        eat("");
        solve();
        out.close();
    }

    private void eat(String str) {
        st = new StringTokenizer(str);
    }

    String next() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            eat(line);
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) throws IOException {
        new A248();
    }

    int gcd(int a, int b) {
        if (b > a)
            return gcd(b, a);
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

}
