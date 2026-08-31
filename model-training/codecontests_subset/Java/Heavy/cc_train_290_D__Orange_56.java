import java.io.*;
import java.util.StringTokenizer;

public class ProblemD {

    public static void main(String[] args) throws Exception {
        new ProblemD();
    }

    private BufferedReader in = null;
    private PrintWriter out = null;
    private StringTokenizer tok = new StringTokenizer("");

    public ProblemD() throws Exception {
        init();
        solve();
        in.close();
        out.close();
    }

    private void solve() throws Exception {
        String s = in.readLine();
        int n = nextInt();
        char[] a = s.toLowerCase().toCharArray();
        String ans = "";
        for (int i = 0; i < a.length; ++i) {
            char c = a[i];
            if (c < n + 97) {
                ans += ("" + c).toUpperCase();
            } else {
                ans += ("" + c).toLowerCase();
            }
        }
        out.println(ans);
    }


    private void init() throws FileNotFoundException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }


    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }


    private String nextToken() throws IOException {
        while (!tok.hasMoreTokens()) {
            String s = in.readLine();
            if (s == null) {
                return null;
            }
            tok = new StringTokenizer(s);
        }
        return tok.nextToken();
    }

}
            