import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;

public class EasyTask {
    public static void main(String args[]) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        TaskA solver = new TaskA();
        solver.solve(1, in, out);

        out.close();
    }
}

class TaskA {
    public int min(int a, int b) { return a < b ? a : b; }
    public int max(int a, int b) { return a < b ? b : a; }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();

        int a[][] = new int[3][n];

        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < n-i; ++j)
                a[i][j] = in.nextInt();

        Arrays.sort(a[0]);
        Arrays.sort(a[1]);
        Arrays.sort(a[2]);

        for (int i = n-1; i >= 0; --i)
            if (a[0][i] != a[1][i]) {
                out.println(a[0][i]);
                break;
            }

        for (int i = n-1; i >= 0; --i)
            if (a[1][i] != a[2][i]) {
                out.println(a[1][i]);
                break;
            }
    }
}

class InputReader {
    BufferedReader in;
    StringTokenizer st;

    public InputReader(InputStream stream) {
        in = new BufferedReader(new InputStreamReader(stream));
        eat("");
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() { return Double.parseDouble(next()); }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public String next() {
        while (!st.hasMoreTokens())
            eat(nextLine());
        return st.nextToken();
    }

    public String nextLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new InputMismatchException();
        }
    }

    public void eat(String str) {
        if (str == null) throw new InputMismatchException();
        st = new StringTokenizer(str);
    }
}