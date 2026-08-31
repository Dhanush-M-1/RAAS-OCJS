import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class TaskB {
    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        TaskB taskC = new TaskB();
        taskC.open();
        taskC.solve();
        taskC.close();
    }

    String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String str = in.readLine();
            if (str == null) return null;
            else st = new StringTokenizer(str);
        }
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

    private void close() {
        out.close();
    }

    private void solve() throws IOException {
        int n = nextInt(), k = nextInt();
        int a = nextInt(), b = nextInt(), c = nextInt(), d = nextInt();
        if (n == 4 || k < n+1) {
            out.println(-1);
            return;
        }
        TreeSet<Integer> other = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            other.add(i);
        }
        other.remove(a);
        other.remove(b);
        other.remove(c);
        other.remove(d);

        StringBuilder med = new StringBuilder(" ");
        for (Integer integer : other) {
            med.append(integer).append(' ');
        }
        out.println(a + " " + c + med  + d + " " + b);
        out.println(c + " " + a + med  + b + " " + d);
    }

    private void open() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
    }

}