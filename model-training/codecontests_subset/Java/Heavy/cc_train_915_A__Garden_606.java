import java.io.*;
import java.util.*;

import static java.lang.Integer.min;


public class Main {

    int LNF = (int) (2 * 1e9 + 1);

    ArrayList<road> g[];
    int sz[];

    public void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();
        int ans = (int) 1e9;
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            if (k % a == 0) ans = min(ans, k / a);
        }
        pw.print(ans);
    }

    class road {
        int to;
        int w;

        public road(int t, int ww) {
            to = t;
            w = ww;
        }
    }

    public void run() {
        try {
//            br = new BufferedReader(new FileReader("input.txt"));
//            pw = new PrintWriter(new FileWriter("output.txt"));
            br = new BufferedReader(new InputStreamReader(System.in));
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//            br = new BufferedReader(new FileReader("movie.in"));
//            pw = new PrintWriter(new FileWriter("movie.out"));
            solve();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    BufferedReader br;
    StringTokenizer in;
    PrintWriter pw;

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    public static void main(String[] args) throws IOException {
        //Locale.setDefault(Locale.US);
        new Main().run();
    }
}