import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by darshan on 1/27/19.
 */
public class D691 {
    private static int[] permutation;

    private static List<List<Integer>> adjList;
    private static boolean[] visited;

    private static PriorityQueue<Integer> values;
    private static PriorityQueue<Integer> indices;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        permutation = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            permutation[i] = Integer.parseInt(st.nextToken());
        }

        adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        visited = new boolean[n];
        values = new PriorityQueue<>(Comparator.reverseOrder());
        indices = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                checkPair(i);
                while (!values.isEmpty()) {
                    permutation[indices.poll()] = values.poll();
                }
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(permutation[i] + " ");
        }
        out.close();
    }

    private static void checkPair(int u) {
        visited[u] = true;
        values.add(permutation[u]);
        indices.add(u);
        for (int v : adjList.get(u)) {
            if (!visited[v]) {
                checkPair(v);
            }
        }
    }
}
