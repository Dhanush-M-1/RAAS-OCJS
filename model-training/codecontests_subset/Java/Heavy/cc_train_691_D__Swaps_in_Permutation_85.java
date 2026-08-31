import java.io.*;
import java.util.*;

public class D {
    
    public static boolean[]visited;
    public static int[]val;
    public static ArrayList<Integer>[] adj;
    public static ArrayList<Integer>values;
    public static ArrayList<Integer>index;
    
    public static void dfs(int cur) {
        visited[cur] = true;
        index.add(cur);
        values.add(val[cur]);
        for (int v: adj[cur]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
    
    public static void main(String[]args) throws IOException {
        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(x.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        val = new int[n];
        adj = new ArrayList[n];
        st = new StringTokenizer(x.readLine());
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(x.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }
        visited = new boolean[n];
        int[]ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                values = new ArrayList<Integer>();
                index = new ArrayList<Integer>();
                dfs(i);
                Collections.sort(values);
                Collections.sort(index);
                for (int j = 0; j < values.size(); j++) {
                    ans[index.get(j)] = values.get(values.size() - 1 - j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(ans[i] + " ");
        }
        out.println();
        out.flush();
    }
}