import java.util.*;

public class CF242_D2_C {
    private static HashSet<Object> allowed;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x0 = scanner.nextInt();
        int y0 = scanner.nextInt();
        Pair start = new Pair(x0, y0);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        Pair end = new Pair(x1, y1);
        int n = scanner.nextInt();
        allowed = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int c = scanner.nextInt();
            int r0 = scanner.nextInt();
            int r1 = scanner.nextInt();
            for (int j = r0; j <= r1; j++) {
                allowed.add(new Pair(c, j));
            }
        }
        if (!allowed.contains(end)) {
            System.out.println("-1");
            return;
        }
        Queue<Pair> graph = new LinkedList<>();
        HashMap<Pair, Integer> levelMap = new HashMap<>();
        graph.add(start);
        levelMap.put(start, 0);
        allowed.remove(start);
        int count = 0;
        while (!graph.isEmpty()) {
            Pair current = graph.remove();
            if (current.equals(end)) {
                System.out.println(levelMap.get(current));
                return;
            }
            count++;
            int dx = current.x + 1;
            int dy = current.y;
            Pair newPair = new Pair(dx, dy);
            if (allowed.contains(newPair) && !graph.contains(newPair)) {
                graph.add(newPair);
                allowed.remove(newPair);
                levelMap.put(newPair, levelMap.get(current) + 1);
            }
            dx = current.x - 1;
            dy = current.y;
            newPair = new Pair(dx, dy);
            if (allowed.contains(newPair) && !graph.contains(newPair)) {
                graph.add(newPair);
                allowed.remove(newPair);
                levelMap.put(newPair, levelMap.get(current) + 1);
            }
            dx = current.x;
            dy = current.y + 1;
            newPair = new Pair(dx, dy);
            if (allowed.contains(newPair) && !graph.contains(newPair)) {
                graph.add(newPair);
                allowed.remove(newPair);
                levelMap.put(newPair, levelMap.get(current) + 1);
            }
            dx = current.x;
            dy = current.y - 1;
            newPair = new Pair(dx, dy);
            if (allowed.contains(newPair) && !graph.contains(newPair)) {
                graph.add(newPair);
                allowed.remove(newPair);
                levelMap.put(newPair, levelMap.get(current) + 1);
            }
            dx = current.x + 1;
            dy = current.y + 1;
            newPair = new Pair(dx, dy);
            if (allowed.contains(newPair) && !graph.contains(newPair)) {
                graph.add(newPair);
                allowed.remove(newPair);
                levelMap.put(newPair, levelMap.get(current) + 1);
            }
            dx = current.x - 1;
            dy = current.y - 1;
            newPair = new Pair(dx, dy);
            if (allowed.contains(newPair) && !graph.contains(newPair)) {
                graph.add(newPair);
                allowed.remove(newPair);
                levelMap.put(newPair, levelMap.get(current) + 1);
            }
            dx = current.x + 1;
            dy = current.y - 1;
            newPair = new Pair(dx, dy);
            if (allowed.contains(newPair) && !graph.contains(newPair)) {
                graph.add(newPair);
                allowed.remove(newPair);
                levelMap.put(newPair, levelMap.get(current) + 1);
            }
            dx = current.x - 1;
            dy = current.y + 1;
            newPair = new Pair(dx, dy);
            if (allowed.contains(newPair) && !graph.contains(newPair)) {
                graph.add(newPair);
                allowed.remove(newPair);
                levelMap.put(newPair, levelMap.get(current) + 1);
            }
        }
        System.out.println("-1");

    }


    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
