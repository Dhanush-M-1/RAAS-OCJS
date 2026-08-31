import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {

    private void solve() throws Exception {
        int n = nextInt();
        int m = nextInt();
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++) w[i] = nextInt();
        LinkedList<Integer> l = new LinkedList<Integer>();
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int b = nextInt();
            ListIterator<Integer> it = l.listIterator();
            while (it.hasNext()) {
                int book = it.next();
                if (book == b) break;
                sum += w[book];
            }
            l.remove(Integer.valueOf(b));
            l.addFirst(b);
        }
        out.println(sum);
    }

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public void run() {
        try {
//            in = new BufferedReader(new FileReader("input.txt"));
//            out = new PrintWriter("output.txt");
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
//            for (int t = nextInt(); t > 0; t--)
                solve();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
