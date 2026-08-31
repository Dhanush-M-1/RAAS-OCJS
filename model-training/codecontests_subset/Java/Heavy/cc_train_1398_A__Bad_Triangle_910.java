import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class A {

    int INF = (int) 1e9 + 5; // "Бесконечность"

    public static void main(String[] args) throws IOException {
        new A().run();
    }

    private void run() throws IOException {
        Reader in = new Reader();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        solve(in, pw);
        pw.close();
    }

    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x() {
            return x;
        }
    }

    static class Reader {
        BufferedReader br;
        StringTokenizer st;

        Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Reader(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        String nextLine() throws IOException {
            return br.readLine();
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
    }

    private void solve(Reader in, PrintWriter out) throws IOException {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            Pair[] a = new Pair[n];

            for(int i = 1; i <= n; i++){
                a[i-1] = new Pair(in.nextInt(), i);
            }

            Arrays.sort(a, Comparator.comparing(Pair::x));

            int b = a[0].x;
            int c = a[1].x;
            int d = a[a.length-1].x;

            if(d >= b+c){
                out.println(a[0].y +" " + a[1].y + " "+a[a.length-1].y);
            }else out.println(-1);
        }

    }
}


