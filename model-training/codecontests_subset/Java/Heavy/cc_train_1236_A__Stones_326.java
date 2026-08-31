import java.io.*;
import java.util.StringTokenizer;

public class mainA {
    public static PrintWriter out = new PrintWriter(System.out);
    public static FastScanner enter = new FastScanner(System.in);

    public static void main(String[] args) throws IOException {
        int T=enter.nextInt();

        for (int i = 0; i < T; i++) {
            solve();
        }
        out.close();
    }

    private static void solve() throws IOException {
        int a=enter.nextInt();
        int b=enter.nextInt();
        int c=enter.nextInt();
        int max=0;
        for (int i = 0; i <=a ; i++) {
            for (int j = 0; j <=b ; j++) {
                if(j+2*i<=b && 2*j<=c){
                    max=Math.max(3*(i+j), max);
                }
            }
        }
        out.println(max);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer stok;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() throws IOException {
            while (stok == null || !stok.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return null;
                }
                stok = new StringTokenizer(s);
            }
            return stok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        char nextChar() throws IOException {
            return (char) (br.read());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }
}
