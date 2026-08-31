import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by watson on 04.04.15.
 */
public class A {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        int n = in.nextInt();
        String s = in.next();

        for (int st = 0; st < n; st++) {
            for (int step = 1; step < n; step++) {
                boolean isGood = true;
                for (int i = 0; i < 5; i++) {
                    if (((st + step * i) >= n) || (s.charAt(st + step * i) == '.')) {
                        isGood = false;
                        break;
                    }
                }
                if (isGood) {
                    out.print("yes");
                    return;
                }
            }
        }
        out.print("no");
    }

    public void run() {
        try {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;



        FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
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
        new A().run();
    }
}
