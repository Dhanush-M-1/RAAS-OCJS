import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        ReaderD.init(System.in);
        int n = ReaderD.nextInt();
        int m = ReaderD.nextInt();
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        boolean[] isRight = new boolean[n];
        pos = new long[n];
        for (int i = 0; i < m; i++) {
            int l = ReaderD.nextInt();
            int r = ReaderD.nextInt();
            int d = ReaderD.nextInt();
            if (d > 0)isRight[r - 1] = true;
            adj.get(l - 1).add(new Edge(r - 1, d));
        }

        seen = new boolean[n];
        can = true;
        boolean foundRightMost = false;
        for (int i = 0; i < isRight.length; i++) {
            if (!isRight[i] && can) {
                if (!foundRightMost)foundRightMost = !adj.get(i).isEmpty();
//                System.out.println(i);
                pos[i] = 1;
                check(i);
            }
        }

//        System.out.println(can);
        System.out.println(can && (foundRightMost || m == 0) ? "Yes":"No");
    }

    private static ArrayList<ArrayList<Edge>> adj;
    private static long[] pos;
    private static boolean can;
    private static boolean[] seen;
    private static void check(int i){
        if (!can) return;
        for (Edge e: adj.get(i)) {
            if (pos[e.r] > 0 && pos[e.r] != 1 + e.d){
                can = false;
                return;
            }
        }

        dfs(i);
    }

    private static void dfs(int i){
        seen[i] = true;
        for (Edge e: adj.get(i)) {
            if (!seen[e.r]){
                pos[e.r] = pos[i] + e.d;
                dfs(e.r);
            }
            else {
                if (pos[e.r] != pos[i] + e.d){
                    can = false;
                    return;
                }
            }
        }
    }
}

class Edge{
    int r;
    int d;
    Edge(int r, int d){
        this.r = r;
        this.d = d;
    }
}


/**
 * Reader class based on the article at "https://www.cpe.ku.ac.th/~jim/java-io.html"
 */
class ReaderD {
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    static void init(InputStream inputStream) {
        reader = new BufferedReader(new InputStreamReader(inputStream));
        tokenizer = new StringTokenizer("");
    }

    private static String next() throws IOException {
        String read;
        while (!tokenizer.hasMoreTokens()) {
            read = reader.readLine();
            if (read == null || read.equals(""))
                return "-1";
            tokenizer = new StringTokenizer(read);
        }

        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

//    static long nextLong() throws IOException {
//        return Long.parseLong(next());
//    }
//
//    //    Get a whole line.
//    static String line() throws IOException {
//        return reader.readLine();
//    }
//
//    static double nextDouble() throws IOException {
//        return Double.parseDouble(next());
//    }
}

