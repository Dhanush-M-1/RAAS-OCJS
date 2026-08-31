import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MainD {

    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        String s = in.next();
        int a = in.nextInt();
        String newS = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 'Z') {
                newS = newS + s.charAt(i);
            }
            else {
                newS = newS + (char) (s.charAt(i) - 'A' + 'a');
            }
        }
        s = "";
        for (int i = 0; i < newS.length(); i++) {
            if (newS.charAt(i) < 97 + a) {
                s = s + (char) (newS.charAt(i) - 'a' + 'A');
            }
            else {
                s = s + newS.charAt(i);
            }
        }
        out.println(s);
    }

    public void run() {
        try {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
            solve();
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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
    }

    public static void main(String[] arg) {
        new MainD().run();
    }
}
