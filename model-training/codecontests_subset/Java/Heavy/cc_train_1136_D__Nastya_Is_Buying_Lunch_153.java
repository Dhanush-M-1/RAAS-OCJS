import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * <a href="http://codeforces.com/contests/1136">Codeforces Round #546 (Div. 2)</a> (2019-03-12T00:35:00+08:00)
 *
 * @author Klnsyf-Sun
 */
public class Main {

    static void solve() throws IOException {
        int n = nextInt(), m = nextInt();
        ArrayList<Integer> line = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            line.add(nextInt());
        }
        HashMap<Integer, LinkedList<Integer>> edges = new HashMap<>();
        for (int index = 0; index < m; index++) {
            int u = nextInt(), v = nextInt();
            if (edges.containsKey(u)) {
                edges.get(u).add(v);
            } else {
                edges.put(u, new LinkedList<>());
                edges.get(u).add(v);
            }
        }
        int counter = 0;
        for (int u = n - 2; u >= 0 && line.size() > 1; ) {
            boolean flag = true;
            for (int v = u + 1; v < line.size(); v++) {
                if (!edges.getOrDefault(line.get(u), new LinkedList<>()).contains(line.get(v))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                counter++;
                line.remove(u);
            }
            u--;
        }
        System.out.println(counter);
    }


    private static StreamTokenizer in;
    private static Scanner sc;
    private static PrintWriter out;

    static {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        sc = new Scanner(new BufferedInputStream(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
    }

    public static void main(String[] args) throws IOException {
        solve();
        sc.close();
        out.flush();
    }

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    private static double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }

    private static String nextString() throws IOException {
        in.nextToken();
        return in.sval;
    }

}

