
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class A {
    
    void solve() throws Exception{
        int a = in.nextInt(), b = in.nextInt();
        int ans = 0;
        int t = 0;
        while (a > 0) {
            a--;t++;
            ans++;
            if (t % b == 0) {
                t = 0;
                a++;
            }
        }
        out.println(ans);
    }
    
    String input = "";
    String output = "";
    FastScanner in;
    PrintWriter out;

    void run() throws Exception {
        if (input.length() == 0) {
            in = new FastScanner(System.in);
        } else {
            in = new FastScanner(new File(input));
        }
        if (output.length() == 0) {
            out = new PrintWriter(System.out);
        } else {
            out = new PrintWriter(new File(output));
        }

        solve();

        out.close();

    }

    public static void main(String[] args) throws Exception {
        new A().run();
    }

    class FastScanner {

        BufferedReader bf;
        StringTokenizer st;

        public FastScanner(InputStream is) {
            bf = new BufferedReader(new InputStreamReader(is));
        }

        public FastScanner(File fr) throws FileNotFoundException {
            bf = new BufferedReader(new FileReader(fr));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(bf.readLine());
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int[] readIntArray(int length) {
            int arr[] = new int[length];
            for (int i = 0; i<length; i++)
                arr[i] = nextInt();
            return arr;
        }
    }
}
