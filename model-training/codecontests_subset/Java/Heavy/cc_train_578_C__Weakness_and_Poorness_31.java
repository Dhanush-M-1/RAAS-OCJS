import java.io.*;
import java.util.StringTokenizer;

public class Solver2 {
    private BufferedReader in;
    private PrintWriter out;

    Solver2() throws IOException {
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter(new FileWriter("output.txt"));
        } catch (Exception ex) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
        try {
            solve();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new Solver2();
    }

    StringTokenizer st;

    String next() throws IOException {
        while (st == null || !st.hasMoreElements())
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }

    String nextLine() throws IOException {
        return in.readLine();
    }

    int nextInt() throws IOException {
        return Integer.valueOf(next());
    }

    long nextLong() throws IOException {
        return Long.valueOf(next());
    }

    double[] a;

    double getMin(double x) {
        double min = 0;
        double max = 0;
        double sm = 0;
        double result = 0;
        for (int i = 0; i < a.length; i++) {
            sm += a[i] - x;
            result = Math.max(result, Math.abs(sm-min));
            result = Math.max(result, Math.abs(sm-max));
            min = Math.min(min, sm);
            max = Math.max(max, sm);
        }
        return result;
    }

    void ternarySearch() {
        double lf = -2000000;
        double r = 2000000;
        for (int i = 0; i < 100; i++) {
            double left = (lf * 2 + r) / 3;
            double right = (lf + 2 * r) / 3;
            if (getMin(left) < getMin(right)) r = right;
            else lf = left;
        }
        System.out.println(getMin((lf+r)/2));
    }

    private void solve() throws IOException {
        int n = nextInt();
        a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        ternarySearch();
    }

}
