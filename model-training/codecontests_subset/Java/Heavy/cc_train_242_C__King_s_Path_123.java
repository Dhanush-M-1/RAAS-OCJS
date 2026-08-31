import java.util.*;


public class KingsPath {

    static class Point {

        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private final int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    private final int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    private final int MAX_CELLS = 1000000000;
    private HashMap<Integer, ArrayList<Point>> allowedCells;
    private HashMap<String, Integer> cellsCost;

    private boolean isValid(int row, int col) {
        return row >= 0 && col >= 0 && row < MAX_CELLS && col < MAX_CELLS && isAllowedCell(row, col);
    }

    private boolean isAllowedCell(int row, int col) {

        ArrayList<Point> points = allowedCells.get(row);

        if (points == null) {
            return false;
        }

        for (Point point : points) {
            if (col >= point.getX() && col <= point.getY()) {
                return true;
            }
        }
        return false;
    }



    private int bfs(int r0, int c0, int r1, int c1) {
        Queue<Integer> nextToVisit = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        nextToVisit.add(r0);
        nextToVisit.add(c0);
        String initialElement = r0 + " " + c0;
        cellsCost.put(initialElement, 0);
        while (!nextToVisit.isEmpty()) {
            int rowElement = nextToVisit.remove();
            int colElement = nextToVisit.remove();
            String element = rowElement + " " + colElement;
            if (rowElement == r1 && colElement == c1) {
                return cellsCost.get(element);
            }
            if (visited.contains(element)) {
                continue;
            }
            visited.add(element);
            for (int i = 0; i < 8; i++) {
                int row = rowElement + dy[i];
                int col = colElement + dx[i];
                String rowAndCol = row + " " + col;
                if (!isValid(row, col)) {
                    continue;
                }
                nextToVisit.add(row);
                nextToVisit.add(col);
                cellsCost.putIfAbsent(rowAndCol, (cellsCost.get(element) + 1));
            }
        }
        return -1;
    }

    private void begin() {
        Scanner scanner = new Scanner(System.in);
        int x0 = scanner.nextInt();
        int y0 = scanner.nextInt();
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int n = scanner.nextInt();

        allowedCells = new HashMap<>();
        cellsCost = new HashMap<>();


        while (n-- > 0) {
            int row = scanner.nextInt();
            int col1 = scanner.nextInt();
            int col2 = scanner.nextInt();
            if (allowedCells.get(row) == null) {
                ArrayList<Point> points = new ArrayList<>();
                points.add(new Point(col1, col2));
                allowedCells.put(row, points);
            } else {
                allowedCells.get(row).add(new Point(col1, col2));
            }

        }

        int movesNumber = bfs(x0, y0, x1, y1);
        System.out.println(movesNumber);

    }

    public static void main(String[] args) {
        KingsPath path = new KingsPath();
        path.begin();
    }
}
