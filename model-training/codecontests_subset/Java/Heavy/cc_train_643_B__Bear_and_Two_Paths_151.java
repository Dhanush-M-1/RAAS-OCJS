import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Ilshat on 5/7/2016.
 */
public class D {
    FastScanner sc;
    PrintWriter pw;


    public void solve(){
        sc = new FastScanner();
        pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        if (n == 4) {
            pw.println(-1);
            return;
        }
        int k = sc.nextInt();
        if (k < n + 1) {
            pw.println(-1);
            return;
        }
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
        pw.print("" + a + " " + c + " ");
        for (int i = 1; i <= n; i++){
            if (i != a && i != c && i != d && i != b){
                pw.print("" + i + " ");
            }

        }
        pw.println("" + d + " " + b);

        pw.print("" + c + " " + a + " ");
        for (int i = 1; i <= n; i++){
            if (i != a && i != c && i != d && i != b){
                pw.print("" + i + " ");
            }

        }
        pw.println("" + b + " " + d);

    }

    public static void main(String[] args) {
        try {
            D m = new D();
            m.solve();
            m.pw.close();
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
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

        FastScanner(){
            br = new BufferedReader(new InputStreamReader(System.in));
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
