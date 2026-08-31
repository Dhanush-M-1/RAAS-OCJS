import javafx.util.Pair;

import java.util.*;

public class KingsPath {

    private static class Node {
        int x, y, moves;

        Node(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
    }

    private static int dfs(int x0, int y0, int x1, int y1, HashMap<Integer, ArrayList<Pair<Integer, Integer>>> map) {
        int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
        int[] dy = {1, 0, -1, 0, 1, -1, -1, 1};

        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x0, y0, 0));
        visited.add(new Pair<>(x0, y0));

        while (!queue.isEmpty()) {
            Node top = queue.poll();
            if (top == null) {
                return -1;
            }

            if (top.x == x1 && top.y == y1) {
                return top.moves;
            }

            for (int i = 0; i < 8; i++) {
                int x = top.x + dx[i];
                int y = top.y + dy[i];

                if (visited.contains(new Pair<>(x, y))) {
                    continue;
                }

                if (x >= 1 && x <= Math.pow(10, 9) && y >= 1 && y <= Math.pow(10, 9)) {
                    if (map.containsKey(x)) {
                        ArrayList<Pair<Integer, Integer>> list = map.get(x);

                        for (Pair<Integer, Integer> pair : list) {
                            if (y >= pair.getKey() && y <= pair.getValue()) {
                                queue.add(new Node(x, y, top.moves+1));
                                visited.add(new Pair<>(x, y));
                                break;
                            }
                        }
                    }
                }
            }

            if (queue.size() > Math.pow(10, 5)) {
                return -1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x0 = scanner.nextInt(), y0 = scanner.nextInt(), x1 = scanner.nextInt(), y1 = scanner.nextInt();
        int n = scanner.nextInt();

        // maps the row to the list of columns in the row that are allowed
        HashMap<Integer, ArrayList<Pair<Integer, Integer>>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int r = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            ArrayList<Pair<Integer, Integer>> list;
            if (map.containsKey(r)) {
                list = map.get(r);
            }
            else {
                list = new ArrayList<>();
            }
            list.add(new Pair<>(a, b));
            map.put(r, list);
        }

        int ans = dfs(x0, y0, x1, y1, map);
        System.out.println(ans);
    }
}
