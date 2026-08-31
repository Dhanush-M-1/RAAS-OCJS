
import java.io.*;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem460A_20151027_232759 extends PrintWriter {

    void solve() throws IOException {
        int s = 0;
        for (int i = 0; i < 5; i++)
            s += nextInt();
        if (s == 0) {
            println(-1);
            return;
        }
        println(s % 5 == 0 ? s / 5 : -1);
    }

    // ----------------- system stuff ----------------------- //

    public static String SOURCE;

    void run() throws IOException {
        try {
            solve();
            close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            Locale.setDefault(Locale.US);
        } catch (Exception ignore) {
        }
        if (SOURCE == null) {
            new Problem460A_20151027_232759().run();
        } else {
            new Problem460A_20151027_232759(SOURCE).run();
        }
    }

    BufferedReader br;
    StringTokenizer stok;

    Problem460A_20151027_232759() {
        super(System.out);
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    Problem460A_20151027_232759(String s) throws FileNotFoundException {
        super("".equals(s) ? "output.txt" : s + ".out");
        br = new BufferedReader(new FileReader("".equals(s) ? "input.txt" : s + ".in"));
    }

    String next() {
        try {
            while (stok == null || !stok.hasMoreTokens()) {
                String str = br.readLine();
                stok = new StringTokenizer(str);
            }
        } catch (IOException e) {
            return null;
        }
        return stok.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    int[] nextIntArray(int len) {
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = nextInt();
        }
        return res;
    }
}
