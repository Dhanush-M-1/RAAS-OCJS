import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A_168 {
    FastScanner in;
    PrintWriter out;

    public void run() {
        try {
            in = new FastScanner(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void solve() throws IOException {
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        
        double one = (double)(n) / 100;
        double exactNumber = one * y;
        int exactNumberInt = new Double(Math.ceil(exactNumber)).intValue();
        if (exactNumberInt > x) {
            out.println(exactNumberInt - x);
        } else {
            out.println(0);
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStreamReader in) {
            br = new BufferedReader(in);
        }

        String nextLine() {
            String str = null;
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] arg) {
        A_168 o = new A_168();
        o.run();
    }

}
