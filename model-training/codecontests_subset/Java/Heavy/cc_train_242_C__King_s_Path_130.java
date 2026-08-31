import java.awt.*;
import java.util.*;

public class KingPath {


    public static HashMap<Integer, ArrayList<Point>> hashMap = new HashMap<>();
    public static HashMap<String, Boolean> visited = new HashMap<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x0 = s.nextInt();
        int y0 = s.nextInt();
        int x1 = s.nextInt();
        int y1 = s.nextInt();
        int segments = s.nextInt();
        int r,a,b;
        for (int i = 0; i < segments; i++) {
            r = s.nextInt();
            a = s.nextInt();
            b = s.nextInt();
            ArrayList<Point> points = hashMap.get(r);
            if(points == null) {
                points = new ArrayList<>();
                points.add(new Point(a, b));
                hashMap.put(r, points);
            } else {
                points.add(new Point(a,b));
            }
        }

        System.out.println(solve(new Point(x0, y0), new Point(x1, y1)));
    }

    public static int solve(Point start, Point goal) {
        Queue<State> queue = new ArrayDeque<>();
        queue.add(new State(new Point(start.x, start.y), 0));
        while (!queue.isEmpty()) {
            State currentState = queue.remove();
            if(visited.get(currentState.toString()) == null) {
                if(currentState.state.x == goal.x && currentState.state.y == goal.y) return currentState.moves;
                queue.addAll(getNextMoves(currentState));
                visited.put(currentState.toString(), false);
            }

        }
        return -1;
    }

    public static ArrayList<State> getNextMoves(State curr) {
        Point p = curr.state;
        ArrayList<State> moves = new ArrayList<>();
        if(withinBoard(p.x, p.y + 1) && isValidMove(p.x, p.y + 1)) moves.add(new State(new Point(p.x, p.y + 1), curr.moves + 1));
        if(withinBoard(p.x, p.y - 1) && isValidMove(p.x, p.y - 1)) moves.add(new State(new Point(p.x, p.y - 1), curr.moves + 1));
        if(withinBoard(p.x + 1, p.y) && isValidMove(p.x + 1, p.y)) moves.add(new State(new Point(p.x + 1, p.y), curr.moves + 1));
        if(withinBoard(p.x - 1, p.y) && isValidMove(p.x - 1, p.y)) moves.add(new State(new Point(p.x - 1, p.y), curr.moves + 1));
        if(withinBoard(p.x + 1, p.y + 1) && isValidMove(p.x + 1, p.y + 1)) moves.add(new State(new Point(p.x + 1, p.y + 1), curr.moves + 1));
        if(withinBoard(p.x - 1, p.y + 1) && isValidMove(p.x - 1, p.y + 1)) moves.add(new State(new Point(p.x - 1, p.y + 1), curr.moves + 1));
        if(withinBoard(p.x + 1, p.y - 1) && isValidMove(p.x + 1, p.y - 1)) moves.add(new State(new Point(p.x + 1, p.y - 1), curr.moves + 1));
        if(withinBoard(p.x - 1, p.y - 1) && isValidMove(p.x - 1, p.y - 1)) moves.add(new State(new Point(p.x - 1, p.y - 1), curr.moves + 1));
        return moves;
    }

    private static boolean isValidMove(int x, int y) {
        ArrayList<Point> segments = hashMap.get(x);
        if (segments == null) return false;
        for (Point p : segments) {
            if(withinSegment(y, p)) return true;
        }
        return false;
    }


    public static boolean withinSegment(int x, Point p1) {
        return x >= p1.x && x <= p1.y;
    }

    public static boolean withinBoard(int x, int y) {
        return (x >= 0 && x <= 1000000000) && (y >= 0 && y <= 1000000000);
    }

}

class State {
    Point state;
    int moves;

    public State(Point state, int moves) {
        this.state = state;
        this.moves = moves;
    }

    @Override
    public String toString() {
       return state.x + "" + state.y;
    }
}
