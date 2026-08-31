import java.util.*;

public final class KingPath {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int x0 = s.nextInt();
        int y0 = s.nextInt();
        int x1 = s.nextInt();
        int y1 = s.nextInt();

        int m = s.nextInt();

        HashMap<Integer, ArrayList<point>> allowedCells = new HashMap<>();

        for (int i = 0; i < m; i++) {
            int r = s.nextInt();
            int a = s.nextInt();
            int b = s.nextInt();
            if (allowedCells.containsKey(r))
                allowedCells.get(r).add(new point(a, b));
            else {
                allowedCells.put(r, new ArrayList<point>());
                allowedCells.get(r).add(new point(a, b));
            }
        }

        Queue<point> queue = new LinkedList<>();

        HashSet<point> visited = new HashSet<>();

        int depth = 0;
        int nodesInCurrentLevel = 1;

        queue.add(new point(x0, y0));

        int[] xs = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] ys = { -1, 0, 1, -1, 1, -1, 0, 1 };

        while (!queue.isEmpty()) {
            point node = queue.poll();
            nodesInCurrentLevel--;

            if (node.x == x1 && node.y == y1) {
                System.out.println(depth);
                System.exit(0);
            }

            if (!visited.contains(node)) {
                visited.add(node);
                for (int i = 0; i < 8; i++) {
                    int x = node.x + xs[i];
                    int y = node.y + ys[i];
                    if (isAllowed(x, y, allowedCells)) {
                        queue.add(new point(x, y));
                    }
                }
            }

            if (nodesInCurrentLevel == 0) {
                depth++;
                nodesInCurrentLevel = queue.size();
            }

        }

        System.out.println(-1);
    }

    public static boolean isAllowed(int x, int y, HashMap<Integer, ArrayList<point>> allowedCells) {
        if (!allowedCells.containsKey(x))
            return false;
        else {
            ArrayList<point> limits = allowedCells.get(x);
            for (point p : limits) {
                if (p.x <= y && p.y >= y) {
                    return true;
                }
            }

            return false;
        }
    }
}

class point {
    public int x;
    public int y;

    point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!point.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final point other = (point) obj;
        return (this.x == other.x && this.y == other.y);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 5 * Integer.hashCode(this.x) + Integer.hashCode(this.y);
        return hash;
    }

}