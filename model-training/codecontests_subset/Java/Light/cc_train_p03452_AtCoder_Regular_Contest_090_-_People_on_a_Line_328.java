import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[]$) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt() - 1;
            int d = scanner.nextInt();
            map.computeIfAbsent(l, key -> new HashMap<>()).put(r, d);
            map.computeIfAbsent(r, key -> new HashMap<>()).put(l, -d);
            unionFind.unite(l, r);
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int parent = unionFind.root(i);
            if (!visited.contains(parent) && map.containsKey(parent)) {
                visited.add(parent);
                Map<Integer, Integer> pos = new HashMap<>();
                pos.put(parent, 0);
                Deque<Integer> deque = new ArrayDeque<>();
                deque.add(parent);

                while (!deque.isEmpty()) {
                    int j = deque.poll();
                    Map<Integer, Integer> dist = map.get(j);
                    for (Map.Entry<Integer, Integer> entry : dist.entrySet()) {
                        if (!pos.containsKey(entry.getKey())) {
                            pos.put(entry.getKey(), pos.get(j) + entry.getValue());
                            deque.add(entry.getKey());
                        } else if (pos.get(entry.getKey()) != pos.get(j) + entry.getValue()) {
                            System.out.println("No");
                            return;
                        }
                    }
                }
            }
        }

        System.out.println("Yes");
    }

    static class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            size = new int[n];
            Arrays.fill(size, 1);
        }

        public int root(int n) {
            while (parent[n] != n) {
                n = parent[n] = parent[parent[n]];
            }
            return n;
        }

        public void unite(int x, int y) {
            x = root(x);
            y = root(y);
            if (x != y) {
                if (size[x] < size[y]) {
                    size[y] += size[x];
                    parent[y] = x;
                } else {
                    size[x] += size[y];
                    parent[x] = y;
                }
            }
        }

        public boolean same(int x, int y) {
            return root(x) == root(y);
        }

        public int size(int x) {
            return size[root(x)];
        }
    }
}