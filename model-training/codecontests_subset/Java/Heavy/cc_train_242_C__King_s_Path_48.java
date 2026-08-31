import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

import static java.lang.Integer.MAX_VALUE;

public class KingPath {
    private static final int SIZE = 1000000000;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static Map<Integer, Collection<Integer>> MOVES;
    private static final List<Position> DIRECTIONS =
            Arrays.asList(new Position(1, 1), new Position(-1, -1),
                    new Position(-1, 1), new Position(1, -1),
                    new Position(0, 1), new Position(0, -1),
                    new Position(1, 0), new Position(-1, 0));

    public static void main(String[] args) throws IOException {
        Position start = new Position(SCANNER.nextInt(), SCANNER.nextInt());
        Position end = new Position(SCANNER.nextInt(), SCANNER.nextInt());
        MOVES = readAllowedMoves();
        bfs(start, end);

    }

    private static Map<Integer, Collection<Integer>> readAllowedMoves() throws IOException {
        int rows = SCANNER.nextInt();
        MOVES = new HashMap<>(rows);
        while (rows-- > 0) {
            int row = SCANNER.nextInt();
            Collection<Integer> movesOrDefault = MOVES.getOrDefault(row, new TreeSet<>());
            IntStream.rangeClosed(SCANNER.nextInt(), SCANNER.nextInt()).forEach(movesOrDefault::add);
            MOVES.put(row, movesOrDefault);
        }
        return MOVES;
    }

    private static void bfs(Position start, Position end) {
        int result = getResult(start, end);
        System.out.println(result == MAX_VALUE ? -1 : result);
    }

    private static int getResult(Position start, Position end) {
        HashSet<Position> visited = new HashSet<>(100000);
        LinkedList<Position> positions = new LinkedList<>();
        positions.addLast(start);
        visited.add(start);
        while (!positions.isEmpty()) {
            Position currentPosition = positions.removeFirst();

            for (Position direction : DIRECTIONS) {
                Position newPosition = new Position(currentPosition, direction);

                if (isOutOfBound(newPosition))
                    continue;
                if (notAllowedToMove(MOVES, newPosition)) {
                    continue;
                }

                if (visited.contains(newPosition)) {
                    continue;
                }

                if (newPosition.equals(end))
                    return newPosition.step;

                visited.add(newPosition);
                positions.addLast(newPosition);
            }
        }
        return MAX_VALUE;
    }

    private static boolean isOutOfBound(Position position) {
        return position.row < 0 || position.row > SIZE || position.column < 0 || position.column > SIZE;
    }

    private static boolean notAllowedToMove(Map<Integer, Collection<Integer>> moves, Position newPosition) {
        Collection<Integer> list = moves.getOrDefault(newPosition.row, Collections.emptySet());
        return !list.contains(newPosition.column);
    }

    private static class Position {
        int row;
        int column;
        int step;

        Position(int row, int column) {
            this(row, column, 0);
        }

        Position(Position position, Position direction) {
            this(position.row + direction.row, position.column + direction.column, position.step + 1);
        }

        Position(int row, int column, int step) {
            this.row = row;
            this.column = column;
            this.step = step;
        }

        @Override
        public boolean equals(Object o) {
            Position position = (Position) o;
            return row == position.row && column == position.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

        @Override
        public String toString() {
            return "Position{" + "row=" + row + ", column=" + column + ", step=" + step + '}';
        }
    }

}