import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = 1;
        //        t = in.nextInt();
        Solver s = new Solver();
        for (int i = 1; i <= t; i++) {
            s.solve(i, in, out);
        }
        out.close();
    }

}

class Solver {

    HashMap<Integer, Integer>[] v;
    boolean[] visited;
    int cnt = 0;
    TreeSet<Integer> remain;

    void solve(int test, InputReader in, PrintWriter out) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        v = new HashMap[n];
        visited = new boolean[n];
        remain = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            v[i] = new HashMap<>();
            remain.add(i);
        }
        for (int i = 0; i < m; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            v[x].put(y, 1);
            v[y].put(x, 1);
        }
        Stack<Integer> ans = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        while (remain.size() > 0 || q.size() > 0) {
            if (q.size() == 0) {
                ans.add(0);
                int first = remain.first();
                q.add(first);
                remain.remove(first);
                visited[first] = true;
                cnt = 1;
            } else {
                int at = q.remove();
                int v1 = ans.pop();
                ans.push(v1 + 1);
                ArrayList<Integer> a = new ArrayList<>();
                for (int x : remain) {
                    if (!v[at].containsKey(x) && !visited[x]) {
                        a.add(x);
                        visited[x] = true;
                    }
                }
                for (int x : a) {
                    remain.remove(x);
                    q.add(x);
                }

            }
        }
        out.println(ans.size());
        Collections.sort(ans);
        for (int x : ans) out.print(x + " ");
    }
}

class InputReader {
    BufferedReader br;
    StringTokenizer st;

    public InputReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = null;
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public String nextLine() throws IOException {
        return br.readLine();
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}