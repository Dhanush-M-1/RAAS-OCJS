import java.util.*;
import java.io.*;

public class codeforces {

    static ArrayList<Integer>[] graph;
    static boolean[] used;

    static void dfs(int v) {
        used[v] = true;
        for (int u : graph[v]) {
            if (!used[u]) {
                dfs(u);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(scan.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + m];
        used = new boolean[n + m];
        for (int i = 0; i < n + m; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(scan.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            graph[r].add(c + n);
            graph[c + n].add(r);
        }
        int cnt = 0;
        for (int i = 0; i < n + m; i++) {
            if (!used[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt - 1);
    }
}