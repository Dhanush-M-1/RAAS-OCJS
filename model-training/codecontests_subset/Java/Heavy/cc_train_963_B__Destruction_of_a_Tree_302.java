import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int n;
        StringTokenizer tokenizer;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(in.readLine());
            tokenizer = new StringTokenizer(in.readLine());
        }
        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; ++i) {
            tree[i] = new ArrayList<Integer>();
        }
        int[] parent = new int[n];
        int[] degree = new int[n];
        int root = -1;
        for (int i = 0; i < n; ++i) {
            int p = Integer.parseInt(tokenizer.nextToken()) - 1;
            if (p == -1) {
                root = i;
                continue;
            }
            parent[i] = p;
            degree[p]++;
            degree[i]++;
            tree[i].add(p);
            tree[p].add(i);
        }
        Solution solver = new Solution();
        System.out.println(solver.solve(tree, root, parent, degree));
    }
    
    public String solve(List<Integer>[] tree, int root, int[] parent, int[] degree) {
        if (tree.length % 2 == 0) {
            return "NO";
        }
        List<Integer> order = new ArrayList<>(tree.length);
        topSort(root, -1, tree, order);
        List<Integer> removeOrder = new ArrayList<>(tree.length);
        List<Integer> rest = new ArrayList<>();
        for (int v : order) {
            if (degree[v] % 2 == 0) {
                removeOrder.add(v + 1);
                degree[parent[v]]--;
            } else {
                rest.add(v + 1);
            }
        }
        Collections.reverse(rest);
        removeOrder.addAll(rest);
        return removeOrder
            .stream()
            .map(i -> "" + i)
            .collect(Collectors.joining("\n", "YES\n", ""));
    }
    
    private void topSort(int v, int p, List<Integer>[] tree, List<Integer> order) {
        for (int c : tree[v]) {
            if (c != p) {
                topSort(c, v, tree, order);
            }
        }
        order.add(v);
    }
}