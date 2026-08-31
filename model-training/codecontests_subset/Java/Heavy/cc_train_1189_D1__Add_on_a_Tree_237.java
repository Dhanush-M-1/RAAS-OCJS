import java.util.*;
public class Main {
    public static class UnweightedGraph {
        public int n, e;
        public TreeSet<Integer>[] adj;
        public UnweightedGraph(int n) {
            this.n = n;
            adj = new TreeSet[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new TreeSet<>();
            }
        }
        public void addEdge(int a, int b) {
            adj[a].add(b);
            e++;
        }
        public void addBiEdge(int a, int b) {
            addEdge(a, b);
            addEdge(b, a);
        }
        public boolean hasEdge(int a, int b) {
            return adj[a].contains(b);
        }
        public boolean hasBiEdge(int a, int b) {
            return hasEdge(a, b) && hasEdge(b, a);
        }
        public boolean deleteEdge(int a, int b) {
            if (!hasEdge(a, b)) {
                return false;
            }
            adj[a].remove(b);
            e--;
            return true;
        }
        public boolean deleteBiEdge(int a, int b) {
            if (!hasBiEdge(a, b)) {
                return false;
            }
            deleteEdge(a, b);
            deleteEdge(b, a);
            return true;
        }
        public int degree(int i) {
            return adj[i].size();
        }
        public String toString() {
            String res = "";
            for (int i = 0; i < n; i++) {
                res += i + ": ";
                for (int x : adj[i]) {
                    res += x + " ";
                }
                res += "\n";
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        UnweightedGraph graph = new UnweightedGraph(n);
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            graph.addBiEdge(a, b);
        }
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (graph.degree(i) == 2) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "YES" : "NO");
    }
}