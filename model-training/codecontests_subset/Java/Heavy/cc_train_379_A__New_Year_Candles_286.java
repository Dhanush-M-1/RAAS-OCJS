
import java.io.*;
import java.util.StringTokenizer;

// Новогодние свечки
public class A {
    FastScanner in;
    PrintWriter out;

    public void solve() {
        int a = in.nextInt();
        int b = in.nextInt();
        int h = 0;
        int os = 0;
        while (true) {
            h += a;
            os = os + (a % b);
            a = a / b;
            if (os >= b) {
                a += 1;
                os -= b;
            }
            if (a == 0) break;
        }

        h += os / b;
        out.println(h);
    }

    public void run() {
        in = new FastScanner(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));

        solve();

        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;


        FastScanner(InputStreamReader f) {
            br = new BufferedReader(f);
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }

    public static void main(String[] arg) {
        new A().run();
    }
}
